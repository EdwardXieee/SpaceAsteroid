package com.comp2059.app.controller;

import com.comp2059.app.Director;
import com.comp2059.app.model.GameStageModel;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import static com.comp2059.app.model.GameStageModel.shuttle;

/**
 * This is gameStage controller to detect key activities by user in the game stage.
 * @author Yuening Xie, Jiafang Sun
 * @version 2.0
 * @since  19 November 2022
 */
public class GameStageController {
    public static class KeyProcess implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent keyEvent) {
            KeyCode keyCode = keyEvent.getCode();
            // If key is "P", pause the game and show the pause interface.
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
                if(keyCode == KeyCode.P && GameStageModel.getRunning()){
                    GameStageModel.setRunning(false);
                    Director.getDirector().toPauseGame();
                }
                else {
                    shuttle.keyReleased(keyCode);
                }
            }
            // If key is up, down, left, right or space, pass the key activity to the model to do the corresponding action.
            else if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
                shuttle.keyPressed(keyCode);
            }
        }
    }
}
