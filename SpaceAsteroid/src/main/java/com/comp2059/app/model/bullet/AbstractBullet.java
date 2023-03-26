package com.comp2059.app.model.bullet;

import com.comp2059.app.model.Asteroid;
import com.comp2059.app.model.Explosion;
import com.comp2059.app.model.GameStageModel;
import com.comp2059.app.model.Role;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.utils.SoundEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

/**
 * This is abstract bullet class, defining the method of moving, painting and collide check.
 * Classes inheriting this class will define various types of bullet
 * and use the factory method pattern to create when it needs to be created.
 * @author Jiafang Sun
 * @version 2.0
 * @since  19 December 2022
 */
public abstract class AbstractBullet extends Role {
    /**
     * The speed of different bullets.
     */
    public int speed;

    public AbstractBullet(Image image, double x, double y, double width, double height, int BloodPoint, Direction direction, int speed) {
        super(image, x, y, width, height, BloodPoint, direction);
        this.direction = direction;
        this.bloodPoint = BloodPoint;
        this.speed = speed;
    }

    /**
     * To make the bullet move in a particular speed and remove the bullet from ArrayList to avoid the memory overflow.
     */
    @Override
    public void move(double delta) {
        y -= delta;
        if (y < -10)
            GameStageModel.getGameStage().getBullets().remove(this);
    }

    /**
     * Make the bullet appear in the scene.
     * @param graphicsContext The property of the game stage scene.
     */
    @Override
    public void paint(GraphicsContext graphicsContext)  {
        if (this.isAlive()) {
            GameStageModel.getGameStage().getBullets().remove(this);
            GameStageModel.getGameStage().getExplosions().add(new Explosion(x, y));
            SoundEffect.playExplosion();
            return;
        }
        super.paint(graphicsContext);
        move(speed);
    }

    /**
     * To check if the bullet collide with asteroid.
     * If the asteroid is a big one, user should shoot twice to destroy the asteroid.
     * When the big asteroid is shot the first time, the asteroid will be replaced by a cracked asteroid.
     * @param asteroid The asteroid fly to bullet.
     */
    public void collideCheck(Asteroid asteroid) {
        if (asteroid != null && getCounter().intersects(asteroid.getCounter())) {
            // Big asteroid.
            if (asteroid.getAsteroidType() == 0){
                asteroid.bloodPoint = asteroid.bloodPoint - 1;
                this.setAlive(false);
                if (asteroid.bloodPoint == 0){
                    asteroid.setAlive(false);
                    GameStageModel.setScore(GameStageModel.getScore() + 4);
                }
                else {
                    // If the asteroid has been shot once, display the cracked asteroid.
                    String suffix = "_crack.png";
                    asteroid.image = new Image(asteroid.image.getUrl().substring(0, asteroid.image.getUrl().length() - 4).concat(suffix));
                }
            // Small asteroid.
            } else if (asteroid.getAsteroidType() == 1){
                asteroid.bloodPoint = asteroid.bloodPoint - 1;
                this.setAlive(false);
                if (asteroid.bloodPoint == 0){
                    asteroid.setAlive(false);
                }
                GameStageModel.setScore(GameStageModel.getScore() + 2);
            }
        }
    }

    /**
     * Traverse all asteroids to check if the bullet collide with asteroid.
     */
    public void collide(List<Asteroid> asteroids) {
         for (Asteroid a : asteroids) {
              collideCheck(a);
         }
    }
}
