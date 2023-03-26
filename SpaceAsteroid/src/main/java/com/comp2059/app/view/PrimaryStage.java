package com.comp2059.app.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is to load primary interface.
 * @author Yuening Xie
 * @version 1.0
 * @since  14 November 2022
 */
public class PrimaryStage {
    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(PrimaryStage.class.getResource("/com/comp2059/app/fxml/PrimaryStageView.fxml")));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
