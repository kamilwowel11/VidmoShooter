package main;

import java.awt.*;
import java.util.Random;

public class Spawner {
    private Handler handler;
    private HUD hud;
    private Game game;
    private boolean test = false;
    private int roundTime = 300;


    public int scoreKeep = 0;
    private Random r = new Random();

    public Spawner(Handler handler,HUD hud,Game game){
        this.handler=handler;
        this.hud=hud;
        this.game=game;
    }

    public void tick(){
        scoreKeep++;

        if (scoreKeep >=roundTime){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);


            if (test == true) {
                if (game.diff == 0) {
                    if (hud.getLevel() == 2) {
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                    }
                    if (hud.getLevel() == 3) {
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,50, handler));
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,50, handler));
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,50, handler));
                    }
                    if (hud.getLevel() == 4) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 5) {
                    }
                    if (hud.getLevel() == 6) {
                    }
                    if (hud.getLevel() == 7) {
                    }
                    if (hud.getLevel() == 8) {
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,50, handler));
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                    }
                    if (hud.getLevel() == 9) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 10) {
                        roundTime = 1000;
                        handler.clearEnemies();
                        handler.addObject(new BossEnemy(Game.WIDTH / 2 - 48, -100, ID.BossEnemy,300, handler));
                    }
                    if (hud.getLevel() == 11) {
                        roundTime = 250;
                        handler.clearEnemies();
                    }
                    if (hud.getLevel() == 12) {

                    }
                    if (hud.getLevel() == 13) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 14) {
                    }
                    if (hud.getLevel() == 15) {
                    }
                    if (hud.getLevel() == 16) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 17) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 18) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 19) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                    if (hud.getLevel() == 20) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,125, handler));
                    }
                } else if (game.diff==1) {
                    if (hud.getLevel() == 2) {
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                    }
                    if (hud.getLevel() == 3) {
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,100, handler));
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,100, handler));
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,100, handler));
                    }
                    if (hud.getLevel() == 4) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 5) {
                    }
                    if (hud.getLevel() == 6) {
                    }
                    if (hud.getLevel() == 7) {
                    }
                    if (hud.getLevel() == 8) {
                        handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.FastEnemy,100, handler));
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                    }
                    if (hud.getLevel() == 9) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 10) {
                        roundTime = 1000;
                        handler.clearEnemies();
                        handler.addObject(new BossEnemy(Game.WIDTH / 2 - 48, -100, ID.BossEnemy,100, handler));
                    }
                    if (hud.getLevel() == 11) {
                        roundTime = 250;
                        handler.clearEnemies();
                    }
                    if (hud.getLevel() == 12) {
                    }
                    if (hud.getLevel() == 13) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 14) {
                    }
                    if (hud.getLevel() == 15) {
                    }
                    if (hud.getLevel() == 16) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 17) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 18) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 19) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                    if (hud.getLevel() == 20) {
                        handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.SmartEnemy,100, handler));
                    }
                }
            }
            else
            {
             // do testowania jednego poziomu kodua
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 10), r.nextInt(Game.HEIGHT - 10), ID.BasicEnemy,100, handler));
                }
            }




        }

    }
    public int setScoreKeep(int scoreKeep) {
        return scoreKeep;
    }
    public void getScoreKeep(int scoreKeep) {
        this.scoreKeep=scoreKeep;
    }
    public void render(Graphics g) {
    }
}
