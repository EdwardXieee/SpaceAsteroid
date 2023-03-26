package com.comp2059.app;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main application of all game, to launch the game.
 * @author Yuening Xie, Jiafang Sun
 * @version 2.0
 * @since  13 November 2022
 */
public class SpaceAsteroid extends Application {

    /**
     * Print the current working directory in terminal.
     * Initialize and go to the primary stage.
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Current working directory : " + System.getProperty("user.dir"));
        Director.getDirector().init(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
