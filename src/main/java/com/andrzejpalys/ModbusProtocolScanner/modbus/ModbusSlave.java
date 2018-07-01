package com.andrzejpalys.ModbusProtocolScanner.modbus;

import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ModbusSlaveDefaultsManager;

public class ModbusSlave {

    private int modbusDeviceId;
    private int modbusRegister;
    private int modbusLength;
    private int modbusFunction;
    private byte modbusOutputFrame[];

    public ModbusSlave() {
        this.modbusDeviceId = ModbusSlaveDefaultsManager.getDefaultModbusDeviceId();
        this.modbusRegister = ModbusSlaveDefaultsManager.getDefaultModbusRegister();
        this.modbusLength = ModbusSlaveDefaultsManager.getDefaultModbusLength();
        this.modbusFunction = ModbusSlaveDefaultsManager.getDefaultModbusFunction();
        modbusOutputFrame = new byte[ModbusSlaveDefaultsManager.getDefaultModbusOutputFrameSize()];
        buildModbusOutputFrame();
    }

    public void updateModbusParameters(int modbusDeviceId, int modbusRegister, int modbusLength, int modbusFunction) {
        this.modbusDeviceId = modbusDeviceId;
        this.modbusRegister = modbusRegister;
        this.modbusLength = modbusLength;
        this.modbusFunction = modbusFunction;
        buildModbusOutputFrame();
    }

    private void buildModbusOutputFrame() {
        modbusOutputFrame[0]  = 0;
        modbusOutputFrame[1]  = 0;
        modbusOutputFrame[2]  = 0;
        modbusOutputFrame[3]  = 0;
        modbusOutputFrame[4]  = 0;
        modbusOutputFrame[5]  = 6;
        modbusOutputFrame[6]  = (byte)modbusDeviceId;
        modbusOutputFrame[7]  = (byte)modbusFunction;
        modbusOutputFrame[8]  = (byte)(modbusRegister >> 8);
        modbusOutputFrame[9]  = (byte)(modbusRegister & 0xff);
        modbusOutputFrame[10] = (byte)(modbusLength -1 >> 8);
        modbusOutputFrame[11] = (byte)(modbusLength -1 & 0xff);
    }

    public byte[] getModbusOutputFrame() {
        return modbusOutputFrame;
    }
}