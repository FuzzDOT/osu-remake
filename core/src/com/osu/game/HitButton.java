package com.osu.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * creates a new hitButton
 * @author Faaz Mohamed
 * @version FINAL on June 6, 2023
 */
public class HitButton extends Actor {
    /** texture of the button*/
    private TextureRegionDrawable buttonDrawable;

    /** is the button pressed*/
    private boolean isPressed;

    /**
     * creates a new hitButton and initializes the fields
     * @param x of the button
     * @param y of the button
     * @param width of the button
     * @param height of the button
     * @param buttonPath texture path of the button
     */
    public HitButton(float x, float y, float width, float height, String buttonPath) {
        buttonDrawable = new TextureRegionDrawable(new Texture(buttonPath));

        setBounds(x, y, width, height);
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isPressed = false;
            }
        });
    }

    /**
     * Draws the actor. The batch is configured to draw in the parent's coordinate system.
     * @param batch the batch on which it should be drawn
     * @param parentAlpha The parent alpha, to be multiplied with this actor's alpha, allowing the parent's alpha to affect all
     *           children.
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor());
        buttonDrawable.draw(batch, getX(), getY(), getWidth(), getHeight());
    }
}
