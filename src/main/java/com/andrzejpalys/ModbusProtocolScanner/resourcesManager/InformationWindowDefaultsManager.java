package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class InformationWindowDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/InformationWindowDefaults_en_US");
    }

    public static String getWindowTitle() {
        return InformationWindowDefaultsManager.getResourceBundle().getString("windowTitle");
    }

    public static String getHeader() {
        return InformationWindowDefaultsManager.getResourceBundle().getString("header");
    }

    public static String getAuthor() {
        return InformationWindowDefaultsManager.getResourceBundle().getString("author");
    }

    public static String getContact() {
        return InformationWindowDefaultsManager.getResourceBundle().getString("contact");
    }

    public static String getCloseButtonLabel() {
        return InformationWindowDefaultsManager.getResourceBundle().getString("closeButtonLabel");
    }

    public static int getWidth() {
        return Integer.parseInt(InformationWindowDefaultsManager.getResourceBundle().getString("width"));
    }

    public static int getHeight() {
        return Integer.parseInt(InformationWindowDefaultsManager.getResourceBundle().getString("height"));
    }

    public static int getSpacing() {
        return Integer.parseInt(InformationWindowDefaultsManager.getResourceBundle().getString("spacing"));
    }
}
