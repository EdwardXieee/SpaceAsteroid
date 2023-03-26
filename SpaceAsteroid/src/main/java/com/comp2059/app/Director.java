package com.comp2059.app;

import com.comp2059.app.model.Background;
import com.comp2059.app.model.Ranking;
import com.comp2059.app.view.*;
import com.comp2059.app.utils.SoundEffect;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * This class is using singleton pattern to control all stages.
 * @author Yuening Xie
 * @version 2.0
 * @since  14 November 2022
 */
public class Director {
    public static final double WIDTH = 1200, HEIGHT = 720;
    private Stage stage;
    private boolean sound;
    private Director() {}
    private static final Director director = new Director();

    /**
     * Get the instance created by itself.
     * @return The instance of Director.
     */
    public static Director getDirector() {
        return director;
    }

    /**
     * Initialize all the game required in the start.
     * @param stage The game stage.
     */
    public void init(Stage stage) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().
                getResource("/com/comp2059/app/img/others/icon.png")).toString()));
        stage.setTitle("Space Asteroid");
        stage.setResizable(false);

        // To make sure the program is exited when player click close.
        stage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setScene(scene);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        this.stage = stage;
        Ranking.readRanking();
        sound = true;
        SoundEffect.playBgm();

        // To initialize the game background.
        Background.backgroundType = Objects.requireNonNull(Background.class.
                getResource("/com/comp2059/app/img/background/background.png")).toString();
        toPrimaryStage();
        stage.show();
    }

    /**
     * Go to the primary stage.
     */
    public void toPrimaryStage() {
        PrimaryStage.load(stage);
    }

    /**
     * Go to the second stage.
     */
    public void toSecondStage() {
        SecondStage.load(stage);
    }

    /**
     * Go to the information stage.
     */
    public void toInfoStage() {
        InfoStage.load(stage);
    }

    /**
     * Go to the ranking stage.
     */
    public void toRanking() {
        RankingStage.load(stage);
    }

    /**
     * Go to the option stage.
     */
    public void toOptionStage() {
        OptionStage.load(stage);
    }

    /**
     * Display the pause game interface.
     */
    public void toPauseGame() {
        PauseGameStage.load();
    }

    /**
     * Go to end game stage. When player break the record, load congratulation stage, otherwise game over stage.
     */
    public void toEndGame() {
        Ranking.updateReadRanking();
        EndGameStage.load(stage);
        GameStageView.getGameStageView().clear(stage);
    }

    /**
     * Initialize the game stage.
     */
    public void startGame() {
        GameStageView.getGameStageView().init(stage);
    }

    /**
     * Quit (close) the game.
     */
    public void quitGame() {
        System.exit(0);
    }

    /**
     * Clear the present game stage and restart the game.
     */
    public void reStartGame() {
        GameStageView.getGameStageView().clear(stage);
        startGame();
    }

    /**
     * Judge if the soundImage is on.
     * @return If the soundImage is on.
     */
    public boolean isSound() {
        return sound;
    }

    /**
     * Set the soundImage on or off.
     */
    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
