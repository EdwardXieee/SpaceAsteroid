package com.comp2059.app.view;

import com.comp2059.app.controller.GameStageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is to load pause game interface and define some styles of the stage.
 * @author Yuening Xie
 * @version 1.0
 * @since  19 December 2022
 */
public class PauseGameStage {
    public static void load() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(PrimaryStage.class.getResource("/com/comp2059/app/fxml/PauseStageView.fxml")));
            // Create a new stage to display the pause interface.
            Stage stage = new Stage();
            Scene newScene = new Scene(root);
            // Make the background transparent.
            stage.initStyle(StageStyle.TRANSPARENT);
            newScene.setFill(null);
            // Make this stage always on top.
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.setTitle("Pause");
            stage.setScene(newScene);
            stage.setX(630);
            stage.setY(210);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
