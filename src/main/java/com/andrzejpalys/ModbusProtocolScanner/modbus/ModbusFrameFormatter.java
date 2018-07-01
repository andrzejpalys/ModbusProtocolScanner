package com.andrzejpalys.ModbusProtocolScanner.modbus;

import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ModbusFrameFormatterDefaultsManager;
import java.util.Formatter;

public class ModbusFrameFormatter {

    private ModbusFrameFormatter() {}

    public static boolean isModbusError(byte[] modbusInputFrame) {
        return (0 != (modbusInputFrame[7] & 0x80));
    }

    public static boolean isNoModbusResponse(byte[] modbusInputFrame) {
        return (modbusInputFrame[0] == 127);
    }

    public static String getFormatedModbusOutputFrame(byte[] modbusOutputFrame) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < modbusOutputFrame[5]+6; i++) {
            formatter.format(ModbusFrameFormatterDefaultsManager.getModbusOutputFrameFormat(), modbusOutputFrame[i]);
        }
        return formatter.toString();
    }

    public static String getFormatedModbusInputFrame(byte[] modbusInputFrame) {
        if(isNoModbusResponse(modbusInputFrame)) {
            return getNoModbusResponseFrame();
        } else if(isModbusError(modbusInputFrame)) {
            return getFormatedErrorModbusInputFrame(modbusInputFrame);
        } else {
            return getFormatedRegularModbusInputFrame(modbusInputFrame);
        }
    }

    private static String getNoModbusResponseFrame() {
        return ModbusFrameFormatterDefaultsManager.getModbusNoResponseTitle();
    }

    private static String getFormatedRegularModbusInputFrame(byte[] modbusInputFrame) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < ((modbusInputFrame[5]+6)&0xFF); i++) {
            formatter.format(ModbusFrameFormatterDefaultsManager.getModbusInputFrameFormat(), modbusInputFrame[i]);
        }
        return formatter.toString();
    }

    private static String getFormatedErrorModbusInputFrame(byte[] modbusInputFrame) {
        return ModbusFrameFormatterDefaultsManager.getModbusErrorTitle() +
                getModbusErrorCode(modbusInputFrame) +
                ModbusFrameFormatterDefaultsManager.getModbusErrorNameSeparator() +
                getModbusErrorName(modbusInputFrame);
    }


    static int getModbusErrorCode(byte[] modbusInputFrame) {
        return modbusInputFrame[8];
    }

    static String getModbusErrorName(byte[] modbusInputFrame) {
        int modbusErrorCode = getModbusErrorCode(modbusInputFrame);
        if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode1Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode1();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode2Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode2();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode3Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode3();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode4Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode4();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode5Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode5();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode6Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode6();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode7Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode7();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode8Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode8();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode10Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode10();
        } else if(modbusErrorCode == ModbusFrameFormatterDefaultsManager.getModbusErrorCode11Value()) {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorCode11();
        } else {
            return ModbusFrameFormatterDefaultsManager.getmodbusErrorUnknown();
        }
    }
}