package com.FuzzDOT.game.states;

import com.FuzzDOT.game.util.KeyHandler;
import com.FuzzDOT.game.util.MouseHandler;

import java.awt.*;

public abstract class GameStates {
    private GameStateManager gsm;

    public GameStates(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render (Graphics2D g);
}
