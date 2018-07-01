package com.andrzejpalys.ModbusProtocolScanner.fasade;

import com.andrzejpalys.ModbusProtocolScanner.connection.ConnectionScheduler;
import com.andrzejpalys.ModbusProtocolScanner.connection.ConnectorManager;
import com.andrzejpalys.ModbusProtocolScanner.modbus.ModbusSlave;
import com.andrzejpalys.ModbusProtocolScanner.connection.Observer;

public class ModbusMaster {

    private ModbusSlave modbusSlave;
    private ConnectorManager connectionManager;
    private ConnectionScheduler connectionScheduler;

    public ModbusMaster() {
        modbusSlave = new ModbusSlave();
        connectionManager = new ConnectorManager(modbusSlave);
        connectionScheduler = new ConnectionScheduler(connectionManager);
    }

    public void updateModbusParameters(int modbusDevideId, int modbusRegister, int modbusLength, int modbusFunction) {
        modbusSlave.updateModbusParameters(modbusDevideId, modbusRegister, modbusLength, modbusFunction);
    }

    public void updateConnectionParameters(String connectionIpAddress, int connectionPort) {
        connectionManager.updateConnectionParameters(connectionIpAddress, connectionPort);
    }

    public void updateScheduler(int connectionSchedulePeriod) {
        connectionScheduler.update(connectionSchedulePeriod);
    }

    public void connect() {
        connectionScheduler.start();
    }

    public void disconnect() {
        connectionScheduler.stop();
        connectionScheduler.disconnect();
    }

    public boolean isConnected() {
        return connectionManager.isConnected();
    }

    public void registerObserver(Observer observer) {
        connectionScheduler.registerObserver(observer);
    }
}