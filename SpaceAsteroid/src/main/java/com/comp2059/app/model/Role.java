package com.comp2059.app.model;

import com.comp2059.app.utils.Direction;
import javafx.scene.image.Image;

/**
 * This is an abstract class inheriting GameObjects, objects that will spawn and disappear will inherit this clas.
 * @author  Yuening Xie, Jiafang Sun
 * @version 2.0
 * @since  15 November 2022
 */
public abstract class Role extends GameObjects {
    private boolean alive = true;
    public int bloodPoint;
    public Direction direction;

    public Role(Image image, double x, double y, double width, double height, int BloodPoint, Direction direction) {
        super(image, x, y, width, height);
        this.direction = direction;
        this.bloodPoint = BloodPoint;
    }

    /**
     * Objects moving with the given speed.
     * @param speed Moving speed.
     */
    public abstract void move(double speed);

    /**
     * To judge if the objects is alive
     */
    public boolean isAlive() {
        return !alive;
    }

    /**
     * To set the objects alive or not.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
