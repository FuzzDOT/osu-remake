package com.osu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * represents the slider, not the button
 * @author Faaz Mohamed
 * @version FINAL on June 6, 2023
 */
public class SliderBackground extends Actor {
    /** texture of the slider*/
    private TextureRegionDrawable backgroundDrawable;

    /** position of the slider*/
    private float sliderPosition;

    /** minimum x position of the slider*/
    private float minSliderX;

    /** max x position of the slider*/
    private float maxSliderX;

    /**
     * creates a new slider background
     * @param x position
     * @param y position
     * @param width of the texture
     * @param height of the texture
     * @param backgroundPath file path of the texture
     */
    public SliderBackground(float x, float y, float width, float height, String backgroundPath) {
        backgroundDrawable = new TextureRegionDrawable(new Texture(backgroundPath));
        setBounds(x, y, width, height);
        minSliderX = x;
        maxSliderX = x + width;
    }

    /**
     * set the position of the slider background
     * @param sliderPosition position of the slider to be set to
     */
    public void setSliderPosition(float sliderPosition) {
        this.sliderPosition = sliderPosition;
        float newX = MathUtils.lerp(minSliderX, maxSliderX, sliderPosition);
        setX(newX);
    }

    /**
     * draws the slider
     * @param batch to draw the slider to
     * @param parentAlpha The parent alpha, to be multiplied with this actor's alpha, allowing the parent's alpha to affect all
     *           children.
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor());
        backgroundDrawable.draw(batch, getX(), getY(), getWidth() * sliderPosition, getHeight());
    }
}
