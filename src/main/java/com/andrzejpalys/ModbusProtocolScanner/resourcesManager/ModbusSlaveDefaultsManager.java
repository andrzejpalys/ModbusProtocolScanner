package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class ModbusSlaveDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/ModbusSlaveDefaults_en_US");
    }

    public static int getDefaultModbusDeviceId() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusDeviceId"));
    }

    public static String getDefaultModbusDeviceIdAsString() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusDeviceId");
    }

    public static int getDefaultModbusRegister() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusRegister"));
    }

    public static String getDefaultModbusRegisterAsString() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusRegister");
    }

    public static int getDefaultModbusLength() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusLength"));
    }

    public static String getDefaultModbusLengthAsString() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusLength");
    }

    public static int getDefaultModbusFunction() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunction"));
    }

    public static int getDefaultModbusOutputFrameSize() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusOutputFrameSize"));
    }

    public static int getDefaultModbusInputFrameSize() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusInputFrameSize"));
    }

    public static String getDefaultModbusFunctionCode01() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode01");
    }

    public static String getDefaultModbusFunctionCode02() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode02");
    }

    public static String getDefaultModbusFunctionCode03() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode03");
    }

    public static String getDefaultModbusFunctionCode04() {
        return ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode04");
    }

    public static int getDefaultModbusFunctionCode01Value() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode01Value"));
    }

    public static int getDefaultModbusFunctionCode02Value() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode02Value"));
    }

    public static int getDefaultModbusFunctionCode03Value() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode03Value"));
    }

    public static int getDefaultModbusFunctionCode04Value() {
        return Integer.parseInt(ModbusSlaveDefaultsManager.getResourceBundle().getString("defaultModbusFunctionCode04Value"));
    }
}
