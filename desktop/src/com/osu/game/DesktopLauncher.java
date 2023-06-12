package com.osu.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * Launcher for the game
 * routs to the EntryGame.java class
 *
 * @author FuzzDOT
 * @version FINAL on June 8, 2023
 */
public class DesktopLauncher {
    /**
     * main entry point for program
     *
     * @param arg default argument for main methods
     */
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("osu");
        new Lwjgl3Application(new MyGame(), config);
    }
}
