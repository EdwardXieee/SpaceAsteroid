package com.comp2059.app.model.shuttle;

import com.comp2059.app.Director;
import com.comp2059.app.model.*;
import com.comp2059.app.model.fireStrategy.ShuttleFire;
import com.comp2059.app.utils.Direction;
import com.comp2059.app.utils.SoundEffect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

/**
 * This is abstract shuttle class, defining the method of key event detect, move, collide check and fire.
 * @author Jiafang Sun
 * @version 2.0
 * @since 20 December 2022
 */
public abstract class AbstractShuttle extends Role {
    private boolean alive = true;
    public ShuttleFire shuttleFire;

    public int speed;

    boolean goUp, goDown, goLeft, goRight;

    public AbstractShuttle(Image image, double x, double y, double width, double height, int BloodPoint, Direction direction, int speed) {
        super(image, x, y, width, height, BloodPoint, direction);
        this.speed = speed;
    }

    /**
     * To check if the shuttle collide with asteroid.
     * @param asteroid The asteroid fly to shuttle.
     */
    public void collideCheck(Asteroid asteroid) {
        if (asteroid != null && getCounter().intersects(asteroid.getCounter())) {
            SoundEffect.playExplosion();
            this.bloodPoint -= 1;
            asteroid.setAlive(false);
            GameStageModel.getGameStage().getExplosions().add(new Explosion(x, y));
            if (this.bloodPoint == 0) {
                this.setAlive(false);
            }
        }
    }

    /**
     * To judge if the shuttle is alive.
     */
    public boolean isAlive() {
        return !alive;
    }

    /**
     * To set the shuttle whether alive.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Check which key is pressed.
     * @param keyCode The key is pressed.
     */
    public void keyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case UP -> goUp = true;
            case DOWN -> goDown = true;
            case LEFT -> goLeft = true;
            case RIGHT -> goRight = true;
        }
        redirect();
    }

    /**
     * Check which key is released.
     * @param keyCode The key is released.
     */
    public void keyReleased(KeyCode keyCode) {
        switch (keyCode) {
            case SPACE -> fire();
            case UP -> goUp = false;
            case DOWN -> goDown = false;
            case LEFT -> goLeft = false;
            case RIGHT -> goRight = false;
        }
        redirect();
    }

    /**
     * Fire the bullet.
     */
    public void fire() {
        shuttleFire.fire(x, y, direction);
    }

    /**
     * According to the judgement of keyReleased and keyPressed to redirect the flying direction.
     */
    public void redirect() {
        if (goUp && !goDown && !goLeft && !goRight)
            direction = Direction.UP;
        else if (!goUp && goDown && !goLeft && !goRight)
            direction = Direction.DOWN;
        else if (!goUp && !goDown && goLeft && !goRight)
            direction = Direction.LEFT;
        else if (!goUp && !goDown && !goLeft && goRight)
            direction = Direction.RIGHT;
        else
            direction = Direction.STOP;
    }

    /**
     * Make the shuttle move and check if the shuttle reaches the boundary。
     */
    @Override
    public void move(double delta) {
        switch (direction) {
            case UP -> y -= delta;
            case DOWN -> y += delta;
            case LEFT -> x -= delta;
            case RIGHT -> x += delta;
        }
        //Creating an invisible game wall border.
        if (x < -20) x = -20;
        if (y < 0) y =0;
        if (x > Director.WIDTH - 80) x = Director.WIDTH - 80;
        if (y > Director.HEIGHT - 120) y = Director.HEIGHT - 120;

    }

    /**
     * Upgrade the shuttle to level 2, change the shuttle image, strengthen the power of fire and increase the moving speed of the shuttle.
     */
    public abstract void upgrade1();

    /**
     * Upgrade the shuttle to level 3, change the shuttle image, strengthen the power of fire and increase the moving speed of the shuttle.
     */
    public abstract void upgrade2();

    /**
     * Make the shuttle appear in the scene and specify its speed by move method.
     * @param graphicsContext The property of the game stage scene.
     */
    @Override
    public void paint(GraphicsContext graphicsContext) {
        if (this.isAlive()) {
            SoundEffect.playExplosion();
            return;
        }
        if (GameStageModel.getScore() > 75) {
            upgrade1();
        }
        if (GameStageModel.getScore() > 150) {
            upgrade2();
        }
        super.paint(graphicsContext);
        move(speed);
    }
}

