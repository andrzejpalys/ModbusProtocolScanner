package com.andrzejpalys.ModbusProtocolScanner.connection;

public interface Observer {
    void update(String formatedModbusOutputFrame, String formatedModbusInputFrame, int modbusOutputFrameCounter, int modbusInputFrameCounter, boolean isModbusError);
}