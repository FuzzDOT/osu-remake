package com.osu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Represents the menu screen of the game. Also, the screen that the user lands on when launching the game
 * @author Faaz Mohamed
 * @version FINAL on June 8, 2023
 */
public class MainMenuScreen extends ScreenAdapter {
    /** width of the screen */
    private static final float SCREEN_WIDTH = 800;

    /** height of the screen */
    private static final float SCREEN_HEIGHT = 600;

    /** stage on which objects are drawn */
    private Stage stage;

    /** viewport of the camera */
    private Viewport viewport;

    /** where objects are drawn to */
    private Batch batch;

    /** represents what the viewer is seeing */
    private OrthographicCamera camera;

    /** instance of the switcher class */
    private MyGame game;

    /**
     * creates a new menu screen and initializes all fields
     */
    public MainMenuScreen() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);
        batch = new SpriteBatch();
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);

        // Create a table to hold the menu elements
        Table table = new Table();
        table.setFillParent(true);

        // Create a logo image
        Texture logoTexture = new Texture(Gdx.files.internal("logo.png"));
        Image logoImage = new Image(logoTexture);

        // Add the logo image to the table
        table.add(logoImage).padBottom(50f).row();

        // Create a play button
        Texture playButtonTexture = new Texture(Gdx.files.internal("play_button_inactive.png"));
        Image playButtonImage = new Image(playButtonTexture);
        playButtonImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handlePlayButtonClick();
            }
        });

        // Add the play button to the table
        table.add(playButtonImage).row();

        // Add the table to the stage
        stage.addActor(table);
    }

    /**
     * Called when the screen should render itself.
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    /**
     * Called when the Application is resized. This can happen at any point during a non-paused state but will never happen before a call to create()
     * @param width new width
     * @param height new height
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    /**
     * just an initializer
     * @param game the instance of the switcher class
     */
    public void setGame(MyGame game){
        this.game = game;
    }

    /**
     * called to dispose of resources and free up memory
     */
    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
    }

    /**
     * switches screen to game screen when play button is clicked
     */
    public void handlePlayButtonClick() {
        game.setScreen(new MainGameScreen());
    }
}
