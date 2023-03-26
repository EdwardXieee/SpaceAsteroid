package com.comp2059.app.model;

import com.comp2059.app.model.bullet.AbstractBullet;
import com.comp2059.app.model.shuttle.AbstractShuttle;
import com.comp2059.app.utils.Direction;

/**
 * Create abstract classes for the Bullet and Shuttle objects to get the factory.
 * Apply abstract factory pattern to create Bullet and Shuttle.
 * @author Yuening Xie
 * @version 1.0
 * @since 1 January 2023
 */
public abstract class AbstractFactory {
    public abstract AbstractBullet makeBullet(String bulletType, double shootX, double shootY, Direction direction);
    public abstract AbstractShuttle makeShuttle(String shuttleType);
}
