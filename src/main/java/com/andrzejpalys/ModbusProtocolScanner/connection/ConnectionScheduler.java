package com.andrzejpalys.ModbusProtocolScanner.connection;

import com.andrzejpalys.ModbusProtocolScanner.modbus.ModbusFrameFormatter;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ConnectionManagerDefaultsManager;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ConnectionScheduler implements Observable, Scheduler {
    private Timer timer;
    private ArrayList<Observer> observersList;
    private String formatedModbusOutputFrame;
    private String formatedModbusInputFrame;
    private int modbusOutputFrameCounter;
    private int modbusInputFrameCounter;
    private boolean isError;
    private int defaultScheduleDelay;
    private int connectionSchedulePeriod;
    private Connector connector;

    public ConnectionScheduler(Connector connector) {
        this.connector = connector;
        defaultScheduleDelay = ConnectionManagerDefaultsManager.getDefaultScheduleDelay();
        connectionSchedulePeriod = ConnectionManagerDefaultsManager.getDefaultConnectionSchedulePeriod();
        observersList = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    public void informObservers() {
        for(Observer observer : observersList) {
            observer.update(formatedModbusOutputFrame, formatedModbusInputFrame, modbusOutputFrameCounter, modbusInputFrameCounter, isError);
        }
    }

    public void update(int connectionSchedulePeriod) {
        this.connectionSchedulePeriod = connectionSchedulePeriod;
    }

    public void start() {
        connector.connect();
        timer = new Timer();
        if(connector.isConnected()) {
            timer.schedule(new RemindTask(), defaultScheduleDelay, connectionSchedulePeriod);
        }
    }

    public void stop() {
        timer.cancel();
    }

    public void disconnect() {
        connector.disconnect();
    }

    public class RemindTask extends TimerTask {

        public void run() {
            if (connector.isConnected()) {
                transmitModusOutputFrame();
                informObservers();
            } else {
                stop();
            }
        }

        private void transmitModusOutputFrame() {
            connector.transmitFrame();
            formatedModbusOutputFrame = ModbusFrameFormatter.getFormatedModbusOutputFrame(connector.getOutputFrame());
            formatedModbusInputFrame = ModbusFrameFormatter.getFormatedModbusInputFrame(connector.getInputFrame());
            isError = (ModbusFrameFormatter.isModbusError(connector.getInputFrame()) | ModbusFrameFormatter.isNoModbusResponse(connector.getInputFrame()));
            if(!isError) modbusInputFrameCounter++;
            modbusOutputFrameCounter++;
        }
    }
}