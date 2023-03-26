package com.comp2059.app.model.shuttle;

import com.comp2059.app.model.AbstractFactory;
import com.comp2059.app.model.bullet.AbstractBullet;
import com.comp2059.app.utils.Direction;

/**
 * Create corresponding shuttle according to the player's choice using factory method pattern.
 * @author Jiafang Sun
 * @version 2.0
 * @since 20 December 2022
 */
public class ShuttleFactory extends AbstractFactory {
    /**
     * Create corresponding shuttle according to the player's choice.
     * @param shuttleType The shuttle type that the player choose.
     * @return Corresponding shuttle class.
     */
    @Override
    public AbstractShuttle makeShuttle(String shuttleType) {
        return switch (shuttleType) {
            case "Shuttle1" -> new Shuttle1();
            case "Shuttle2" -> new Shuttle2();
            case "Shuttle3" -> new Shuttle3();
            case "Shuttle4" -> new Shuttle4();
            default -> null;
        };
    }

    @Override
    public AbstractBullet makeBullet(String bulletType, double shootX, double shootY, Direction direction) {
        return null;
    }
}
