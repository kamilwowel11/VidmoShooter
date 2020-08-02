package main;

import java.awt.*;

public class Trail extends GameObject{

    private float alpha =1;
    private float lifeTime;

    private Handler handler;
    private Color color;

    private int width,height;



    public Trail(float x, float y, ID id,int life,Color color,int width,int height,float lifeTime,Handler handler){
        super(x,y,id,life);
        this.handler = handler;
        this.color= color;
        this.width=width;
        this.height=height;
        this.lifeTime =lifeTime;
    }


    public void tick() {
        if (alpha> lifeTime){
            alpha -=(lifeTime -0.001f) ;
        }
        else
            handler.removeObject(this);

    }


    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTrasparent(alpha));

        //GradientPaint pinkToWhite = new GradientPaint(16, 16, Color.PINK,
        //        16, 16, Color.WHITE);
        //g2d.setPaint(pinkToWhite);
        //g2d.fill(new Rectangle2D.Double((int)x,(int)y,width,height));


        g2d.setColor(color);
        g2d.fillRect((int)x,(int)y,width,height);



        g2d.setComposite(makeTrasparent(1));

    }

    private AlphaComposite makeTrasparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
    }


    public Rectangle getBounds() {
        return null;
    }
}
