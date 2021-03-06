package main;

import java.awt.*;

public class PlayerBullet extends GameObject {

    Handler handler;
    HUD hud;


    PlayerBullet(int x ,int y, ID id,int life, Handler handler,HUD hud){
        super(x,y,id,life);
        this.handler=handler;
        this.hud = hud;
    }
    public void tick(){
       x += velX;
       y += velY;

       collision();


    }
    public void render(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,8,8);

    }
    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y, 8, 8);
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.setLife(tempObject.getLife() - hud.power);
                    if (tempObject.getLife() <= 0 ){
                        handler.removeObject(tempObject);
                        hud.setScore(hud.getScore() + 50);
                        i--;
                    }
                    handler.object.remove(this);
                }
            } else if (tempObject.getId() == ID.BossEnemy){
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.setLife(tempObject.getLife() - hud.power);
                    if (tempObject.getLife() <= 0 ){
                        handler.removeObject(tempObject);
                        hud.setScore(hud.getScore() + 500);
                        i--;
                    }
                    handler.object.remove(this);
                }
            }
        }
    }
}
