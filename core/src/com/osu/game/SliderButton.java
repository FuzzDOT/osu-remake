package com.osu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * represents a sliderButton. handles all the interaction
 * @author FuzzDOT
 * @version FINAL on June 6, 2023
 */
public class SliderButton extends Actor {
    /** slider texture*/
    private TextureRegionDrawable backgroundDrawable;

    /** button texture */
    private TextureRegionDrawable buttonDrawable;

    /** width of the slider */
    private float sliderWidth;

    /** height of the slider */
    private float sliderHeight;

    /** minimum slider x that the button can go*/
    private float minSliderX;

    /** maximum slider x that the button can go */
    private float maxSliderX;

    /** offset of the button on the x-axis */
    private float buttonOffsetX;

    /** is the button being dragged right now */
    private boolean isDragging;

    /** the last x of the button */
    private float lastX;

    /** has the slider been completed */
    private boolean sliderCompleted;

    /** instance of the slider background for use */
    private SliderBackground sliderBackground;

    /** instance of the game screen for use */
    private MainGameScreen gameScreen;

    /**
     * initializes all the fields and creates a slider button
     * @param x x coords of the button
     * @param y y coords of the button
     * @param width of the button
     * @param height of the button
     * @param backgroundPath slider image
     * @param buttonPath button image
     * @param sliderBackground sliderBackground instance
     * @param gameScreen instance input for use
     */
    public SliderButton(float x, float y, float width, float height, String backgroundPath, String buttonPath, final SliderBackground sliderBackground, final MainGameScreen gameScreen) {
        backgroundDrawable = new TextureRegionDrawable(new Texture(backgroundPath));
        buttonDrawable = new TextureRegionDrawable(new Texture(buttonPath));
        this.gameScreen = gameScreen;

        sliderWidth = width;
        sliderHeight = height;
        buttonOffsetX = 0;
        isDragging = false;
        sliderCompleted = false;
        this.sliderBackground = sliderBackground;

        minSliderX = x;
        maxSliderX = x + sliderWidth - buttonDrawable.getMinWidth();

        setBounds(x, y, sliderWidth, sliderHeight);
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lastX = x;
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (isDragging) {
                    float deltaX = x - lastX;
                    float newButtonOffsetX = buttonOffsetX + deltaX;
                    float clampedButtonOffsetX = MathUtils.clamp(newButtonOffsetX, 0, sliderWidth - buttonDrawable.getMinWidth());
                    float deltaSliderX = clampedButtonOffsetX - buttonOffsetX;
                    buttonOffsetX = clampedButtonOffsetX;
                    lastX = x;

                    // Update the position of the slider background
                    sliderBackground.setSliderPosition(getSliderPosition());
                    setX(getX() + deltaSliderX);

                    // Check if the button has reached the right end
                    float buttonRightX = getX() + buttonOffsetX + buttonDrawable.getMinWidth();
                    float sliderRightX = sliderBackground.getX() + sliderBackground.getWidth();
                    if (buttonRightX >= sliderRightX) {
                        // Disable dragging when reaching the right end
                        isDragging = false;
                        gameScreen.removeSliderAndButton();
                    }
                } else if (isInsideButton(x) && x >= buttonOffsetX + buttonDrawable.getMinWidth()) {
                    isDragging = true;
                    lastX = x;
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (isSliderComplete()) {
                    sliderCompleted = true;
                    remove();
                    sliderBackground.remove();
                }
            }



        });
    }

    /**
     * checks if the slider has reached the right side
     * @return true or false
     */
    public boolean isSliderComplete() {
        float buttonX = getX() + buttonOffsetX;
        float buttonRightX = buttonX + buttonDrawable.getMinWidth();
        float sliderRightX = sliderBackground.getX() + sliderBackground.getWidth();
        return buttonRightX >= sliderRightX;
    }

    /**
     * is the button inside the slider
     * @param x coords
     * @return true or false
     */
    private boolean isInsideButton(float x) {
        float buttonX = getX() + buttonOffsetX;
        return x >= buttonX && x <= buttonX + buttonDrawable.getMinWidth();
    }

    /**
     * current position of the slider
     * @return returns the current position of the slider
     */
    public float getSliderPosition() {
        return (buttonOffsetX + buttonDrawable.getMinWidth() / 2) / (sliderWidth - buttonDrawable.getMinWidth());
    }

    /**
     * draws the slider
     * @param batch the batch on which the slider will be drawn on
     * @param parentAlpha The parent alpha, to be multiplied with this actor's alpha, allowing the parent's alpha to affect all
     *           children.
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor());
        backgroundDrawable.draw(batch, getX(), getY(), getWidth(), getHeight());
        buttonDrawable.draw(batch, getX() + buttonOffsetX, getY(), buttonDrawable.getMinWidth(), buttonDrawable.getMinHeight());
    }

    /**
     * Updates the actor based on time. Typically this is called each frame by Stage.act(float).
     * @param delta Time in seconds since the last frame.
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        if (isDragging) {
            toFront();
        }
    }
}
