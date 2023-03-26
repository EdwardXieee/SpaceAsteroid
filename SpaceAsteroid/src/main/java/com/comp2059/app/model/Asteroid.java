package com.comp2059.app.model;

import com.comp2059.app.Director;
import com.comp2059.app.utils.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * This is Asteroid class.
 * Random number will be generated to determine which asteroid being created.
 * @author Yuening Xie
 * @version 2.0
 * @since  19 November 2022
 */
public class Asteroid extends Role{
    private final int ASTEROID_TYPE;

    /**
     * If rand1 is 0, create a big asteroid, otherwise, create the small one.
     * Small asteroids are three times more likely to be created than large ones.
     * Create different shapes of asteroids randomly.
     * @param direction The direction to move.
     */
    public Asteroid(Direction direction) {
        super(null,Math.random() * 1528, -170,0, 0,0, direction);
        int rand1 = (int) (Math.random() * 4);
        if (rand1 == 0){
            ASTEROID_TYPE = 0;
            int rand2 = (int) (Math.random() * 2);
            switch (rand2) {
                case 0 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_02.png")).toString());
                case 1 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_03.png")).toString());
            }
            width = height = 170;
            this.bloodPoint = 2;
        }
        else {
            ASTEROID_TYPE = 1;
            int rand3 = (int) (Math.random() * 5);
            switch (rand3) {
                case 0 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_01.png")).toString());
                case 1 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_06.png")).toString());
                case 2 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_07.png")).toString());
                case 3 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_09.png")).toString());
                case 4 -> image = new Image(Objects.requireNonNull(Asteroid.class.
                        getResource("/com/comp2059/app/img/asteroid/asteroid_10.png")).toString());
            }
            width = height = 100;
            this.bloodPoint = 1;
        }
    }

    /**
     * To make the asteroid move in a particular speed and remove the asteroid from ArrayList to avoid the memory overflow.
     */
    @Override
    public void move(double speed) {
        y += speed;

        if (y > 1500)
            GameStageModel.getGameStage().getAsteroids().remove(this);

        if (x > Director.WIDTH - width - 5) GameStageModel.getGameStage().getAsteroids().remove(this);
    }

    /**
     * Make the asteroid appear in the scene.
     * @param graphicsContext The property of the game stage scene.
     */
    @Override
    public void paint(GraphicsContext graphicsContext) {
        if (this.isAlive()) {
            GameStageModel.getGameStage().getAsteroids().remove(this);
            return;
        }
        super.paint(graphicsContext);
        move(GameStageModel.getAsteroidFallSpeed());
    }

    /**
     * 0 stands for big asteroid, 1 stands for small asteroid.
     * @return 0 or 1.
     */
    public int getAsteroidType() {
        return ASTEROID_TYPE;
    }
}
