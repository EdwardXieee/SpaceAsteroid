package com.comp2059.app.model.shuttle;

import com.comp2059.app.model.fireStrategy.NormalFire;
import com.comp2059.app.model.fireStrategy.S3S4L2Fire;
import com.comp2059.app.model.fireStrategy.S3S4L3Fire;
import com.comp2059.app.utils.Direction;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * This is Shuttle 3 class, responsible for defining the fundamental properties of the shuttle and upgrade.
 * @author Jiafang Sun
 * @version 1.0
 * @since 20 December 2022
 */
public class Shuttle3 extends AbstractShuttle {
    public Shuttle3() {
        super(null, 560, 500, 100, 100, 5, Direction.STOP, 4);
        image = new Image(Objects.requireNonNull(getClass().
                getResource("/com/comp2059/app/img/shuttle/shuttle3.png")).toString());
        shuttleFire = new NormalFire();
    }

    /**
     * Upgrade the shuttle to level 2, change the shuttle image, strengthen the power of fire and increase the moving speed of the shuttle.
     */
    public void upgrade1() {
        image = new Image(Objects.requireNonNull(getClass().
                getResource("/com/comp2059/app/img/shuttle/shuttle3L2.png")).toString());
        shuttleFire = new S3S4L2Fire();
        speed = 6;
    }

    /**
     * Upgrade the shuttle to level 3, change the shuttle image, strengthen the power of fire and increase the moving speed of the shuttle.
     */
    public void upgrade2() {
        image = new Image(Objects.requireNonNull(getClass().
                getResource("/com/comp2059/app/img/shuttle/shuttle3L3.png")).toString());
        shuttleFire = new S3S4L3Fire();
        speed = 8;
    }

}
