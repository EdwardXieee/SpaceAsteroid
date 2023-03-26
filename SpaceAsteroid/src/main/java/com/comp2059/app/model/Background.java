package com.comp2059.app.model;

import javafx.scene.image.Image;

/**
 * This is Background class, responsible for defining background of game stage according to the background type users determine.
 * @author Yuening Xie
 * @version 2.0
 * @since  15 November 2022
 */
public class Background extends GameObjects{
    public static String backgroundType;
    public Background() {
        super(null, 0, 0, 1200, 720);
        image = new Image(backgroundType);
    }

}
