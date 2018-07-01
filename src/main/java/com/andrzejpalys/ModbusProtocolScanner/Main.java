package com.andrzejpalys.ModbusProtocolScanner;

import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.IconManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.UserInterfaceDefaultsManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Locale.setDefault(new Locale("en", "US"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/UserInterface.fxml"));
        primaryStage.setTitle(UserInterfaceDefaultsManager.getWindowTitle());
        primaryStage.setScene(new Scene(root, UserInterfaceDefaultsManager.getWindowWidth(), UserInterfaceDefaultsManager.getWindowHeight()));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.getIcons().add(IconManager.getApplicationIcon());
    }

    public static void main(String[] args) {
        launch(args);
    }
}