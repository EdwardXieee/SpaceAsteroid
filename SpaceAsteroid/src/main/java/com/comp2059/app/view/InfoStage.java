package com.comp2059.app.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is to load info interface.
 * @author Yuening Xie
 * @version 1.0
 * @since 26 November 2022
 */
public class InfoStage {
    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(InfoStage.class.getResource("/com/comp2059/app/fxml/InfoStageView.fxml")));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
