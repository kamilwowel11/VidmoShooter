package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    public Random r = new Random();

    public Menu(Game game,Handler handler){
        this.game=game;
        this.handler= handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        //System.out.println("mx: " + mx + " my: " + my);

        //Play Button
        if (mouseOver(mx,my,210,150,200,64)){
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(game.WIDTH/2-32,game.HEIGHT/2-32,ID.Player,handler));
            handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH)-50,r.nextInt(game.HEIGHT)-50,ID.BasicEnemy,handler));
        }
        //Help Button
        if (mouseOver(mx,my,210, 250, 200, 64)){
           game.gameState = Game.STATE.Help;
        }
        //Back Button
        if (game.gameState == Game.STATE.Help){
            if (mouseOver(mx,my,210, 350, 200, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //Quit Button
        if (mouseOver(mx,my,210,350,200,64)){
           System.exit(1);
        }

    }
    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my,int x, int y, int width, int height){
        if (mx > x && mx < x +width){
            if (my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }

    public void render(Graphics g){
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setColor(Color.CYAN);
            g.setFont(fnt);
            g.drawString("Menu", 250, 70);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);

            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 275, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 275, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 275, 390);
        } else if (game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 15);

            g.setColor(Color.CYAN);
            g.setFont(fnt);
            g.drawString("Help", 250, 70);

            g.setColor(Color.WHITE);
            g.setFont(fnt3);
            g.drawString("Use WASD keys to move player and dodge enemies", 125, 200);


            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 275, 390);

        }

    }
    public void tick(){

    }
}
