package com.osu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * class for managing game fonts
 * @author Faaz Mohamed
 * @version FINAL on June 6, 2023
 */
public class MyGameFonts implements Disposable {
    /** instance of the class and makes sure that only one exists*/
    private static MyGameFonts instance;

    /** new default font*/
    private BitmapFont defaultFont;

    /** new title font*/
    private BitmapFont titleFont;

    /**
     * Private constructor to prevent direct instantiation.
     * Loads default and title fonts from file.
     */
    private MyGameFonts() {
        defaultFont = new BitmapFont(Gdx.files.internal("font.tff"));
        titleFont = new BitmapFont(Gdx.files.internal("font.tff"));
    }

    /**
     * Retrieves the instance of MyGameFonts.
     * Creates a new instance if it doesn't exist.
     *
     * @return The MyGameFonts instance.
     */
    public static MyGameFonts getInstance() {
        if (instance == null) {
            instance = new MyGameFonts();
        }
        return instance;
    }

    /**
     * Retrieves the default font.
     *
     * @return The default font.
     */
    public BitmapFont getDefaultFont() {
        return defaultFont;
    }

    /**
     * Retrieves the title font.
     *
     * @return The title font.
     */
    public BitmapFont getTitleFont() {
        return titleFont;
    }

    /**
     * Retrieves a font based on the given font name.
     * If the font name is "title", returns the title font.
     * Otherwise, returns the default font.
     *
     * @param fontName The name of the font.
     * @return The corresponding font.
     */
    public static BitmapFont getFont(String fontName) {
        MyGameFonts instance = getInstance();
        switch (fontName) {
            case "title":
                return instance.getTitleFont();
            default:
                return instance.getDefaultFont();
        }
    }

    /**
     * Disposes of the fonts, freeing up resources.
     */
    @Override
    public void dispose() {
        defaultFont.dispose();
        titleFont.dispose();
    }
}
