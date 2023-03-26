package com.comp2059.app.model;

import com.comp2059.app.model.bullet.Bullet1;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.view.GameStageView;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameStageModelTest {

    @BeforeAll
    static void initJFX() {
        new JFXPanel();
    }

    /**
     * When score is 100, the image will be level5.
     */
    @Test
    void createAsteroid() {
        GameStageModel.setScore(100);
        GameStageModel.getGameStage().createAsteroid();
        int length = GameStageView.getGameStageView().level.getImage().getUrl().length();
        Assertions.assertEquals("level5", GameStageView.getGameStageView().level.getImage().getUrl().substring(length - 10, length - 4));
    }

    /**
     * All arraylist's elements should be cleared.
     */
    @Test
    void clearData() {
        GameStageModel.getGameStage().getBullets().add(new Bullet1(100, 100, Direction.UP));
        GameStageModel.getGameStage().getExplosions().add(new Explosion(100, 100));
        GameStageModel.getGameStage().getAsteroids().add(new Asteroid(Direction.DOWN));
        GameStageModel.getGameStage().clearData();
        boolean isEmpty = GameStageModel.getGameStage().getBullets().isEmpty()
                && GameStageModel.getGameStage().getAsteroids().isEmpty()
                && GameStageModel.getGameStage().getExplosions().isEmpty();
        Assertions.assertTrue(isEmpty);
    }
}
