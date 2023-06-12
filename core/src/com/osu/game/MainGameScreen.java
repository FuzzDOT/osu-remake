package com.osu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;

/**
 * The main game screen where the gameplay takes place.
 * @author FuzzDOT
 * @version FINAL on June 8, 2023
 */
public class MainGameScreen implements Screen {
    /** creates the stage for the objects to be rendered on */
    private Stage stage;

    /** viewport for the camera */
    private Viewport viewport;

    /** represents that the user sees */
    private OrthographicCamera camera;

    /** image of the slider */
    private Image sliderBackground;

    /** image of the slider button */
    private Image sliderButton;

    /** image of button 1 */
    private Image hitButton1;

    /** image of button 2 */
    private Image hitButton2;

    /** image of button 3 */
    private Image hitButton3;

    /** image of button 4 */
    private Image hitButton4;

    /** image of button 5 */
    private Image hitButton5;

    /** image of button 6 */
    private Image hitButton6;

    /** image of button 7 */
    private Image hitButton7;

    /** image of button 8 */
    private Image hitButton8;

    /** image of button 9 */
    private Image hitButton9;

    /** image of button 10 */
    private Image hitButton10;

    /** image of button 11 */
    private Image hitButton11;

    /** image of button 12 */
    private Image hitButton12;

    /** image of button 13 */
    private Image hitButton13;

    /** image of button 12 */
    private Image hitButton14;

    /** image of slider 2 */
    private Image sliderBackground2;

    /** image of sliderButton 2 */
    private Image sliderButton2;

    /** link to the hit sound effect */
    private Sound hitSound;

    /** link to the background music */
    private Music backgroundMusic;

    /** has the song ended? */
    private boolean songEnded;

    /** array list with all the batch items to be rendered one at a time */
    private List<Image> batchItems;

    /** delay in seconds between each item render */
    private float delayTimer;

    /** total item delay for logic reasons */
    private float itemDelay;

    /**
     * Called when the screen is shown.
     * Initializes the game screen, including the stage, camera, images, sounds, and input listeners.
     */
    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(800, 480, camera);
        stage = new Stage(viewport);

        sliderBackground = new Image(new Texture("Straight Long 1.png"));
        sliderButton = new Image(new Texture("white buttons/white 1.png"));
        hitButton1 = new Image(new Texture("white buttons/white 1.png"));
        hitButton2 = new Image(new Texture("white buttons/white 2.png"));
        hitButton3 = new Image(new Texture("white buttons/white 3.png"));
        hitButton4 = new Image(new Texture("white buttons/white 4.png"));
        hitButton5 = new Image(new Texture("white buttons/white 5.png"));
        hitButton6 = new Image(new Texture("white buttons/white 6.png"));
        hitButton7 = new Image(new Texture("white buttons/white 7.png"));
        hitButton8 = new Image(new Texture("blue buttons/blue 1.png"));
        hitButton9 = new Image(new Texture("blue buttons/blue 2.png"));
        hitButton10 = new Image(new Texture("blue buttons/blue 3.png"));
        hitButton11 = new Image(new Texture("blue buttons/blue 4.png"));
        hitButton12 = new Image(new Texture("blue buttons/blue 5.png"));
        hitButton13 = new Image(new Texture("blue buttons/blue 6.png"));
        hitButton14 = new Image(new Texture("blue buttons/blue 7.png"));
        sliderBackground2 = new Image(new Texture("Straight Long 1.png"));
        sliderButton2 = new Image(new Texture("white buttons/white 2.png"));

        sliderBackground.setBounds(100, 200, 500, 32);
        sliderButton.setBounds(100, 200, 32, 32);
        hitButton1.setBounds(150, 150, 32, 32);
        hitButton2.setBounds(300, 150, 32, 32);
        hitButton3.setBounds(450, 150, 32, 32);
        hitButton4.setBounds(150, 150, 32, 32);
        hitButton5.setBounds(300, 150, 32, 32);
        hitButton6.setBounds(450, 150, 32, 32);
        hitButton7.setBounds(150, 150, 32, 32);
        hitButton8.setBounds(300, 150, 32, 32);
        hitButton9.setBounds(450, 150, 32, 32);
        hitButton10.setBounds(150, 150, 32, 32);
        hitButton11.setBounds(300, 150, 32, 32);
        hitButton12.setBounds(450, 150, 32, 32);
        hitButton13.setBounds(300, 150, 32, 32);
        hitButton14.setBounds(450, 150, 32, 32);
        sliderBackground2.setBounds(100, 200, 500, 32);
        sliderButton2.setBounds(100, 200, 32, 32);

