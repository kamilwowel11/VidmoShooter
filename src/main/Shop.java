package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
    Handler handler;
    HUD hud;
    public int B1 = 10;
    public int B2 = 10;
    public int B3 = 10;
    public int B4 = 10;
    public int B5 = 10;
    public int B6 = 10;
    Font fnt1 = new Font("arial", 0, 48);
    Font fnt2 = new Font("arial", 0, 12);

    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(fnt1);
        g.drawString("SHOP", Game.WIDTH / 2 - 85, 50);

        g.setFont(fnt2);
        g.drawString("SCORE: " + hud.getScore(), Game.WIDTH / 2 - 50, 340);
        g.drawString("Press space to go back", Game.WIDTH / 2 - 80, 370);

        //Box 1 Upgrade Health
        g.drawString("Upgrade Health", 110, 120);
        g.drawString("Cost: " + B1, 110, 140);
        g.drawRect(100, 100, 100, 80);

        //Box 2 Upgrade Speed
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost: " + B2, 260, 140);
        g.drawRect(250, 100, 100, 80);

        //Box 3 Refill Health bar
        g.drawString("Refill Health", 410, 120);
        g.drawString("Cost: " + B3, 410, 140);
        g.drawRect(400, 100, 100, 80);

        Graphics2D g2d = (Graphics2D) g;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        //Box 4 Upgrade Attack-Speed
        g2d.setFont(fnt2);
        g2d.drawString("Upgrade Attack", 110, 250);
        g2d.drawString("Speed", 110, 270);
        g2d.drawString("Cost: " + B4, 110, 290);
        g2d.drawRect(100, 230, 100, 80);

        //Box 5 Upgrade Amount of bullets
        g2d.drawString("Upgrade", 260, 250);
        g2d.drawString("Amount", 260, 270);
        g2d.drawString("Cost: " + B5, 260, 290);
        g2d.drawRect(250, 230, 100, 80);

        //Box 6 Upgrade Power of bullets
        g2d.drawString("Upgrade Power", 410, 250);
        g2d.drawString("Cost: " + B6, 410, 270);
        g2d.drawRect(400, 230, 100, 80);

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Shop) {
            int mx = e.getX();
            int my = e.getY();

            //Box 1 Upgrade Health
            if (mouseOver(mx, my, 100, 100, 100, 80)) {
                if (hud.getScore() >= B1){
                    hud.setScore(hud.getScore()-B1);
                    B1+=10;
                    hud.bounds +=20;
                    hud.HEALTH = (100+ (hud.bounds/2));
                }
            }
            //Box 2 Upgrade Speed
            if (mouseOver(mx, my, 250, 100, 100, 80)) {
                if (hud.getScore() >= B2){
                    hud.setScore(hud.getScore()-B2);
                    B2+=10;
                    handler.speed++;
                }
            }
            //Box 3 Refill Health bar
            if (mouseOver(mx, my, 400, 100, 100, 80)) {
                if (hud.getScore() >= B3){
                    hud.setScore(hud.getScore()-B3);
                    hud.HEALTH = (100+ (hud.bounds/2));
                }
            }
            //Box 4 Upgrade Bullet-Speed
            if (mouseOver(mx, my, 100, 230, 100, 80)) {
                if (hud.getScore() >= B4){
                    hud.setScore(hud.getScore()-B4);
                    hud.setBulletSpeed(hud.getBulletSpeed() + 1);
                    B4+=10;
                }
            }
            //Box 5 Upgrade Amount of bullets
            if (mouseOver(mx, my, 250, 230, 100, 80)) {
                if (hud.getScore() >= B5){
                    hud.setScore(hud.getScore()-B5);
                    B5+=10;
                }
            }
            //Box 6 Upgrade Power of bullets
            if (mouseOver(mx, my, 400, 230, 100, 80)) {
                if (hud.getScore() >= B6){
                    hud.setScore(hud.getScore()-B6);
                    hud.setPower(hud.getPower() + 5);
                    B6+=10;
                }
            }
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    public void resetShop(){
        B1 = 10;
        B2 = 10;
        B3 = 10;
        B4 = 10;
        B5 = 10;
        B6 = 10;
        handler.speed = 5;
        hud.HEALTH = 100;
        hud.bounds = 0;
    }
}
