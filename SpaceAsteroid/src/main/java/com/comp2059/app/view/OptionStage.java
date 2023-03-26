package com.comp2059.app.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * This class is to load option interface.
 * @author Yuening Xie
 * @version 1.0
 * @since 3 December 2022
 */
public class OptionStage {
    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(OptionStage.class.getResource("/com/comp2059/app/fxml/OptionStageView.fxml")));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
