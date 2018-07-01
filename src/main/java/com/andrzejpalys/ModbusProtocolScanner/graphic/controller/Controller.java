package com.andrzejpalys.ModbusProtocolScanner.graphic.controller;

import com.andrzejpalys.ModbusProtocolScanner.connection.Observer;
import com.andrzejpalys.ModbusProtocolScanner.fasade.ModbusMaster;
import com.andrzejpalys.ModbusProtocolScanner.graphic.popups.InformationWindow;
import com.andrzejpalys.ModbusProtocolScanner.log.SaveToFile;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ConnectionManagerDefaultsManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.ModbusSlaveDefaultsManager;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.UserInterfaceDefaultsManager;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.text.SimpleDateFormat;

public class Controller implements Initializable {
    public MenuItem menuSaveAs;
    public MenuItem menuExit;
    public MenuItem menuAbout;
    public TextField modbusRegister;
    public TextField modbusDeviceId;
    public TextField modbusLength;
    public ComboBox<String> modbusFunction;
    public TextField connectionIpAddressFirstOctet;
    public TextField connectionIpAddressSecondOctet;
    public TextField connectionIpAddressThirdOctet;
    public TextField connectionIpAddressFourthOctet;
    public TextField connectionPort;
    public TextField connectionSchedulePeriod;
    public Button buttonConnect;
    public Label connectionStatusLabel;
    public Label outputCounterLabel;
    public Label inputCounterLabel;
    public TextFlow textFlow;
    public ScrollPane scrollPane;
    private ModbusMaster modbusMaster = new ModbusMaster();
    private UserInterfaceMediator userInterfaceMediator = new UserInterfaceMediator();
    private SimpleDateFormat timeFormatter = new SimpleDateFormat(UserInterfaceDefaultsManager.getDefaultTimeFormat());
    private InformationWindow informationWindow = new InformationWindow();

    public void menuSaveAsAction() {
        SaveToFile saveToFile = new SaveToFile(textFlow);
        saveToFile.save();
    }

    public void exitMenuAction() {
        if(modbusMaster.isConnected()) {
            modbusMaster.disconnect();
        }
        System.exit(0);
    }

    public void menuAboutAction() {
        informationWindow.display();
    }

    public void buttonConnectAction() {
        if (modbusMaster.isConnected()) {
            modbusMaster.disconnect();
            ifDisconnectedAction();
        } else {
            modbusMaster.connect();
            ifConnectedAction();
        }
    }

    private void ifConnectedAction() {
        if (modbusMaster.isConnected()) {
            disableConnectionTextFields();
            addConnectedMessage();
            setConnectedStatus();
        }
    }

    private void ifDisconnectedAction() {
        if (!modbusMaster.isConnected()) {
            enableConnectionTextFields();
            addDisconnectedMessage();
            setDisconnectedStatus();
        }
    }

    private String getTimeStamp() {
        return UserInterfaceDefaultsManager.getLeftBracket() +
                timeFormatter.format(System.currentTimeMillis()) +
                UserInterfaceDefaultsManager.getRightBracket() +
                UserInterfaceDefaultsManager.getTimeStampSeparator();
    }

    private void addMessageWithTime(String text, Color color) {
        Text message = new Text();
        message.setText(getTimeStamp() +
                text +
                UserInterfaceDefaultsManager.getNewLineSeparator());
        message.setFill(color);
        textFlow.getChildren().add(message);
    }

    private void addMessageWithoutTime(String text, Color color) {
        Text message = new Text();
        message.setText(text +
                UserInterfaceDefaultsManager.getNewLineSeparator());
        message.setFill(color);
        textFlow.getChildren().add(message);
    }

    private void addDisconnectedMessage() {
        addMessageWithTime(UserInterfaceDefaultsManager.getDisconnectedMessageText(), UserInterfaceDefaultsManager.getDisconnectedMessageColor());
    }

    private void addConnectedMessage() {
        addMessageWithTime(UserInterfaceDefaultsManager.getConnectedMessageText(), UserInterfaceDefaultsManager.getConnectedMessageColor());
    }

    private void addConnectionLostMessage() {
        addMessageWithTime(UserInterfaceDefaultsManager.getConnectionLostMessageText(), UserInterfaceDefaultsManager.getConnectionLostMessageColor());
    }

    private void setDisconnectedStatus() {
        buttonConnect.setText(UserInterfaceDefaultsManager.getConnectionButtonTextIfDisconnected());
        connectionStatusLabel.setText(UserInterfaceDefaultsManager.getConnectionStatusLabelIfDisconnected());
    }

