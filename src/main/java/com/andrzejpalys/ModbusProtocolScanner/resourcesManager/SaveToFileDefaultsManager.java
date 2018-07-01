package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;

public class SaveToFileDefaultsManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/SaveToFileDefaults_en_US");
    }

    public static String getDescription() {
        return SaveToFileDefaultsManager.getResourceBundle().getString("description");
    }

    public static String getExtenion() {
        return SaveToFileDefaultsManager.getResourceBundle().getString("extension");
    }

}