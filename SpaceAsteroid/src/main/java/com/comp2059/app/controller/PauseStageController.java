package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.utils.SoundEffect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This controller is to control pause stage, including restart the game, end the game, mute and restore the game.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * @author Yuening Xie
 * @version 1.0
 * @since 19 December 2022
 */
public class PauseStageController implements Initializable {
    @FXML
    public Button btnExit;
    @FXML
    public Button btnRestart;
    @FXML
    public ImageView soundImage;

    /**
     * Judge if the sound is muted, if yes, replace the sound image with sound-off image, otherwise, showing sound-on image.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Director.getDirector().isSound()) {
            soundImage.setImage(new Image(Objects.requireNonNull(PauseStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOn.png")).toString()));
        }
        else {
            soundImage.setImage(new Image(Objects.requireNonNull(PauseStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOff.png")).toString()));
        }
    }

    /**
     * Restart the game and close the pause interface.
     */
    @FXML
    public void clickRestart() {
        SoundEffect.playButton();
        Stage stage = (Stage) btnRestart.getScene().getWindow();
        stage.close();
        Director.getDirector().reStartGame();
    }

    /**
     * End the game and close the pause interface, then jump to the ranking interface.
     */
    @FXML
    public void clickExit() {
        SoundEffect.playButton();
        Stage stage = (Stage) btnRestart.getScene().getWindow();
        stage.close();
        Director.getDirector().toEndGame();
    }

    /**
     * Turn sound on or off.
     */
    @FXML
    public void clickSound() {
        switchSound(soundImage);
    }

    /**
     * This method is to turn on/off the sound according to the current sound status
     * and switch the sound image to "on" image or "off" image.
     * @param soundImage Sound button image.
     */
    public static void switchSound(ImageView soundImage) {
        switchSoundImage(soundImage);
    }

    /**
     * When user releases key "P", restore the game stage and close the pause interface.
     * @param keyEvent To get which key user is releasing.
     */
    @FXML
    public void setOnKeyReleased(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        if(keyCode == KeyCode.P){
            GameStageModel.setRunning(!GameStageModel.getRunning());
            Stage stage = (Stage) btnRestart.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void enterRestart() {
        btnRestart.setOpacity(0.8);
    }

    @FXML
    public void exitRestart() {
        btnRestart.setOpacity(1);
    }

    @FXML
    public void enterExit() {
        btnExit.setOpacity(0.8);
    }

    @FXML
    public void exitExit() {
        btnExit.setOpacity(1);
    }

    @FXML
    public void enterSound() {
        soundImage.setOpacity(0.8);
    }

    @FXML
    public void exitSound() {
        soundImage.setOpacity(1);
    }

    /**
     * To switch the sound image to "on" image or "off" image.
     * @param soundImage Sound button image.
     */
    protected static void switchSoundImage(ImageView soundImage) {
        if (Director.getDirector().isSound()) {
            soundImage.setImage(new Image(Objects.requireNonNull(PrimaryStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOff.png")).toString()));
            SoundEffect.mute();
            Director.getDirector().setSound(false);
        }
        else {
            soundImage.setImage(new Image(Objects.requireNonNull(PrimaryStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOn.png")).toString()));
            SoundEffect.restoreVolume();
            Director.getDirector().setSound(true);
        }
    }
}
