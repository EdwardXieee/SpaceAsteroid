package com.comp2059.app.model;

import com.comp2059.app.model.bullet.BulletFactory;
import com.comp2059.app.model.shuttle.ShuttleFactory;

/**
 * This class is a factory generator to get corresponding factory by passing bullet or shuttle information.
 * @author Yuening Xie
 * @version 1.0
 * @since 1 January 2023
 */
public class FactoryProducer {
    /**
     * To generate corresponding factory according to choice.
     * @param choice Bullet or Shuttle.
     * @return BulletFactory or ShuttleFactory.
     */
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("BULLET")){
            return new BulletFactory();
        } else if(choice.equalsIgnoreCase("SHUTTLE")){
            return new ShuttleFactory();
        }
        return null;
    }
}
