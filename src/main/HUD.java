package main;

import java.awt.*;

public class HUD {

    public static float HEALTH = 100;
    public int bounds = 0;
    public int power = 10;
    public int bulletSpeed = 10;
    Font fnt = new Font("arial", 1, 10);

    private int level = 1;
    public int score = 0;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100+bounds);

        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200+bounds, 32);
        if (HEALTH < 200){
            g.setColor(Color.getHSBColor((1f * HEALTH) / 360, 1f, 1f));
        }else{
            g.setColor(Color.getHSBColor((1f * HEALTH) / 720, 1f, 1f));
        }

        g.fillRect(15, 15, (int) HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200+bounds, 32);

        g.setFont(fnt);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 78);
        g.drawString("Space for Shop", 15, 92);
    }

    public void score(int score) {
        this.score = score;
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

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }
}
