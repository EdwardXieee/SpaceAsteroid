package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.utils.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * This controller is to detect button click event and go back to the primary stage.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * @author Yuening Xie
 * @version 3.0
 * @since 26 November 2022
 */
public class InfoStageController {
    @FXML
    public Button btnBack;

    @FXML
    public void clickBack() {
        SoundEffect.playButton();
        Director.getDirector().toPrimaryStage();
    }

    @FXML
    public void enterBack() {
        btnBack.setOpacity(0.8);
    }

    @FXML
    public void exitBack() {
        btnBack.setOpacity(1);
    }
}
