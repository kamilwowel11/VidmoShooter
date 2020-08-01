package main;

import java.awt.*;

public class HUD {

    public static float HEALTH= 100;
    private int greenValue =255;

    private int level = 1;
    public int score = 0;

    public void tick(){
         HEALTH = Game.clamp(HEALTH,0,100);

         score++;
    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
        g.fillRect(15,15,(int)HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect( 15,15,200,32);

        g.drawString("Score: "+ score,15,64);
        g.drawString("Level: "+ level,15,78);
        g.drawString("Space of Shop: ",15,92);
    }

    public void score(int score){
        this.score= score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
