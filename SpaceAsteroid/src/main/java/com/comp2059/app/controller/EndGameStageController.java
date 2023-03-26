package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.model.Ranking;
import com.comp2059.app.utils.SoundEffect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * This controller is to control end game stage, including ranking, restart button and back to primary stage button.
 * When user's mouse enters the buttons, the button's opacity will be smaller.
 * When user's mouse exits the buttons, the button's opacity will be restored.
 * @author Jiafang Sun
 * @version 2.0
 * @since 18 November 2022
 */
public class EndGameStageController implements Initializable {
    @FXML
    public Button btnEndBack;
    @FXML
    public Button btnEndStart;
    /**
     * This is a gif to congratulate users who break the record.
     */
    @FXML
    public ImageView congratulationImage;
    public ListView<String> endRankingListView;
    public ObservableList<String> endRankingList = FXCollections.observableArrayList();

    /**
     * Initialize the end game stage, including ranking and congratulation gif.
     */
    public void initialize(URL location, ResourceBundle resources){
        // If a user break the record, play the congratulation gif.
        if (GameStageModel.getScore() == Ranking.bestScore) {
            congratulationImage.setImage(new Image(Objects.requireNonNull(EndGameStageController.class
                    .getResource("/com/comp2059/app/img/others/congrats.gif")).toString()));
        }
        // Initialize ranking.
        endRankingList = Ranking.rankingList;
        endRankingListView.setItems(endRankingList);
        endRankingListView.setCellFactory((ListView<String> l) -> new UpdateRanking());
        endRankingListView.refresh();
    }

    /**
     * Create cells and highlight current instance.
     */
    public static class UpdateRanking extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            // Update score.
            super.updateItem(item, empty);
            BorderPane cell = new BorderPane();

            Text text = new Text(item);
            text.setFont(Font.font(14));

            // Highlight the user's current score.
            if (Objects.equals(item, "No. " + Ranking.thisRoundRank + "        " + GameStageModel.getName() + "        " + GameStageModel.getScore())) {
                cell.setCenter(text);
                cell.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                setGraphic(cell);
            } else {
                cell.setCenter(text);
                setGraphic(cell);
            }
        }
    }

    @FXML
    public void clickBack() {
        SoundEffect.playButton();
        Director.getDirector().toPrimaryStage();
    }

    @FXML
    public void clickReStart() {
        SoundEffect.playButton();
        Director.getDirector().startGame();
    }

    @FXML
    public void enterBack() {
        btnEndBack.setOpacity(0.8);
    }

    @FXML
    public void enterReStart() {
        btnEndStart.setOpacity(0.8);
    }

    @FXML
    public void exitBack() {
        btnEndBack.setOpacity(1);
    }

    @FXML
    public void exitReStart() {
        btnEndStart.setOpacity(1);
    }

}

