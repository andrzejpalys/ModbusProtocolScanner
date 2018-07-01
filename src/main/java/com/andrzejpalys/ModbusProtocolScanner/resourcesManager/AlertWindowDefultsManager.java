package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class AlertWindowDefultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/AlertWindowDefaults_en_US");
    }

    public static String getWindowTitle() {
        return AlertWindowDefultsManager.getResourceBundle().getString("windowTitle");
    }

    public static String getErrorMessage() {
        return AlertWindowDefultsManager.getResourceBundle().getString("errorMessage");
    }

    public static String getCloseButtonLabel() {
        return AlertWindowDefultsManager.getResourceBundle().getString("closeButtonLabel");
    }

    public static int getWidth() {
        return Integer.parseInt(AlertWindowDefultsManager.getResourceBundle().getString("width"));
    }

    public static int getHeight() {
        return Integer.parseInt(AlertWindowDefultsManager.getResourceBundle().getString("height"));
    }

    public static int getSpacing() {
        return Integer.parseInt(AlertWindowDefultsManager.getResourceBundle().getString("spacing"));
    }
}