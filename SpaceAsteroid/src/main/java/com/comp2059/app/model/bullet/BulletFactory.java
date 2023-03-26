package com.comp2059.app.model.bullet;

import com.comp2059.app.model.AbstractFactory;
import com.comp2059.app.model.shuttle.*;
import com.comp2059.app.utils.Direction;

/**
 * Create corresponding bullet according to the player's choice using factory method pattern.
 * @author Yuening Xie
 * @version 1.0
 * @since 1 January 2023
 */
public class BulletFactory extends AbstractFactory {
    /**
     * Create corresponding bullet according to the player's choice.
     * @param bulletType The bullet type that the player choose.
     * @return Corresponding bullet class.
     */
    public AbstractBullet makeBullet(String bulletType, double shootX, double shootY, Direction direction) {
        return switch (bulletType) {
            case "Bullet1" -> new Bullet1(shootX, shootY, direction);
            case "Bullet2" -> new Bullet2(shootX, shootY, direction);
            case "Bullet3" -> new Bullet3(shootX, shootY, direction);
            default -> null;
        };
    }

    @Override
    public AbstractShuttle makeShuttle(String shuttleType) {
        return null;
    }
}
