package com.osu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * creates a new end screen for the game
 * @author Faaz Mohamed
 * @version FINAL on June 8, 2023
 */
public class EndGameScreen implements Screen {
    /** stage for the objects to be placed */
    private Stage stage;

    /** viewport for the stage */
    private Viewport viewport;

    /** game logo */
    private Sprite logo;

    /** mellis pic */
    private Sprite otherImage;

    /** title text */
    private Label titleLabel;

    /** author text */
    private Label authorLabel;

    /**
     * creates a new EndGameScreen and initializes the fields
     */
    public EndGameScreen() {
        viewport = new FitViewport(800, 480);
        stage = new Stage(viewport);

        Texture logoTexture = new Texture("logo.png");
        Texture otherImageTexture = new Texture("other_image.png");
        logo = new Sprite(logoTexture);
        otherImage = new Sprite(otherImageTexture);

        titleLabel = createLabel("The End", "title");
        authorLabel = createLabel("Author: John Doe", "default");

        stage.addActor(titleLabel);
        stage.addActor(authorLabel);
    }

    /**
     * creates a new label
     * @param text the text to be said
     * @param styleName the name of the style of the text
     * @return the label
     */
    private Label createLabel(String text, String styleName) {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = MyGameFonts.getFont("font.ttf");
        Label label = new Label(text, labelStyle);
        label.setAlignment(Align.center);
        label.setPosition((viewport.getWorldWidth() - label.getWidth()) / 2, viewport.getWorldHeight() - 100);
        return label;
    }

    /**
     * Called when this screen becomes the current screen for a Game
     */
    @Override
    public void show() {Gdx.input.setInputProcessor(stage);}

    /**
     * Called when the screen should render itself
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Batch batch = stage.getBatch();
        batch.begin();
        logo.draw(batch);
        otherImage.draw(batch);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    /**
     * Called when the Application is resized. This can happen at any point during a non-paused state but will never happen before a call to create()
     * @param width new width of the screen
     * @param height new height of the screen
     */
    @Override
    public void resize(int width, int height) {viewport.update(width, height);}

    /**
     *
     Called when the Application is paused, usually when it's not active or visible on-screen. An Application is also paused before it is destroyed
     */
    @Override
    public void pause() {}

    /**
     * Called when the Application is resumed from a paused state, usually when it regains focus
     */
    @Override
    public void resume() {}

    /**
     *Called when this screen is no longer the current screen for a Game.
     */
    @Override
    public void hide() {}

    /**
     * Called when this screen should release all resources
     */
    @Override
    public void dispose() {
        stage.dispose();
        logo.getTexture().dispose();
        otherImage.getTexture().dispose();
    }
}
