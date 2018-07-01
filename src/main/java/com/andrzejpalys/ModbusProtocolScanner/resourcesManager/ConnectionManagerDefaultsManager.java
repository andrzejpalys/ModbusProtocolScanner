package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class ConnectionManagerDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/ConnectionManagerDefaults_en_US");
    }

    public static String getDefaultConnectionIpAddress() {
        return ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultConnectionIpAddress");
    }

    public static int getDedaultConnectionPort() {
        return Integer.parseInt(ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultConnectionPort"));
    }

    public static int getDefaultConnectionSchedulePeriod() {
        return Integer.parseInt(ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultConnectionSchedulePeriod"));
    }

    public static int getDefaultInputStreamOffset() {
        return Integer.parseInt(ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultInputStreamOffset"));
    }

    public static int getDefaultOutputStreamOffset() {
        return Integer.parseInt(ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultOutputStreamOffset"));
    }

    public static int getDefaultScheduleDelay() {
        return Integer.parseInt(ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultScheduleDelay"));
    }

    public static String getDefaultConnectionIpFirstOctet() {
        String connectionIpAddress = ConnectionManagerDefaultsManager.getDefaultConnectionIpAddress();
        String [] connectionIpOctets = connectionIpAddress.split("\\.");
        return connectionIpOctets[0];
    }

    public static String getDefaultConnectionIpSecondOctet() {
        String connectionIpAddress = ConnectionManagerDefaultsManager.getDefaultConnectionIpAddress();
        String [] connectionIpOctets = connectionIpAddress.split("\\.");
        return connectionIpOctets[1];
    }

    public static String getDefaultConnectionIpThirdOctet() {
        String connectionIpAddress = ConnectionManagerDefaultsManager.getDefaultConnectionIpAddress();
        String [] connectionIpOctets = connectionIpAddress.split("\\.");
        return connectionIpOctets[2];
    }

    public static String getDefaultConnectionIpFourthOctet() {
        String connectionIpAddress = ConnectionManagerDefaultsManager.getDefaultConnectionIpAddress();
        String [] connectionIpOctets = connectionIpAddress.split("\\.");
        return connectionIpOctets[3];
    }

    public static String getDedaultConnectionPortAsString() {
        return ConnectionManagerDefaultsManager.getResourceBundle().getString("defaultConnectionPort");
    }

    public static String getConnectionIpAddressSeparator() {
        return ConnectionManagerDefaultsManager.getResourceBundle().getString("connectionIpAddressSeparator");
    }
}