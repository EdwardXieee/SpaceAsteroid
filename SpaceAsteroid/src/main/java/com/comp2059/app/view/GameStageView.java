package com.comp2059.app.view;

import com.comp2059.app.*;
import com.comp2059.app.controller.GameStageController;
import com.comp2059.app.model.*;
import com.comp2059.app.model.bullet.AbstractBullet;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Objects;

import static com.comp2059.app.model.GameStageModel.shuttle;

/**
 * This class draws the game stage by refreshing constantly to achieve the effect that the screen changes in real time.
 * @author Yuening Xie, Jiafang Sun
 * @version 2.0
 * @since  19 November 2022
 */
public class GameStageView {
    private static final GameStageController.KeyProcess KEYPROCESS = new GameStageController.KeyProcess();
    private final Refresh REFRESH = new Refresh();
    private static final Canvas CANVAS = new Canvas(Director.WIDTH, Director.HEIGHT);
    private Font font = null;
    /**
     * The score is displayed in the top right corner of game stage.
     */
    public Text textScore = new Text(1050, 70, "Score: 0");
    /**
     * The highest score is displayed in the top right corner of game stage.
     */
    public Text textRecord = new Text(975, 100, "Highest Record: " + Ranking.getBestScore());
    /**
     * The level is displayed in the top left corner of game stage.
     */
    public ImageView level = new ImageView();
    /**
     * The remaining blood point is displayed in the top left corner of game stage.
     */
    public ImageView blood = new ImageView();
    public AnchorPane root;
    public static final GraphicsContext GRAPHICSCONTEXT = CANVAS.getGraphicsContext2D();

    private GameStageView() {}
    private static final GameStageView gameStageView = new GameStageView();

    /**
     * Get the instance created by itself.
     * @return The instance of GameStageView.
     */
    public static GameStageView getGameStageView() {
        return gameStageView;
    }


    /**
     * Initialize the game stage. Set game stage view to receive key events and necessary texts and images
     */
    public void init(Stage stage) {
        root = new AnchorPane(CANVAS);
        stage.getScene().setRoot(root);
        stage.getScene().setOnKeyReleased(KEYPROCESS);
        stage.getScene().setOnKeyPressed(KEYPROCESS);

        // Read the font file.
        try (FileInputStream in = new FileInputStream(Objects.requireNonNull(GameStageModel.class.
                getResource("/com/comp2059/app/font/font.ttf")).toString().substring(5))) {
            font = Font.loadFont(in, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the score to display.
        textScore.setFont(font);
        textScore.setScaleX(1.2);
        textScore.setScaleY(1.2);
        textScore.setStyle("-fx-font-size:18");
        textScore.setFill(Color.WHITE);
        root.getChildren().add(textScore);

        // Set the highest record to display.
        textRecord.setFont(font);
        textRecord.setScaleX(1.2);
        textRecord.setScaleY(1.2);
        textRecord.setStyle("-fx-font-size:15");
        textRecord.setFill(Color.WHITE);
        root.getChildren().add(textRecord);

        // Set the number of level to display.
        level.setX(50);
        level.setY(40);
        level.setFitWidth(170);
        level.setFitHeight(50);
        root.getChildren().add(level);

        // Set the blood point to display.
        blood.setX(60);
        blood.setY(100);
        blood.setFitWidth(85);
        blood.setFitHeight(25);
        root.getChildren().add(blood);

        // Initialize the score and asteroid fall speed.
        GameStageModel.setScore(0);
        GameStageModel.setAsteroidFallSpeed(4);
        GameStageModel.setRunning(true);
        GameStageModel.getGameStage().setShuttle();
        GameStageModel.getGameStage().setBackground();
        REFRESH.start();
    }


    /**
     * To paint background, shuttle, bullets, asteroids and explosions dynamically in the game stage.
     */
    public void show() {
        GameStageModel.getGameStage().background.paint(GRAPHICSCONTEXT);
        shuttle.paint(GRAPHICSCONTEXT);

        if (shuttle.isAlive())
            Director.getDirector().toEndGame();


        for (int i = 0; i < GameStageModel.getGameStage().getBullets().size(); i++) {
            AbstractBullet b = GameStageModel.getGameStage().getBullets().get(i);
            b.paint(GRAPHICSCONTEXT);
            b.collide(GameStageModel.getGameStage().getAsteroids());
        }

        for (int i = 0; i < GameStageModel.getGameStage().getBullets().size(); i++) {
            AbstractBullet bullet = GameStageModel.getGameStage().getBullets().get(i);
            bullet.paint(GRAPHICSCONTEXT);
        }

        for (int i = 0; i < GameStageModel.getGameStage().getAsteroids().size(); i++) {
            Asteroid asteroid = GameStageModel.getGameStage().getAsteroids().get(i);
            asteroid.paint(GRAPHICSCONTEXT);
            shuttle.collideCheck(asteroid);
        }

        for (int i = 0; i < GameStageModel.getGameStage().getExplosions().size(); i++) {
            Explosion explosion = GameStageModel.getGameStage().getExplosions().get(i);
            explosion.paint(GRAPHICSCONTEXT);
        }

        textScore.setText("Score: " + GameStageModel.getScore());

    }

    /**
     * Clear the game stage when the game is end.
     */
    public void clear(Stage stage) {
        stage.getScene().removeEventHandler(KeyEvent.KEY_PRESSED, KEYPROCESS);
        stage.getScene().removeEventHandler(KeyEvent.KEY_RELEASED, KEYPROCESS);
        REFRESH.stop();
        GameStageModel.getGameStage().clearData();
    }

    /**
     * This class is to refresh the scene to make the game dynamically.
     * Keep updating the shuttle's remaining blood point, creating asteroids and accelerate the asteroids.
     */
    private class Refresh extends AnimationTimer {
        @Override
        public void handle(long now) {
            if (GameStageModel.getRunning()) {
                GameStageModel.getGameStage().setShuttleBlood();
                GameStageModel.getGameStage().createAsteroid();
                GameStageModel.getGameStage().speedUp();
                show();
            }
        }
    }
}
