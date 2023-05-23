package com.FuzzDOT.game;
import com.FuzzDOT.game.states.GameStateManager;
import com.FuzzDOT.game.util.KeyHandler;
import com.FuzzDOT.game.util.MouseHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{
    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;

    private BufferedImage img;
    private Graphics2D g;

    private MouseHandler mouse;
    private KeyHandler key;

    private GameStateManager gsm;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();

        if(thread==null){
            thread = new Thread(this,"GameThread");
            thread.start();
        }
    }

    public void init(){
        running = true;
        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();

        mouse = new MouseHandler(this);
        key = new KeyHandler(this);

        gsm = new GameStateManager();
    }

    @Override
    public void run() {
        init();

        final double GAME_HZ = 60.0;
        final double TBU = 1000000000 / GAME_HZ; //time before update

        final int MUBR = 5; //most updates before render

        double lastUpdate = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double TTBR = 1000000000 / TARGET_FPS; //total time before render

        int frameCount = 0;
        int lastSecond = (int) (lastUpdate / 1000000000);
        int oldFrameCT = 0;


        while(running == true){
            double now = System.nanoTime();
            int updateCount = 0;
            while(((now-lastUpdate) > TBU) && (updateCount < MUBR)){
                update();
                input(mouse, key);
                lastUpdate += TBU;
                updateCount++;
            }

            if(now-lastUpdate > TBU){
                lastUpdate = now- TBU;
            }
            input(mouse, key);
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdate / 1000000000);
            if(thisSecond>lastSecond){
                if(frameCount != oldFrameCT){
                    System.out.println("New Second" + thisSecond + " " + frameCount);
                    oldFrameCT = frameCount;
                }
                frameCount = 0;
                lastSecond = thisSecond;
            }

            while(now-lastRenderTime < TTBR && now - lastUpdate < TBU){
                Thread.yield();;

                try{
                    Thread.sleep(1);
                }
                catch (Exception e){
                    System.out.println("ERROR: Yielding Thread");
                }
                now = System.nanoTime();
            }
        }
    }

    public void update(){
        gsm.update();
    }

    public void input(MouseHandler mouse, KeyHandler key){
        gsm.input(mouse, key);
    }

    public void render(){
        if(g != null){
            g.setColor(new Color(220,152,164));
            g.fillRect(0,0,width,height);
            gsm.render(g);
        }
    }

    public void draw(){
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0,0,width,height,null);
        g2.dispose();
    }
}
