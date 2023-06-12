package com.osu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * The class for AudioPlayer. Plays the background music and the sound effect when a button is clicked.
 *
 * @author Faaz Mohamed
 * @version FINAL on June 8, 2023
 */
public class AudioPlayer {
    /**
     * represents the background music of the level
     */
    private final Music backgroundMusic;

    /**
     * represents the sound effect when a button is hit
     */
    private final Sound soundEffect;

    /**
     * initializes the above 2 fields
     */
    public AudioPlayer() {
        // Load and initialize the background music
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("white_aura.mp3"));

        // Load and initialize the sound effect
        soundEffect = Gdx.audio.newSound(Gdx.files.internal("hit_sound.wav"));
    }

    /**
     * plays the background music when called
     */
    public void playBackgroundMusic() {
        backgroundMusic.play();
    }

    /**
     * stops the background when called
     */
    public void stopBackgroundMusic() {
        backgroundMusic.stop();
    }

    /**
     * plays the sound effect when called
     */
    public void playSoundEffect() {
        soundEffect.play();
    }

    /**
     * disposes of all resources when called to free up the memory
     */
    public void dispose() {
        backgroundMusic.dispose();
        soundEffect.dispose();
    }
}
