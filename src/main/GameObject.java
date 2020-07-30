package main;

import java.awt.*;

public abstract class GameObject {

    protected float x,y;
    protected ID id;
    protected float velX, velY; //velocity

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setVelX(float velX) {
        this.velX = velX;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public ID getId(){
        return id;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}
