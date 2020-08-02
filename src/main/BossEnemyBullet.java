package main;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

    private Handler handler;

    public BossEnemyBullet(int x, int y, ID id,int life, Handler handler) {
        super(x, y, id,life);
        this.handler = handler;
        //velX = (r.nextInt(10)-5);
        Random r = new Random();
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 8, 8);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, ID.Trail,100, Color.red, 8, 8, 0.02f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 8, 8);

    }
}
