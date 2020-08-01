package main;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

    private Handler handler;
    private Random r = new Random();

    public BossEnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //velX = (r.nextInt(10)-5);
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

        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 8, 8, 0.02f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 8, 8);

    }
}
