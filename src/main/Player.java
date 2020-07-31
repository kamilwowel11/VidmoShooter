package main;

import java.awt.*;

public class Player extends GameObject{

    Handler handler;

    public Player(int x, int y,ID id,Handler handler){
        super(x,y,id);
        this.handler = handler;

    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x,0, Game.WIDTH - 48);
        y = Game.clamp(y,0, Game.HEIGHT - 69);

        collision();
    }

    private void collision(){
        for (int i=0; i< handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.BasicEnemy || tempObject.getId()==ID.FastEnemy || tempObject.getId()==ID.SmartEnemy || tempObject.getId()==ID.BossEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collsion code
                    HUD.HEALTH -= 2;
                }
            }
        }


    }


    public void render(Graphics g) {

        //Bounds to test collisions later

        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);

    }
}
