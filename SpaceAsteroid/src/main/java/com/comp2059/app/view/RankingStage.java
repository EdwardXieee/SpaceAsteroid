package com.comp2059.app.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class is to load ranking interface.
 * @author Jiafang Sun
 * @version 2.0
 * @since  23 November 2022
 */
public class RankingStage {
    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(RankingStage.class.getResource("/com/comp2059/app/fxml/RankingStageView.fxml")));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
