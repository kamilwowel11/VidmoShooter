package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
    Handler handler;
    HUD hud;
    private int B1 = 1000;
    private int B2 = 1000;
    private int B3 = 1000;
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

        //Box 3 Upgrade Fill Health bar
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
        g2d.drawString("Cost: " + B1, 110, 290);
        g2d.drawRect(100, 230, 100, 80);

        //Box 5 Upgrade Amount of bullets
        g2d.drawString("Upgrade", 260, 250);
        g2d.drawString("Amount", 260, 270);
        g2d.drawString("Cost: " + B2, 260, 290);
        g2d.drawRect(250, 230, 100, 80);

        //Box 6 Upgrade Power of bullets
        g2d.drawString("Upgrade Power", 410, 250);
        g2d.drawString("Cost: " + B3, 410, 270);
        g2d.drawRect(400, 230, 100, 80);

    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Shop) {
            int mx = e.getX();
            int my = e.getY();

            //Box 1 Upgrade Health
            if (mouseOver(mx, my, 100, 100, 100, 80)) {
                System.out.println("Box1");
            }
            //Box 2 Upgrade Speed
            if (mouseOver(mx, my, 250, 100, 100, 80)) {
                System.out.println("Box2");
            }
            //Box 3 Upgrade Fill Health bar
            if (mouseOver(mx, my, 400, 100, 100, 80)) {
                System.out.println("Box3");
            }
            //Box 4 Upgrade Attack-Speed
            if (mouseOver(mx, my, 100, 230, 100, 80)) {
                System.out.println("Box4");
            }
            //Box 5 Upgrade Amount of bullets
            if (mouseOver(mx, my, 250, 230, 100, 80)) {
                System.out.println("Box5");
            }
            //Box 6 Upgrade Power of bullets
            if (mouseOver(mx, my, 400, 230, 100, 80)) {
                System.out.println("Box6");
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
}
