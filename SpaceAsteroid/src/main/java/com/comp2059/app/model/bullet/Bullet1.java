package com.comp2059.app.model.bullet;

import com.comp2059.app.model.shuttle.Shuttle1;
import com.comp2059.app.utils.Direction;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This is bullet1 class to create bullet in level 1.
 * @author Jiafang Sun
 * @version 2.0
 * @since  19 December 2022
 */
public class Bullet1 extends AbstractBullet{
    public Bullet1(double x, double y, Direction direction) {
        super(new Image(Objects.requireNonNull(Shuttle1.class.getResource("/com/comp2059/app/img/others/level1Bullet.png")).toString()),
                x, y, 15, 25, 1, direction, 11);
    }
}
