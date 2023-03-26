package com.comp2059.app.model.fireStrategy;

import com.comp2059.app.utils.Direction;
/**
 * This interface enables classes that implement it to apply various kinds of fire strategy according to strategy pattern.
 * @author Jiafang Sun
 * @version 2.0
 * @since  20 December 2022
 */
public interface ShuttleFire {
    /**
     * Define the location and direction of fire and create it by adding it to "WEAPONS" arraylist.
     * @param x The x-coordinate of the shuttle.
     * @param y The y-coordinate of the shuttle.
     * @param direction The direction of bullet.
     */
    void fire(double x, double y, Direction direction);
}
