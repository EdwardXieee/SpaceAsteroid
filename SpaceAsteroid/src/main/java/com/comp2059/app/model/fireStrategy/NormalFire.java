package com.comp2059.app.model.fireStrategy;

import com.comp2059.app.model.AbstractFactory;
import com.comp2059.app.model.FactoryProducer;
import com.comp2059.app.model.bullet.AbstractBullet;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.utils.SoundEffect;

/**
 * Shuttle in level 1 will use this fire strategy.
 * The bullets will be fired only one line at a time
 * @author Jiafang Sun
 * @version 2.0
 * @since  20 December 2022
 */
public class NormalFire implements ShuttleFire{
    public AbstractFactory bulletFactory = FactoryProducer.getFactory("BULLET");
    @Override
    public void fire(double x, double y, Direction direction) {
        double bulletX = x + 45;
        double bulletY = y - 5;
        AbstractBullet bullet = bulletFactory.makeBullet("Bullet1", bulletX, bulletY, direction);
        SoundEffect.playShoot();
        GameStageModel.getGameStage().getBullets().add(bullet);
    }
}
