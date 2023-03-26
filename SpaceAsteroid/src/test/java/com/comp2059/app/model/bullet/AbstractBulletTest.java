package com.comp2059.app.model.bullet;

import com.comp2059.app.model.Asteroid;
import com.comp2059.app.utils.Direction;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AbstractBulletTest {

    @BeforeAll
    static void initJFX() {
        new JFXPanel();
    }

    /**
     * After colliding, shuttle's blood point will decrease by 1.
     */
    @Test
    void collideCheck1() {
        Bullet1 bullet1 = new Bullet1(100, 100, Direction.UP);
        Asteroid asteroid = new Asteroid(Direction.DOWN);
        bullet1.x = 100;
        bullet1.y = 100;
        bullet1.width = 100;
        bullet1.height = 100;
        asteroid.bloodPoint = 3;
        asteroid.x = 100;
        asteroid.y = 100;
        asteroid.width= 100;
        asteroid.height = 100;
        bullet1.collideCheck(asteroid);
        Assertions.assertEquals(2, asteroid.bloodPoint);
    }

    /**
     * If not colliding, shuttle's blood point will not decrease by 1.
     */
    @Test
    void collideCheck2() {
        Bullet1 bullet1 = new Bullet1(100, 100, Direction.UP);
        Asteroid asteroid = new Asteroid(Direction.DOWN);
        bullet1.x = 400;
        bullet1.y = 400;
        bullet1.width = 100;
        bullet1.height = 100;
        asteroid.bloodPoint = 3;
        asteroid.x = 100;
        asteroid.y = 100;
        asteroid.width= 100;
        asteroid.height = 100;
        bullet1.collideCheck(asteroid);
        Assertions.assertEquals(3, asteroid.bloodPoint);
    }
}
