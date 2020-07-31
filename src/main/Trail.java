package main;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.security.AlgorithmParameterGenerator;

public class Trail extends GameObject{

    private float alpha =1;
    private float life;

    private Handler handler;
    private Color color;

    private int width,height;



    public Trail(float x, float y, ID id,Color color,int width,int height,float life,Handler handler){
        super(x,y,id);
        this.handler = handler;
        this.color= color;
        this.width=width;
        this.height=height;
        this.life=life;
    }


    public void tick() {
        if (alpha> life){
            alpha -=(life-0.001f) ;
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
