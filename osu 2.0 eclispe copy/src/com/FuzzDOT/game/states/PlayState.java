package com.FuzzDOT.game.states;
import com.FuzzDOT.game.graphics.Font;
import com.FuzzDOT.game.graphics.Sprite;
import com.FuzzDOT.game.util.KeyHandler;
import com.FuzzDOT.game.util.MouseHandler;
import com.FuzzDOT.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameStates{

    private Font font;

    public PlayState(GameStateManager gsm ){
        super(gsm);
        font = new Font("font/aller-font-character-map.png",16,16);
    }

    public void update(){

    }

    public void input(MouseHandler mouse, KeyHandler key){

    }

    public void render(Graphics2D g){
        Sprite.drawArray(g,font,"YOUR MOM", new Vector2f(100,100),64,64,32,0);
    }
}
