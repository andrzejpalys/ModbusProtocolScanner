package com.andrzejpalys.ModbusProtocolScanner.connection;

import com.andrzejpalys.ModbusProtocolScanner.modbus.ModbusSlave;
import com.andrzejpalys.ModbusProtocolScanner.graphic.popups.AlertWindow;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ConnectionManagerDefaultsManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ModbusFrameFormatterDefaultsManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ModbusSlaveDefaultsManager;
import java.io.IOException;
import java.io.*;
import java.net.*;

public class ConnectorManager implements Connector {
    private String connectionIpAddress;
    private int connectionPort;
    private final Object socketLock;
    private Socket socket;
    private OutputStream outputStream;
    private FilterInputStream filterInputStream;
    private byte[] modbusInputFrame;
    private byte[] modbusOutputFrame;
    private ModbusSlave modbusSlave;
    private int defaultOutputStreamOffset;
    private int defaultOutputFrameSize;
    private int defaultInputStreamOffset;
    private int defaultInputFrameSize;
    private AlertWindow alertWindow;

    public ConnectorManager(ModbusSlave modbusSlave) {
        this.connectionIpAddress = ConnectionManagerDefaultsManager.getDefaultConnectionIpAddress();
        this.connectionPort = ConnectionManagerDefaultsManager.getDedaultConnectionPort();
        this.modbusSlave = modbusSlave;
        modbusInputFrame = new byte[ModbusSlaveDefaultsManager.getDefaultModbusInputFrameSize()];
        modbusOutputFrame = new byte[ModbusSlaveDefaultsManager.getDefaultModbusOutputFrameSize()];
        socketLock = new Object();
        defaultOutputStreamOffset = ConnectionManagerDefaultsManager.getDefaultOutputStreamOffset();
        defaultOutputFrameSize = ModbusSlaveDefaultsManager.getDefaultModbusOutputFrameSize();
        defaultInputStreamOffset = ConnectionManagerDefaultsManager.getDefaultInputStreamOffset();
        defaultInputFrameSize = ModbusSlaveDefaultsManager.getDefaultModbusInputFrameSize();
        alertWindow = new AlertWindow();
        alertWindow.setUp();
    }

    public void updateConnectionParameters(String connectionIpAddress, int connectionPort) {
        this.connectionIpAddress = connectionIpAddress;
        this.connectionPort = connectionPort;
    }

    public void connect() {
        synchronized (socketLock) {
            try {
                socket = new Socket(connectionIpAddress, connectionPort);
                outputStream = socket.getOutputStream();
                filterInputStream = new BufferedInputStream(socket.getInputStream());
            } catch (IOException e) {
                alertWindow.display();
            }
        }
    }

    public void disconnect() {
        synchronized (socketLock) {
            try {
                socket.shutdownInput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        synchronized (socketLock) {
            return (socket != null && !socket.isClosed());
        }
    }

    public void transmitFrame() {
        try {
            modbusOutputFrame = modbusSlave.getModbusOutputFrame();
            outputStream.write(modbusOutputFrame, defaultOutputStreamOffset, defaultOutputFrameSize);
            if (filterInputStream.available() > 0) {
                //noinspection ResultOfMethodCallIgnored
                filterInputStream.read(modbusInputFrame, defaultInputStreamOffset, defaultInputFrameSize);
            } else {
                modbusInputFrame[0] = ModbusFrameFormatterDefaultsManager.getModbusFrameSize();
            }
        } catch (IOException e) {
            if(isConnected()) {
                disconnect();
            }
        }
    }

    public byte[] getOutputFrame() {
        return modbusOutputFrame;
    }

    public byte[] getInputFrame() {
        return modbusInputFrame;
    }
}