        hitSound = Gdx.audio.newSound(Gdx.files.internal("hit_sound.wav"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("white_aura.mp3"));

        sliderButton.setTouchable(Touchable.enabled);
        sliderButton.addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                float newX = sliderButton.getX() + x;
                newX = Math.max(newX, sliderBackground.getX());
                newX = Math.min(newX, sliderBackground.getX() + sliderBackground.getWidth() - sliderButton.getWidth());
                sliderButton.setX(newX);
                hitSound.play();
            }
        });

        sliderButton2.setTouchable(Touchable.enabled);
        sliderButton2.addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                float newX = sliderButton2.getX() + x;
                newX = Math.max(newX, sliderBackground2.getX());
                newX = Math.min(newX, sliderBackground2.getX() + sliderBackground2.getWidth() - sliderButton2.getWidth());
                sliderButton2.setX(newX);
                hitSound.play();
            }
        });

        hitButton1.setTouchable(Touchable.enabled);
        hitButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton1.remove();
                hitSound.play();
            }
        });

        hitButton2.setTouchable(Touchable.enabled);
        hitButton2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton2.remove();
                hitSound.play();
            }
        });

        hitButton3.setTouchable(Touchable.enabled);
        hitButton3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton3.remove();
                hitSound.play();
            }
        });

        hitButton4.setTouchable(Touchable.enabled);
        hitButton4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton4.remove();
                hitSound.play();
            }
        });

        hitButton5.setTouchable(Touchable.enabled);
        hitButton5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton5.remove();
                hitSound.play();
            }
        });

        hitButton6.setTouchable(Touchable.enabled);
        hitButton6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton6.remove();
                hitSound.play();
            }
        });

        hitButton7.setTouchable(Touchable.enabled);
        hitButton7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton7.remove();
                hitSound.play();
            }
        });

        hitButton8.setTouchable(Touchable.enabled);
        hitButton8.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton8.remove();
                hitSound.play();
            }
        });

        hitButton9.setTouchable(Touchable.enabled);
        hitButton9.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton9.remove();
                hitSound.play();
            }
        });

        hitButton10.setTouchable(Touchable.enabled);
        hitButton10.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton10.remove();
                hitSound.play();
            }
        });

        hitButton11.setTouchable(Touchable.enabled);
        hitButton11.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton11.remove();
                hitSound.play();
            }
        });

        hitButton12.setTouchable(Touchable.enabled);
        hitButton12.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton12.remove();
                hitSound.play();
            }
        });

        hitButton13.setTouchable(Touchable.enabled);
        hitButton13.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton13.remove();
                hitSound.play();
            }
        });

        hitButton14.setTouchable(Touchable.enabled);
        hitButton14.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hitButton14.remove();
                hitSound.play();
            }
        });


        backgroundMusic.setLooping(false);
        backgroundMusic.play();

        stage.addActor(sliderBackground);
        stage.addActor(sliderButton);
        stage.addActor(hitButton1);
        stage.addActor(hitButton2);
        stage.addActor(hitButton3);
        stage.addActor(hitButton4);
        stage.addActor(hitButton5);
        stage.addActor(hitButton6);
        stage.addActor(hitButton7);
        stage.addActor(hitButton8);
        stage.addActor(hitButton9);
        stage.addActor(hitButton10);
        stage.addActor(hitButton11);
        stage.addActor(hitButton12);
        stage.addActor(hitButton13);
        stage.addActor(hitButton14);
        stage.addActor(sliderBackground2);
        stage.addActor(sliderButton2);

        Gdx.input.setInputProcessor(stage);
        songEnded = false;

        batchItems = new ArrayList<>();
        batchItems.add(hitButton1);
        batchItems.add(hitButton2);
        batchItems.add(hitButton3);
        batchItems.add(hitButton4);
        batchItems.add(hitButton5);
        batchItems.add(hitButton6);
        batchItems.add(hitButton7);
        batchItems.add(hitButton8);
        batchItems.add(hitButton9);
        batchItems.add(hitButton10);
        batchItems.add(hitButton11);
        batchItems.add(hitButton12);
        batchItems.add(hitButton13);
        batchItems.add(hitButton14);
        stage.addActor(sliderBackground2);
        stage.addActor(sliderButton2);
        itemDelay = 3.0f; // Set the delay between rendering batch items
        delayTimer = 0.0f;
    }

    /**
     * Renders the game screen.
     * Clears the screen, updates the stage, and checks if the slider button has reached the right end of the slider
     * or if the song has ended to show the end screen.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        if (sliderButton.getX() + sliderButton.getWidth() >= sliderBackground.getX() + sliderBackground.getWidth()) {
            removeSliderAndButton();
        }

        if (sliderButton2.getX() + sliderButton2.getWidth() >= sliderBackground2.getX() + sliderBackground2.getWidth()) {
            removeSliderAndButton2();
        }

        if (!songEnded && !backgroundMusic.isPlaying()) {
            showEndScreen();
            songEnded = true;
        }

        // Render batch items one by one with a delay
        delayTimer += delta;
        if (delayTimer >= itemDelay) {
            delayTimer = 0.0f;
            renderNextBatchItem();
        }
    }

    /**
     * Resizes the screen viewport.
     *
     * @param width  The new width of the screen.
     * @param height The new height of the screen.
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    /**
     * Pauses the background music.
     */
    @Override
    public void pause() {
        backgroundMusic.pause();
    }

    /**
     * Resumes playing the background music.
     */
    @Override
    public void resume() {
        backgroundMusic.play();
    }

    /**
     * Stops the background music.
     */
    @Override
    public void hide() {
        backgroundMusic.stop();
    }

    /**
     * Disposes of resources used by the game screen.
     */
    @Override
    public void dispose() {
        stage.dispose();
        hitSound.dispose();
        backgroundMusic.dispose();
    }

    /**
     * Removes the slider background and slider button from the stage.
     */
    public void removeSliderAndButton() {
        sliderBackground.remove();
        sliderButton.remove();
    }

    /**
     * Removes the slider background2 and slider button2 from the stage.
     */
    public void removeSliderAndButton2() {
        sliderBackground2.remove();
        sliderButton2.remove();
    }

    /**
     * Shows the end screen with the appropriate elements.
     */
    public void showEndScreen() {
        // Clear the stage
        stage.clear();

        // Create end screen elements
        Image logoImage = new Image(new Texture("logo.png"));
        Image anotherImage = new Image(new Texture("picture.png"));

        // Add end screen elements to the stage
        stage.addActor(logoImage);
        stage.addActor(anotherImage);
    }

    /**
     * Renders the next batch item from the list.
     */
    private void renderNextBatchItem() {
        if (!batchItems.isEmpty()) {
            Image nextItem = batchItems.remove(0);
            stage.addActor(nextItem);
        }
    }
}
