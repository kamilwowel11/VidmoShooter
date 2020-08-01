package main;

import java.awt.*;

public class PlayerBullet extends GameObject {

    PlayerBullet(int x ,int y, ID id){
        super(x,y,id);
    }
    public void tick(){
       x += velX;
       y += velY;
    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,8,8);

    }
    public Rectangle getBounds(){
        return null;
    }

}
