package main;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x,int y,ID id,int life,Handler handler){
        super(x,y,id,life);
        this.handler= handler;

        for(int i=0; i<handler.object.size();i++){
            if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() -8;
        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        velX = (float)((-1.0/distance)* diffX);
        velY = (float)((-1.0/distance)* diffY);

        handler.addObject(new Trail(x,y,ID.Trail,100,Color.YELLOW,16,16,0.02f,handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x,(int)y,16,16);

    }
}
