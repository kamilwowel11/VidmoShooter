package main;

import java.util.Random;

public class Spawner {
    private Handler handler;
    private HUD hud;

    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawner(Handler handler,HUD hud){
        this.handler=handler;
        this.hud=hud;
    }

    public void tick(){
        scoreKeep++;

        if (scoreKeep >=100){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);

            if(hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
            }
            if(hud.getLevel() == 3){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy,handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy,handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy,handler));
            }if(hud.getLevel() == 4){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
            }
        }

    }
}