    private void setConnectedStatus() {
        buttonConnect.setText(UserInterfaceDefaultsManager.getConnectionButtonTextIfConnected());
        connectionStatusLabel.setText(UserInterfaceDefaultsManager.getConnectionStatusLabelIfConnected());
    }

    private void disableConnectionTextFields() {
        connectionIpAddressFirstOctet.setDisable(true);
        connectionIpAddressSecondOctet.setDisable(true);
        connectionIpAddressThirdOctet.setDisable(true);
        connectionIpAddressFourthOctet.setDisable(true);
        connectionPort.setDisable(true);
        connectionSchedulePeriod.setDisable(true);
    }

    private void enableConnectionTextFields() {
        connectionIpAddressFirstOctet.setDisable(false);
        connectionIpAddressSecondOctet.setDisable(false);
        connectionIpAddressThirdOctet.setDisable(false);
        connectionIpAddressFourthOctet.setDisable(false);
        connectionPort.setDisable(false);
        connectionSchedulePeriod.setDisable(false);
    }

    public void modbusSlaveUpdate() {
        int modbusDeviceId = Integer.parseInt(this.modbusDeviceId.getText());
        int modbusRegister = Integer.parseInt(this.modbusRegister.getText());
        int modbusLength = Integer.parseInt(this.modbusLength.getText());
        int modbusFunction = modbusFunctionUpdate();
        modbusMaster.updateModbusParameters(modbusDeviceId, modbusRegister, modbusLength, modbusFunction);
    }

    private int modbusFunctionUpdate() {
        if (modbusFunction.getValue().equals(ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode01())) {
            return ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode01Value();
        } else if (modbusFunction.getValue().equals(ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode02())) {
            return ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode02Value();
        } else if (modbusFunction.getValue().equals(ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode03())) {
            return ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode03Value();
        } else {
            return ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode04Value();
        }
    }

    public void connectionManagerUpdate() {
        int connectionPort = Integer.parseInt(this.connectionPort.getText());
        int connectionSchedulePeriod = Integer.parseInt(this.connectionSchedulePeriod.getText());
        String connectionIpAddress = connectionIpAddressFirstOctet.getText() +
                ConnectionManagerDefaultsManager.getConnectionIpAddressSeparator() +
                connectionIpAddressSecondOctet.getText() +
                ConnectionManagerDefaultsManager.getConnectionIpAddressSeparator() +
                connectionIpAddressThirdOctet.getText() +
                ConnectionManagerDefaultsManager.getConnectionIpAddressSeparator() +
                connectionIpAddressFourthOctet.getText();
        modbusMaster.updateConnectionParameters(connectionIpAddress, connectionPort);
        modbusMaster.updateScheduler(connectionSchedulePeriod);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPaneSetAutoScroll();
        modbusFunctionInitialize();
        connectionIpAddressSetTextFormatter();
        connectionPortSetTextFormatter();
        connectionSchedulePeriodSetTextFormatter();
        modbusRegisterSetTextFormatter();
        modbusLengthSetTextFormatter();
        modbusDeviceIdSetTextFormatter();
        modbusMaster.registerObserver(userInterfaceMediator);
        connectionIpAddressFirstOctet.setText(ConnectionManagerDefaultsManager.getDefaultConnectionIpFirstOctet());
        connectionIpAddressSecondOctet.setText(ConnectionManagerDefaultsManager.getDefaultConnectionIpSecondOctet());
        connectionIpAddressThirdOctet.setText(ConnectionManagerDefaultsManager.getDefaultConnectionIpThirdOctet());
        connectionIpAddressFourthOctet.setText(ConnectionManagerDefaultsManager.getDefaultConnectionIpFourthOctet());
        connectionPort.setText(ConnectionManagerDefaultsManager.getDedaultConnectionPortAsString());
        modbusLength.setText(ModbusSlaveDefaultsManager.getDefaultModbusLengthAsString());
        modbusDeviceId.setText(ModbusSlaveDefaultsManager.getDefaultModbusDeviceIdAsString());
        modbusRegister.setText(ModbusSlaveDefaultsManager.getDefaultModbusRegisterAsString());
        informationWindow.setUp();
    }

    private void scrollPaneSetAutoScroll() {
        scrollPane.vvalueProperty().bind(textFlow.heightProperty());
    }

    private void modbusFunctionInitialize() {
        String modbusFunctionCode01 = ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode01();
        String modbusFunctionCode02 = ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode02();
        String modbusFunctionCode03 = ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode03();
        String modbusFunctionCode04 = ModbusSlaveDefaultsManager.getDefaultModbusFunctionCode04();
        modbusFunction.getItems().addAll(modbusFunctionCode01, modbusFunctionCode02, modbusFunctionCode03, modbusFunctionCode04);
        modbusFunction.getSelectionModel().select(ModbusSlaveDefaultsManager.getDefaultModbusFunction()-1);
    }

