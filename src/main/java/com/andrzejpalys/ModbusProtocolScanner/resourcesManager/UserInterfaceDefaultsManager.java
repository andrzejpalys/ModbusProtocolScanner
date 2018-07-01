package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.BLACK;

public class UserInterfaceDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/UserInterfaceDefaults_en_US");
    }

    public static String getConnectionIpAddressRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionIpAddressRegex");
    }

    public static String getConnectionPortRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionPortRegex");
    }

    public static String getConnectionSchedulePeriodRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionSchedulePeriodRegex");
    }

    public static String getModbusRegisterRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("modbusRegisterRegex");
    }

    public static String getModbusLengthRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("modbusLengthRegex");
    }

    public static String getModbusDeviceIdRegex() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("modbusDeviceIdRegex");
    }

    public static String getConnectionStatusLabelIfConnected() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionStatusLabelIfConnected");
    }

    public static String getConnectionStatusLabelIfDisconnected() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionStatusLabelIfDisconnected");
    }

    public static String getConnectionButtonTextIfConnected() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionButtonTextIfConnected");
    }

    public static String getConnectionButtonTextIfDisconnected() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionButtonTextIfDisconnected");
    }

    public static String getLeftBracket() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("leftBracket");
    }

    public static String getRightBracket() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("rightBracket");
    }

    public static String getTimeStampSeparator() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("timeStampSeparator");
    }

    public static String getDefaultTimeFormat() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("defaultTimeFormat");
    }

    public static String getNewLineSeparator() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("newLineSeparator");
    }

    public static Color getNormalInputMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("normalInputMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static Color getErrorInputMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("errorInputMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static Color getOutputMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("outputMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static Color getDisconnectedMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("disconnectedMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static Color getConnectedMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("connectedMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static Color getConnectionLostMessageColor() {
        try {
            return Color.web(UserInterfaceDefaultsManager.getResourceBundle().getString("connectionLostMessageColor"));
        } catch (Exception e) {
            return BLACK;
        }
    }

    public static String getConnectedMessageText() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectedMessageText");
    }

    public static String getDisconnectedMessageText() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("disconnectedMessageText");
    }

    public static String getConnectionLostMessageText() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("connectionLostMessageText");
    }

    public static String getOutputMessageTitle() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("outputMessageTitle");
    }

    public static String getInputMessageTitle() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("inputMessageTitle");
    }

    public static String getWindowTitle() {
        return UserInterfaceDefaultsManager.getResourceBundle().getString("windowTitle");
    }

    public static int getWindowHeight() {
        return Integer.parseInt(UserInterfaceDefaultsManager.getResourceBundle().getString("windowHeight"));
    }

    public static int getWindowWidth() {
        return Integer.parseInt(UserInterfaceDefaultsManager.getResourceBundle().getString("windowWidth"));
    }

    public static int getMessageLength() {
        return Integer.parseInt(UserInterfaceDefaultsManager.getResourceBundle().getString("messageLength"));
    }
}