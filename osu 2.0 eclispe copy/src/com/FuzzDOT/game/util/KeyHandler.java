package com.FuzzDOT.game.util;
import com.FuzzDOT.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener{

    public static List<Key> keys = new ArrayList<Key>();

    public class Key{
        public int pressCount;
        public int absorbCount;
        public boolean down;
        public boolean clicked;

        public Key(){
            keys.add(this);
        }

        public void toggle(boolean pressed){
            if(pressed != down){
                down = pressed;
            }
            if(pressed == true){
                pressCount++;
            }
        }

        public void tick(){
            if(absorbCount < pressCount){
                absorbCount++;
                clicked = true;
            }
            else{
                clicked = false;
            }
        }
    }

    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();

    public KeyHandler(GamePanel game){
        game.addKeyListener(this);
    }

    public void releaseAll(){
        for(int i = 0; i<keys.size(); i++){
            keys.get(i).down = false;
        }
    }

    public void tick() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public void toggle(KeyEvent e, boolean pressed){
        if(e.getKeyCode() == KeyEvent.VK_E)
            menu.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            enter.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            escape.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
