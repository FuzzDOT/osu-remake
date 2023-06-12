package com.osu.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates the level to be played
 * @author Faaz Mohamed
 * @version FINAL on April 8, 2023
 */
public class Beatmap extends Actor {
    /**
     * represents all the sliderButtons in the level
     */
    private List<SliderButton> sliderButtons;

    /**
     * represents all the HitButtons in the level
     */
    private List<HitButton> hitButtons;

    /**
     * initializes the above 2 fields
     */
    public Beatmap() {
        sliderButtons = new ArrayList<>();
        hitButtons = new ArrayList<>();
    }

    /**
     * adds a sliderButton object to the appropriate ArrayList
     * @param sliderButton represents the sliderButton object to be added
     */
    public void addSliderButton(SliderButton sliderButton) {
        sliderButtons.add(sliderButton);
    }

    /**
     * adds a HitButton object to the appropriate ArrayList
     * @param hitButton represents the HitButton object to be added
     */
    public void addHitButton(HitButton hitButton) {
        hitButtons.add(hitButton);
    }

    /**
     * draws the sliderButtons and the HitButtons when called
     * @param batch represents the batch of the game to be drawn to
     * @param parentAlpha The parent alpha, to be multiplied with this actor's alpha, allowing the parent's alpha to affect all
     *           children.
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (SliderButton sliderButton : sliderButtons) {
            sliderButton.draw(batch, parentAlpha);
        }

        for (HitButton hitButton : hitButtons) {
            hitButton.draw(batch, parentAlpha);
        }
    }
}
