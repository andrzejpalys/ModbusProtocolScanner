package com.andrzejpalys.ModbusProtocolScanner.graphic.popups;

import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.IconManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.AlertWindowDefultsManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    private Stage window;
    private Label errorMessage;
    private Button closeButton;
    private VBox layout;
    private Scene scene;

    public AlertWindow() {
        window = new Stage();
        errorMessage = new Label();
        closeButton = new Button();
        layout = new VBox();
        scene = new Scene(layout);
    }

    public void setUp() {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(AlertWindowDefultsManager.getWindowTitle());
        window.setWidth(AlertWindowDefultsManager.getWidth());
        window.setHeight(AlertWindowDefultsManager.getHeight());
        window.setResizable(false);
        window.getIcons().add(IconManager.getErrorIcon());
        errorMessage.setText(AlertWindowDefultsManager.getErrorMessage());
        closeButton.setText(AlertWindowDefultsManager.getCloseButtonLabel());
        closeButton.setOnAction(e -> window.close());
        layout.setSpacing(AlertWindowDefultsManager.getSpacing());
        layout.getChildren().addAll(errorMessage, closeButton);
        layout.setAlignment(Pos.CENTER);
        window.setScene(scene);
    }

    public void display() {
        window.showAndWait();
    }
}
