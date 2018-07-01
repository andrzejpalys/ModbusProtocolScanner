package com.andrzejpalys.ModbusProtocolScanner.graphic.popups;

import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.IconManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.InformationWindowDefaultsManager;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.geometry.Pos;

public class InformationWindow {
    private Stage window;
    private Label header;
    private Label author;
    private Label contact;
    private Button closeButton;
    private VBox layout;
    private Scene scene;

    public InformationWindow() {
        window = new Stage();
        header = new Label();
        author = new Label();
        contact = new Label();
        closeButton = new Button();
        layout = new VBox();
        scene = new Scene(layout);
    }

    public void setUp() {
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(InformationWindowDefaultsManager.getWindowTitle());
        window.setWidth(InformationWindowDefaultsManager.getWidth());
        window.setHeight(InformationWindowDefaultsManager.getHeight());
        window.setResizable(false);
        window.getIcons().add(IconManager.getInformationIcon());
        header.setText(InformationWindowDefaultsManager.getHeader());
        author.setText(InformationWindowDefaultsManager.getAuthor());
        contact.setText(InformationWindowDefaultsManager.getContact());
        closeButton.setText(InformationWindowDefaultsManager.getCloseButtonLabel());
        closeButton.setOnAction(e -> window.close());
        layout.setSpacing(InformationWindowDefaultsManager.getSpacing());
        layout.getChildren().addAll(header, author, contact, closeButton);
        layout.setAlignment(Pos.CENTER);
        window.setScene(scene);
    }

    public void display() {
        window.showAndWait();
    }
}