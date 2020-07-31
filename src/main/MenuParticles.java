package main;

import java.awt.*;
import java.util.Random;

public class MenuParticles extends GameObject {

    private Handler handler;
    private Color col;
    Random r = new Random();

    public MenuParticles(int x,int y,ID id,Handler handler){
        super(x,y,id);
        this.handler= handler;

        col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));


        velX = (r.nextInt(5- - 5)+ -5);
        velY = (r.nextInt(5- - 5)+ -5);
        if (velX == 0 || velY == 0){
            velX = (r.nextInt(4- - 4)+ -4);
            velY = (r.nextInt(4- - 4)+ -4);

        }



    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,8,8);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y<=0 || y>= Game.HEIGHT - 48) velY *= -1;
        if (x<=0 || x>= Game.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x,y,ID.Trail,col,8,8,0.05f,handler));
    }


    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x,(int)y,8,8);

    }
}
