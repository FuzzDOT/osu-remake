package com.osu.game;

import com.badlogic.gdx.Game;

/**
 * creates the switcher class
 * @author Faaz Mohamed
 * @version FINAL on June 8, 2023
 */
public class MyGame extends Game {

    /**
     * instance of this class for use
     */
    private static MyGame instance;

    /**
     * creates a new switcher class
     */
    public MyGame() {
        instance = this;
    }

    /**
     * Called when the Application is first created
     */
    @Override
    public void create() {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        mainMenuScreen.setGame(this);
        setScreen(mainMenuScreen);
    }

    /**
     * dispose of resources to free up memory
     */
    @Override
    public void dispose() {
        super.dispose();
    }
}
