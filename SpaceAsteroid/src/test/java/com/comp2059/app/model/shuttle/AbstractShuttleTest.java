package com.comp2059.app.model.shuttle;

import com.comp2059.app.model.Asteroid;
import com.comp2059.app.utils.Direction;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AbstractShuttleTest {

    @BeforeAll
    static void initJFX() {
        new JFXPanel();
    }

    /**
     * After colliding, shuttle's blood point will decrease by 1.
     */
    @Test
    void collideCheck1() {
        Asteroid asteroid = new Asteroid(Direction.DOWN);
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.x = 100;
        shuttle1.y = 100;
        shuttle1.width = 100;
        shuttle1.height = 100;
        shuttle1.bloodPoint = 3;
        asteroid.x = 100;
        asteroid.y = 100;
        asteroid.width= 100;
        asteroid.height = 100;
        shuttle1.collideCheck(asteroid);
        Assertions.assertEquals(2, shuttle1.bloodPoint);
    }

    /**
     * If not colliding, shuttle's blood point will not decrease by 1.
     */
    @Test
    void collideCheck2() {
        Asteroid asteroid = new Asteroid(Direction.DOWN);
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.x = 400;
        shuttle1.y = 400;
        shuttle1.width = 100;
        shuttle1.height = 100;
        shuttle1.bloodPoint = 3;
        asteroid.x = 100;
        asteroid.y = 100;
        asteroid.width= 100;
        asteroid.height = 100;
        shuttle1.collideCheck(asteroid);
        Assertions.assertEquals(3, shuttle1.bloodPoint);
    }

    /**
     * When goUp is true, others are false, the direction will be UP.
     */
    @Test
    void redirectUp() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.goUp = true;
        shuttle1.goLeft = false;
        shuttle1.goRight = false;
        shuttle1.goDown = false;
        shuttle1.redirect();
        Assertions.assertEquals(Direction.UP, shuttle1.direction);
    }

    /**
     * When goLeft is true, others are false, the direction will be LEFT.
     */
    @Test
    void redirectLeft() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.goUp = false;
        shuttle1.goLeft = true;
        shuttle1.goRight = false;
        shuttle1.goDown = false;
        shuttle1.redirect();
        Assertions.assertEquals(Direction.LEFT, shuttle1.direction);
    }

    /**
     * When goRight is true, others are false, the direction will be RIGHT.
     */
    @Test
    void redirectRight() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.goUp = false;
        shuttle1.goLeft = false;
        shuttle1.goRight = true;
        shuttle1.goDown = false;
        shuttle1.redirect();
        Assertions.assertEquals(Direction.RIGHT, shuttle1.direction);
    }

    /**
     * When goDown is true, others are false, the direction will be DOWN.
     */
    @Test
    void redirectDown() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.goUp = false;
        shuttle1.goLeft = false;
        shuttle1.goRight = false;
        shuttle1.goDown = true;
        shuttle1.redirect();
        Assertions.assertEquals(Direction.DOWN, shuttle1.direction);
    }

    /**
     * When two or more keys are pressed simultaneously, the direction will be STOP.
     */
    @Test
    void redirectTwoKeysPressed() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.goUp = false;
        shuttle1.goLeft = false;
        shuttle1.goRight = true;
        shuttle1.goDown = true;
        shuttle1.redirect();
        Assertions.assertEquals(Direction.STOP, shuttle1.direction);
    }

    /**
     * Shuttle1 upgrades to level 2, the speed will change to 8.
     */
    @Test
    void upgrade1() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.upgrade1();
        Assertions.assertEquals(8, shuttle1.speed);
    }

    /**
     * Shuttle1 upgrades to level 2, the speed will change to 8.
     */
    @Test
    void upgrade2() {
        Shuttle1 shuttle1 = new Shuttle1();
        shuttle1.upgrade2();
        Assertions.assertEquals(10, shuttle1.speed);
    }

}