    private UnaryOperator<TextFormatter.Change> getTextFilter(String regex) {
        return c -> {
            String text = c.getControlNewText();
            if  (text.matches(regex)) {
                return c ;
            } else {
                return null ;
            }
        };
    }

    private void connectionPortSetTextFormatter() {
        connectionPort.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionPortRegex())));
    }

    private void connectionIpAddressSetTextFormatter() {
        connectionIpAddressFirstOctet.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionIpAddressRegex())));
        connectionIpAddressSecondOctet.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionIpAddressRegex())));
        connectionIpAddressThirdOctet.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionIpAddressRegex())));
        connectionIpAddressFourthOctet.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionIpAddressRegex())));
    }

    private void connectionSchedulePeriodSetTextFormatter() {
        connectionSchedulePeriod.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getConnectionSchedulePeriodRegex())));
    }

    private void modbusRegisterSetTextFormatter() {
        modbusRegister.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getModbusRegisterRegex())));
    }

    private void modbusLengthSetTextFormatter() {
        modbusLength.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getModbusLengthRegex())));
    }

    private void modbusDeviceIdSetTextFormatter() {
        modbusDeviceId.setTextFormatter(new TextFormatter<>(getTextFilter(UserInterfaceDefaultsManager.getModbusDeviceIdRegex())));
    }

    public class UserInterfaceMediator implements Observer {
        String formatedModbusInputFrame;
        String formatedModbusOutputFrame;
        int modbusInputFrameCounter;
        int modbusOutputFrameCounter;
        boolean isModbusError;

        public void update(String formatedModbusOutputFrame, String formatedModbusInputFrame, int modbusOutputFrameCounter, int modbusInputFrameCounter, boolean isModbusError) {
            this.formatedModbusOutputFrame = formatedModbusOutputFrame;
            this.formatedModbusInputFrame = formatedModbusInputFrame;
            this.modbusOutputFrameCounter = modbusOutputFrameCounter;
            this.modbusInputFrameCounter = modbusInputFrameCounter;
            this.isModbusError = isModbusError;

            if (modbusMaster.isConnected()) {
                Platform.runLater(() -> {
                    addOutputFrameMessage();
                    addInputFrameMessage();
                    updateCounterLabel();
                });
            } else {
                Platform.runLater(() -> {
                    addConnectionLostMessage();
                    enableConnectionTextFields();
                    setDisconnectedStatus();
                });
            }
        }

        private void updateCounterLabel() {
            outputCounterLabel.setText(Integer.toString(modbusOutputFrameCounter));
            inputCounterLabel.setText(Integer.toString(modbusInputFrameCounter));
        }

        private void addOutputFrameMessage() {
            String text = UserInterfaceDefaultsManager.getOutputMessageTitle() + formatedModbusOutputFrame;
            addMessageWithTime(text, UserInterfaceDefaultsManager.getOutputMessageColor());
        }

        private void addInputFrameMessage() {
            if(isModbusError) {
                addErrorInputFrameMessage();
            } else {
                addNormalInputFrameMessage();
            }
        }

        private void addNormalInputFrameMessage() {
            String text = UserInterfaceDefaultsManager.getInputMessageTitle() + formatedModbusInputFrame;
            if(text.length() <= UserInterfaceDefaultsManager.getMessageLength()) {
                addShortMessage(text);
            } else {
                addLongMessage(text);
            }
        }

        private void addShortMessage(String text) {
            addMessageWithTime(text, UserInterfaceDefaultsManager.getNormalInputMessageColor());
        }

        private void addLongMessage(String text) {
            List<String> list = splitEqually(getTimeStamp()+text, UserInterfaceDefaultsManager.getMessageLength());
            for(String message : list) {
                addMessageWithoutTime(message, UserInterfaceDefaultsManager.getNormalInputMessageColor());
            }
        }

        private List<String> splitEqually(String text, int size) {
            List<String> list = new ArrayList<>((text.length() + size - 1) / size);
            for (int start = 0; start < text.length(); start += size) {
                list.add(text.substring(start, Math.min(text.length(), start + size)));
            }
            return list;
        }

        private void addErrorInputFrameMessage() {
            addMessageWithTime(formatedModbusInputFrame, UserInterfaceDefaultsManager.getErrorInputMessageColor());
        }
    }
}