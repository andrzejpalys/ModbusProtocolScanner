package com.andrzejpalys.ModbusProtocolScanner.connection;

public interface Connector {
    void connect();
    void disconnect();
    boolean isConnected();
    void transmitFrame();
    byte[] getInputFrame();
    byte[] getOutputFrame();
}