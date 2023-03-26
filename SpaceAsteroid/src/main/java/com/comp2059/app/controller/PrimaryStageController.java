package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.*;
import com.comp2059.app.utils.SoundEffect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This controller is to control primary stage.
 * When user click the buttons, display the sound and do the corresponding actions.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * When user click the checkboxes or images, change the checkboxes' status to 'selected' and others to 'not selected'.
 * User can click the trumpet pattern to set the sound on or off.
 * @author Yuening Xie
 * @version 3.0
 * @since 9 November 2022
 */
public class PrimaryStageController implements Initializable {
    @FXML
    public Button btnStart;
    @FXML
    public Button btnQuit;
    @FXML
    public Button btnOption;
    @FXML
    public Button btnInfo;
    @FXML
    public Button btnRank;
    @FXML
    public Group shuttleGroup1;
    @FXML
    public Group shuttleGroup2;
    @FXML
    public Group shuttleGroup3;
    @FXML
    public Group shuttleGroup4;
    @FXML
    public CheckBox shuttle1Click;
    @FXML
    public CheckBox shuttle2Click;
    @FXML
    public CheckBox shuttle3Click;
    @FXML
    public CheckBox shuttle4Click;
    @FXML
    public ImageView soundSwitch;

    /**
     * Set the first shuttle as the default shuttle.
     * Check if the sound is on or off, and put the corresponding sound image.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shuttle1Click.setSelected(true);
        GameStageModel.shuttleType = "Shuttle1";

        if (Director.getDirector().isSound()) {
            soundSwitch.setImage(new Image(Objects.requireNonNull(PrimaryStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOn.png")).toString()));
        }
        else {
            soundSwitch.setImage(new Image(Objects.requireNonNull(PrimaryStageController.class
                    .getResource("/com/comp2059/app/img/others/soundOff.png")).toString()));
        }

    }

    @FXML
    void clickQuit() {
        SoundEffect.playButton();
        Director.getDirector().quitGame();
    }

    @FXML
    void clickStart() {
        SoundEffect.playButton();
        Director.getDirector().toSecondStage();
    }

    @FXML
    void clickOption() {
        SoundEffect.playButton();
        Director.getDirector().toOptionStage();
    }

    @FXML
    void clickInfo() {
        SoundEffect.playButton();
        Director.getDirector().toInfoStage();
    }

    @FXML
    void clickRank() {
        SoundEffect.playButton();
        Director.getDirector().toRanking();
    }

    @FXML
    public void enterStart() {
        btnStart.setOpacity(0.8);
    }

    @FXML
    public void exitStart() {
        btnStart.setOpacity(1);
    }

    @FXML
    public void enterQuit() {
        btnQuit.setOpacity(0.8);
    }

    @FXML
    public void exitQuit() {
        btnQuit.setOpacity(1);
    }

    @FXML
    public void enterOption() {
        btnOption.setOpacity(0.8);
    }

    @FXML
    public void exitOption() {
        btnOption.setOpacity(1);
    }

    @FXML
    public void enterInfo() {
        btnInfo.setOpacity(0.8);
    }

    @FXML
    public void exitInfo() {
        btnInfo.setOpacity(1);
    }

    @FXML
    public void enterRank() {
        btnRank.setOpacity(0.8);
    }

    @FXML
    public void exitRank() {
        btnRank.setOpacity(1);
    }

    @FXML
    public void enterGroup1() {
        shuttleGroup1.setOpacity(0.8);
    }

    @FXML
    public void exitGroup1() {
        shuttleGroup1.setOpacity(1);
    }

    @FXML
    public void enterGroup2() {
        shuttleGroup2.setOpacity(0.8);
    }

    @FXML
    public void exitGroup2() {
        shuttleGroup2.setOpacity(1);
    }

    @FXML
    public void enterGroup3() {
        shuttleGroup3.setOpacity(0.8);
    }

    @FXML
    public void exitGroup3() {
        shuttleGroup3.setOpacity(1);
    }

    @FXML
    public void enterGroup4() {
        shuttleGroup4.setOpacity(0.8);
    }

    @FXML
    public void exitGroup4() {
        shuttleGroup4.setOpacity(1);
    }
    @FXML
    public void enterSoundSwitch() {
        soundSwitch.setOpacity(0.8);
    }

    @FXML
    public void existSoundSwitch() {
        soundSwitch.setOpacity(1);
    }

    @FXML
    public void clickGroup1() {
        chooseShuttle1();
    }

    @FXML
    public void clickGroup2() {
        chooseShuttle2();
    }

    @FXML
    public void clickGroup3() {
        chooseShuttle3();
    }

    @FXML
    public void clickGroup4() {
        chooseShuttle4();
    }

    @FXML
    public void clickSoundSwitch() {
        PauseStageController.switchSoundImage(soundSwitch);
    }

    public void chooseShuttle1() {
        shuttle1Click.setSelected(true);
        if (shuttle1Click.isSelected()) {
            shuttle2Click.setSelected(false);
            shuttle3Click.setSelected(false);
            shuttle4Click.setSelected(false);
            GameStageModel.shuttleType = "Shuttle1";
        }
    }

    public void chooseShuttle2() {
        shuttle2Click.setSelected(true);
        if (shuttle2Click.isSelected()) {
            shuttle1Click.setSelected(false);
            shuttle3Click.setSelected(false);
            shuttle4Click.setSelected(false);
            GameStageModel.shuttleType = "Shuttle2";
        }
    }

    public void chooseShuttle3() {
        shuttle3Click.setSelected(true);
        if (shuttle3Click.isSelected()) {
            shuttle1Click.setSelected(false);
            shuttle2Click.setSelected(false);
            shuttle4Click.setSelected(false);
            GameStageModel.shuttleType = "Shuttle3";
        }
    }

    public void chooseShuttle4() {
        shuttle4Click.setSelected(true);
        if (shuttle4Click.isSelected()) {
            shuttle1Click.setSelected(false);
            shuttle2Click.setSelected(false);
            shuttle3Click.setSelected(false);
            GameStageModel.shuttleType = "Shuttle4";
        }
    }
}
