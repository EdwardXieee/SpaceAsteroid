package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.Ranking;
import com.comp2059.app.utils.SoundEffect;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This controller is to control ranking stage.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * @author Jiafang Sun
 * @version 1.0
 * @since 23 November 2022
 */
public class RankingStageController implements Initializable {
    @FXML
    public ListView<String> rankingListView;
    @FXML
    private Button btnBack;

    /**
     * Read the ranking list from database and initialize it on ranking interface.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<String> rankingList = Ranking.rankingList;
        rankingListView.setItems(rankingList);
    }

    /**
     * When users click "Back", display the sound and back to the PrimaryStage.
     */
    @FXML
    void clickBack() {
        SoundEffect.playButton();
        Director.getDirector().toPrimaryStage();
    }

    @FXML
    void enterBack() { btnBack.setOpacity(0.8); }

    @FXML
    void exitBack() { btnBack.setOpacity(1);}

}

