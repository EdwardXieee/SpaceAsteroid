package com.comp2059.app.model;

import com.comp2059.app.model.bullet.AbstractBullet;
import com.comp2059.app.model.shuttle.AbstractShuttle;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.view.GameStageView;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class uses singleton pattern to process game stage data from game stage view,
 * including update the shuttle's blood point, asteroid fall speed and so on in real time.
 * @author Jiafang Sun
 * @version 2.0
 * @since  21 December 2022
 */
public class GameStageModel {
    private static int score;
    private static String name;
    private static double asteroidFallSpeed;
    private static boolean running = false;
    private static final ArrayList<AbstractBullet> BULLETS = new ArrayList<>();
    private static final ArrayList<Asteroid> ASTEROIDS = new ArrayList<>();
    private static final ArrayList<Explosion> EXPLOSIONS = new ArrayList<>();
    private int asteroidCounter = 0;
    private int speedCounter = 0;
    public AbstractFactory shuttleFactory = FactoryProducer.getFactory("SHUTTLE");
    public Background background = null;
    public static String shuttleType;
    public static AbstractShuttle shuttle;
    public static int shuttleBlood;

    private GameStageModel() {}
    private static final GameStageModel gameStage = new GameStageModel();

    /**
     * Get the instance created by itself.
     * @return The instance of GameStageModel.
     */
    public static GameStageModel getGameStage() {
        return gameStage;
    }

    /**
     * Create corresponding shuttle according to the player's choice.
     */
    public void setShuttle() {
        shuttle = shuttleFactory.makeShuttle(shuttleType);
    }

    /**
     * Set the blood image according to the shuttle's blood.
     */
    public void setShuttleBlood() {
        shuttleBlood = shuttle.bloodPoint;
        if (shuttleBlood == 5) {
            GameStageView.getGameStageView().blood.setImage(new Image(Objects.requireNonNull(GameStageModel.class
                    .getResource("/com/comp2059/app/img/blood/blood3.png")).toString()));
        } else if (shuttleBlood > 1) {
            GameStageView.getGameStageView().blood.setImage(new Image(Objects.requireNonNull(GameStageModel.class
                    .getResource("/com/comp2059/app/img/blood/blood" + (shuttleBlood - 1) + ".png")).toString()));
        }
    }

    /**
     * Set the background according to the player's choice.
     */
    public void setBackground() {
        background = new Background();
    }

    /**
     * Increase the asteroid fall speed as the time increases.
     */
    public void speedUp() {
        int refreshTimes = 50;
        speedCounter++;
        if (speedCounter % refreshTimes == 0) {
            asteroidFallSpeed += 0.02;
        }
    }

    /**
     * More asteroids will be created with the score increasing.
     * Change the level according to the score.
     */
    public void createAsteroid() {
        int refreshTimes;
        asteroidCounter++;
        String levelName;

        if (score < 25) {
            refreshTimes = 50;
            levelName = "level1";
        }
        else if (score < 50) {
            refreshTimes = 45;
            levelName = "level2";
        }
        else if (score < 75) {
            refreshTimes = 40;
            levelName = "level3";
        }
        else if (score < 100) {
            refreshTimes = 35;
            levelName = "level4";
        }
        else if (score < 125) {
            refreshTimes = 30;
            levelName = "level5";
        }
        else if (score < 150) {
            refreshTimes = 25;
            levelName = "level6";
        }
        else if (score < 175){
            refreshTimes = 20;
            levelName = "level7";
        }
        else if (score < 200){
            refreshTimes = 15;
            levelName = "level8";
        }
        else if (score < 230) {
            refreshTimes = 10;
            levelName = "level9";
        }
        else {
            refreshTimes = 5;
            levelName = "level10";
        }

        // Change the level image.
        GameStageView.getGameStageView().level.setImage(new Image(Objects.requireNonNull(GameStageModel.class
                .getResource("/com/comp2059/app/img/level/" + levelName + ".png")).toString()));

        if (asteroidCounter % refreshTimes == 0) {
            Asteroid asteroid = new Asteroid(Direction.DOWN);
            ASTEROIDS.add(asteroid);
        }
    }

    /**
     * Clear arraylist's data when game ends.
     */
    public void clearData() {
        BULLETS.clear();
        ASTEROIDS.clear();
        EXPLOSIONS.clear();
    }

    /**
     * Get the arraylist of bullets.
     */
    public ArrayList<AbstractBullet> getBullets() {
        return BULLETS;
    }

    /**
     * Get the arraylist of asteroids.
     */
    public ArrayList<Asteroid> getAsteroids() {
        return ASTEROIDS;
    }

    /**
     * Get the arraylist of explosions.
     */
    public ArrayList<Explosion> getExplosions() {
        return EXPLOSIONS;
    }

    /**
     * To set the game stage running or not running.
     * @param isRunning True or False.
     */
    public static void setRunning(boolean isRunning) {
        running = isRunning;
    }

    /**
     * Get the status of running.
     * @return True or False.
     */
    public static boolean getRunning() {
        return running;
    }

    /**
     * Set the initial score when game starts.
     */
    public static void setScore(int score) {
        GameStageModel.score = score;
    }

    /**
     * Set the player's name.
     */
    public static void setName(String name) {
        GameStageModel.name = name;
    }

    /**
     * Get the player's name.
     */
    public static String getName() {
        return name;
    }

    /**
     * Get the final score when game ends.
     */
    public static int getScore() {
        return score;
    }

    /**
     * Set the initial asteroid fall speed when game starts.
     * @param speed Initial speed.
     */
    public static void setAsteroidFallSpeed(int speed) {
        GameStageModel.asteroidFallSpeed = speed;
    }

    /**
     * Get the asteroid fall speed.
     * @return The asteroid fall speed.
     */
    public static double getAsteroidFallSpeed() {
        return asteroidFallSpeed;
    }

}
