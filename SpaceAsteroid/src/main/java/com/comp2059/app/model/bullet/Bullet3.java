package com.comp2059.app.model.bullet;

import com.comp2059.app.model.shuttle.Shuttle1;
import com.comp2059.app.utils.Direction;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This is bullet3 class to create bullet in level 3.
 * @author Jiafang Sun
 * @version 2.0
 * @since  19 December 2022
 */
public class Bullet3 extends AbstractBullet{
    public Bullet3(double x, double y, Direction direction) {
        super(new Image(Objects.requireNonNull(Shuttle1.class.getResource("/com/comp2059/app/img/others/level3Bullet.png")).toString()),
                x, y, 15, 25, 1, direction, 22);
    }
}

