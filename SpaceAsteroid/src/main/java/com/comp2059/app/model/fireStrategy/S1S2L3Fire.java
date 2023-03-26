package com.comp2059.app.model.fireStrategy;

import com.comp2059.app.model.AbstractFactory;
import com.comp2059.app.model.FactoryProducer;
import com.comp2059.app.model.bullet.AbstractBullet;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.utils.SoundEffect;

/**
 * Shuttle 1 and shuttle 2 in level 3 will use this fire strategy.
 * The bullets will be fired three lines at a time
 * @author Jiafang Sun
 * @version 2.0
 * @since  20 December 2022
 */
public class S1S2L3Fire implements ShuttleFire{
    public AbstractFactory bulletFactory = FactoryProducer.getFactory("BULLET");
    @Override
    public void fire(double x, double y, Direction direction) {
        double bulletX1 = x + 25;
        double bulletY1 = y - 6;
        AbstractBullet bullet1 = bulletFactory.makeBullet("Bullet3", bulletX1, bulletY1, direction);
        double bulletX2 = x + 45;
        double bulletY2 = y - 5;
        AbstractBullet bullet2 = bulletFactory.makeBullet("Bullet3", bulletX2, bulletY2, direction);
        double bulletX3 = x + 65;
        double bulletY3 = y - 6;
        AbstractBullet bullet3 = bulletFactory.makeBullet("Bullet3", bulletX3, bulletY3, direction);
        SoundEffect.playShoot();
        GameStageModel.getGameStage().getBullets().add(bullet1);
        GameStageModel.getGameStage().getBullets().add(bullet2);
        GameStageModel.getGameStage().getBullets().add(bullet3);
    }
}
