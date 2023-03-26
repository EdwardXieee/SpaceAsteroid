package com.comp2059.app.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This is a parent class of all classes what the game can see, including their image, place, size and stage.
 * @author Yuening Xie,Jiafang Sun
 * @version 2.0
 * @since  19 November 2022
 */
public abstract class GameObjects {
    public Image image;
    public double x, y, width, height;

    public GameObjects(Image image, double x, double y, double width, double height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Paint the image on the scene.
     * @param graphicsContext The property of the game stage scene.
     */
    public void paint(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(image, x, y, width, height);
    }

    /**
     * Generate a Rectangle2D instance to detect collision.
     * @return Rectangle2D instance.
     */
    public Rectangle2D getCounter() {
        return new Rectangle2D(x, y, width, height);
    }
}
