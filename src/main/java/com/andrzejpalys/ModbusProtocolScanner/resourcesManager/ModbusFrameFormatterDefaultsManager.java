package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class ModbusFrameFormatterDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/ModbusFrameFormatterDefaults_en_US");
    }

    public static String getmodbusErrorCode1() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode1");
    }

    public static String getmodbusErrorCode2() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode2");
    }

    public static String getmodbusErrorCode3() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode3");
    }

    public static String getmodbusErrorCode4() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode4");
    }

    public static String getmodbusErrorCode5() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode5");
    }

    public static String getmodbusErrorCode6() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode6");
    }

    public static String getmodbusErrorCode7() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode7");
    }

    public static String getmodbusErrorCode8() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode8");
    }

    public static String getmodbusErrorCode10() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode10");
    }

    public static String getmodbusErrorCode11() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode11");
    }

    public static String getmodbusErrorUnknown() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorUnknown");
    }

    public static String getModbusInputFrameFormat() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusInputFrameFormat");
    }

    public static String getModbusOutputFrameFormat() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusOutputFrameFormat");
    }

    public static String getModbusErrorTitle() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorTitle");
    }

    public static String getModbusErrorNameSeparator() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorNameSeparator");
    }

    public static int getModbusErrorCode1Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode1Value"));
    }

    public static int getModbusErrorCode2Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode2Value"));
    }

    public static int getModbusErrorCode3Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode3Value"));
    }

    public static int getModbusErrorCode4Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode4Value"));
    }

    public static int getModbusErrorCode5Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode5Value"));
    }

    public static int getModbusErrorCode6Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode6Value"));
    }

    public static int getModbusErrorCode7Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode7Value"));
    }

    public static int getModbusErrorCode8Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode8Value"));
    }

    public static int getModbusErrorCode10Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode10Value"));
    }

    public static int getModbusErrorCode11Value() {
        return Integer.parseInt(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusErrorCode11Value"));
    }

    public static String getModbusNoResponseTitle() {
        return ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusNoResponseTitle");
    }

    public static byte getModbusFrameSize() {
        return Byte.parseByte(ModbusFrameFormatterDefaultsManager.getResourceBundle().getString("modbusFrameSize"));
    }
}
