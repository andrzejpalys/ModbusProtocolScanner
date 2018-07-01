package com.andrzejpalys.ModbusProtocolScanner.resourcesManager;

import java.util.ResourceBundle;
import javafx.scene.image.Image;

public class IconManager {

    private static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("bundle/IconUrl_en_US");
    }

    public static Image getApplicationIcon() {
        return new Image(IconManager.getResourceBundle().getString("applicationIconUrl"));
    }

    public static Image getErrorIcon() {
        return new Image(IconManager.getResourceBundle().getString("errorIconUrl"));
    }

    public static Image getInformationIcon() {
        return new Image(IconManager.getResourceBundle().getString("informationIconUrl"));
    }
}
