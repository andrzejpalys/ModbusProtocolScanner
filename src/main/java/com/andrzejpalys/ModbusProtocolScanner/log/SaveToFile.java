package com.andrzejpalys.ModbusProtocolScanner.log;

import com.andrzejpalys.ModbusProtocolScanner.Main;
import com.andrzejpalys.ModbusProtocolScanner.resourcesManager.SaveToFileDefaultsManager;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveToFile {

    private TextFlow textFlow;

    public SaveToFile(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public void save() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(SaveToFileDefaultsManager.getDescription(), SaveToFileDefaultsManager.getExtenion());
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);
        ObservableList<Node> nodes = textFlow.getChildren();
        StringBuilder stringBuilder = new StringBuilder();

        for (Node node : nodes) {
            stringBuilder.append((((Text) node).getText()));
            stringBuilder.append(System.lineSeparator());
        }

        String text = stringBuilder.toString();

        if (file != null) {
            SaveFile(text, file);
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}