package main;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends GameObject {

    private Handler handler;
    private Random r = new Random();

    private int timer = 60;
    private int timer2 = 50;

    public BossEnemy(int x, int y, ID id,int life, Handler handler) {
        super(x, y, id,life);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if (velX == 0) velX = 2;

            if (velX > 0)
                velX += 0.005f;
            else if (velX < 0)
                velX -= 0.005f;

            int spawn = r.nextInt(10);
            if (spawn == 0)
                handler.addObject(new BossEnemyBullet((int) x + 32, (int) y + 32, ID.BasicEnemy,100, handler));
        }
        if (x <= 0 || x >= Game.WIDTH - 82) velX *= -1;
    }


    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, 64, 64);
    }
}
