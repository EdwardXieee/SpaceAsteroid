package com.comp2059.app.utils;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Objects;

/**
 * This class is a utility class to play various sounds, like explosion, button and background music.
 * @author Yuening Xie
 * @version 2.0
 * @since  19 November 2022
 */
public class SoundEffect {
    private static double volume = 0.1;
    public static final MediaPlayer BGM = new MediaPlayer(new Media(Objects.requireNonNull(SoundEffect.class
            .getResource("/com/comp2059/app/sound/cornfield_chase.wav")).toString()));
    private static final AudioClip BUTTON = new AudioClip(Objects.requireNonNull(SoundEffect.class
            .getResource("/com/comp2059/app/sound/button.wav")).toString());
    private static final AudioClip SHOOT = new AudioClip(Objects.requireNonNull(SoundEffect.class
            .getResource("/com/comp2059/app/sound/shoot.wav")).toString());
    private static final AudioClip EXPLOSION = new AudioClip(Objects.requireNonNull(SoundEffect.class
            .getResource("/com/comp2059/app/sound/explosion.wav")).toString());

    /**
     * To play background music circularly.
     */
    public static void playBgm() {
        BGM.setCycleCount(MediaPlayer.INDEFINITE);
        BGM.setVolume(volume * 7);
        BGM.play();
    }

    /**
     * To stop the background music when clicking mute button.
     */
    public static void stopBgm() {
        BGM.stop();
    }

    /**
     * To play the soundImage of button when clicking the button.
     */
    public static void playButton() {
        BUTTON.setVolume(volume * 0.7);
        BUTTON.play();
    }

    /**
     * To play the soundImage of bullets being fired when shooting.
     */
    public static void playShoot() {
        SHOOT.setVolume(volume * 2.5);
        SHOOT.play();
    }

    /**
     * To play the soundImage of explosion when bullet or shuttle colliding the asteroids.
     */
    public static void playExplosion() {
        EXPLOSION.setVolume(volume * 2);
        EXPLOSION.play();
    }

    /**
     * Mute.
     */
    public static void mute() {
        volume = 0;
        stopBgm();
    }

    /**
     * Restore the volume when cancel mute.
     * Play button soundImage when turning on.
     */
    public static void restoreVolume() {
        volume = 0.1;
        playButton();
        playBgm();
    }

}
