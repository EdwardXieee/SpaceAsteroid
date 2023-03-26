package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.Background;
import com.comp2059.app.utils.SoundEffect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This controller is to control option stage.
 * When user click the "Done!" button, display the sound and go back to the primary stage.
 * When user's mouse enters the groups, the corresponding group opacity will be smaller.
 * When user's mouse exits the groups, the corresponding group opacity will be restored.
 * When user click the checkboxes or images, change the checkboxes' status to 'selected' and others to 'not selected'.
 * @author Yuening Xie
 * @version 2.0
 * @since 3 December 2022
 */
public class OptionStageController implements Initializable {
    @FXML
    public Button btnDone;
    @FXML
    public Group classic;
    @FXML
    public Group giant;
    @FXML
    public Group dark;
    @FXML
    public Group deep;
    @FXML
    public Group bright;
    @FXML
    public Group appeal;
    @FXML
    public Group fissure;
    @FXML
    public Group gemini;
    @FXML
    public CheckBox classicBox;
    @FXML
    public CheckBox giantBox;
    @FXML
    public CheckBox darkBox;
    @FXML
    public CheckBox deepBox;
    @FXML
    public CheckBox brightBox;
    @FXML
    public CheckBox appealBox;
    @FXML
    public CheckBox fissureBox;
    @FXML
    public CheckBox geminiBox;

    /**
     * Set classic background as the default background.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        classicBox.setSelected(true);
    }

    @FXML
    public void enterClassic() {
        classic.setOpacity(0.8);
    }

    @FXML
    public void exitClassic() {
        classic.setOpacity(1);
    }

    @FXML
    public void enterGiant() {
        giant.setOpacity(0.8);
    }

    @FXML
    public void exitGiant() {
        giant.setOpacity(1);
    }

    @FXML
    public void enterDark() {
        dark.setOpacity(0.8);
    }

    @FXML
    public void exitDark() {
        dark.setOpacity(1);
    }

    @FXML
    public void enterDeep() {
        deep.setOpacity(0.8);
    }

    @FXML
    public void exitDeep() {
        deep.setOpacity(1);
    }

    @FXML
    public void enterBright() {
        bright.setOpacity(0.8);
    }

    @FXML
    public void exitBright() {
        bright.setOpacity(1);
    }

    @FXML
    public void enterAppeal() {
        appeal.setOpacity(0.8);
    }

    @FXML
    public void exitAppeal() {
        appeal.setOpacity(1);
    }

    @FXML
    public void enterFissure() {
        fissure.setOpacity(0.8);
    }

    @FXML
    public void exitFissure() {
        fissure.setOpacity(1);
    }

    @FXML
    public void enterGemini() {
        gemini.setOpacity(0.8);
    }

    @FXML
    public void exitGemini() {
        gemini.setOpacity(1);
    }

    @FXML
    public void enterBack() {
        btnDone.setOpacity(0.8);
    }

    @FXML
    public void existBack() {
        btnDone.setOpacity(1);
    }

    @FXML
    public void clickBack() {
        SoundEffect.playButton();
        Director.getDirector().toPrimaryStage();
    }

    @FXML
    public void clickClassic() {
        chooseBackground();
    }

    @FXML
    public void clickGiant() {
        chooseBackground1();
    }

    @FXML
    public void clickDark() {
        chooseBackground2();
    }

    @FXML
    public void clickDeep() {
        chooseBackground3();
    }

    @FXML
    public void clickBright() {
        chooseBackground4();
    }

    @FXML
    public void clickAppeal() {
        chooseBackground5();
    }

    @FXML
    public void clickFissure() {
        chooseBackground6();
    }

    @FXML
    public void clickGemini() {
        chooseBackground7();
    }

    public void chooseBackground() {
        classicBox.setSelected(true);
        if (classicBox.isSelected()) {
            giantBox.setSelected(false);
            darkBox.setSelected(false);
            deepBox.setSelected(false);
            brightBox.setSelected(false);
            appealBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background.png")).toString();
        }
    }

    public void chooseBackground1() {
        giantBox.setSelected(true);
        if (giantBox.isSelected()) {
            classicBox.setSelected(false);
            darkBox.setSelected(false);
            deepBox.setSelected(false);
            brightBox.setSelected(false);
            appealBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background1.png")).toString();
        }
    }

    public void chooseBackground2() {
        darkBox.setSelected(true);
        if (darkBox.isSelected()) {
            classicBox.setSelected(false);
            deepBox.setSelected(false);
            brightBox.setSelected(false);
            appealBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            giantBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background2.png")).toString();
        }
    }

    public void chooseBackground3() {
        deepBox.setSelected(true);
        if (deepBox.isSelected()) {
            classicBox.setSelected(false);
            brightBox.setSelected(false);
            darkBox.setSelected(false);
            appealBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            giantBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background3.png")).toString();
        }
    }

    public void chooseBackground4() {
        brightBox.setSelected(true);
        if (brightBox.isSelected()) {
            classicBox.setSelected(false);
            deepBox.setSelected(false);
            darkBox.setSelected(false);
            appealBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            giantBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background4.png")).toString();
        }
    }

    public void chooseBackground5() {
        appealBox.setSelected(true);
        if (appealBox.isSelected()) {
            classicBox.setSelected(false);
            deepBox.setSelected(false);
            darkBox.setSelected(false);
            fissureBox.setSelected(false);
            geminiBox.setSelected(false);
            giantBox.setSelected(false);
            brightBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background5.png")).toString();
        }
    }

    public void chooseBackground6() {
        fissureBox.setSelected(true);
        if (fissureBox.isSelected()) {
            classicBox.setSelected(false);
            deepBox.setSelected(false);
            darkBox.setSelected(false);
            appealBox.setSelected(false);
            geminiBox.setSelected(false);
            giantBox.setSelected(false);
            brightBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background6.png")).toString();
        }
    }

    public void chooseBackground7() {
        geminiBox.setSelected(true);
        if (geminiBox.isSelected()) {
            classicBox.setSelected(false);
            deepBox.setSelected(false);
            darkBox.setSelected(false);
            appealBox.setSelected(false);
            giantBox.setSelected(false);
            brightBox.setSelected(false);
            fissureBox.setSelected(false);
            Background.backgroundType = Objects.requireNonNull(getClass()
                    .getResource("/com/comp2059/app/img/background/background7.png")).toString();
        }
    }
}
