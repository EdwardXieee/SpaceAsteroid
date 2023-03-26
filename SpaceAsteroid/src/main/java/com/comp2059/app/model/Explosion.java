package com.comp2059.app.model;

import javafx.animation.PauseTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;
import java.util.Objects;

/**
 * This is Explosion class, responsible for create explosion and control the place of explosion.
 * @author Yuening Xie
 * @version 1.0
 * @since  17 November 2022
 */
public class Explosion extends GameObjects {
    private boolean play = true;

    public Explosion(double x, double y) {
        super(new Image(Objects.requireNonNull(Explosion.class.getResource("/com/comp2059/app/img/others/explosion.gif")).toString()),
                x, y, 142, 200);
    }

    /**
     * Make the explosion appear in the scene and let the explosion not loop infinitely.
     * @param graphicsContext The property of the game stage scene.
     */
    @Override
    public void paint(GraphicsContext graphicsContext) {
        double ex = x - image.getWidth()/2;
        double ey = y - image.getHeight()/2;

        if (play) {
            graphicsContext.drawImage(image, ex, ey);
            PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
            // Pause 0.8s to let the gif display.
            wait.setOnFinished(event -> play = false);
            wait.play();
        }

    }


}
