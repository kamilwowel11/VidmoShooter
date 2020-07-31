package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    public Random r = new Random();
    private HUD hud;
    private Spawner spawn;

    public Menu(Game game,Handler handler,HUD hud, Spawner spawn){
        this.game=game;
        this.handler= handler;
        this.hud=hud;
        this.spawn=spawn;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        //System.out.println("mx: " + mx + " my: " + my);

        if (game.gameState == Game.STATE.Menu) {
            //Play Button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Select;
                return;
            }
            //Help Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
            }
            //Quit Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        if (game.gameState == Game.STATE.Select) {
            //Normal button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(game.WIDTH / 2 - 32, game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH) - 50, r.nextInt(game.HEIGHT) - 50, ID.BasicEnemy, handler));
                game.diff=0;
            }
            //Hard Button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(game.WIDTH / 2 - 32, game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new HardEnemy(r.nextInt(game.WIDTH) - 50, r.nextInt(game.HEIGHT) - 50, ID.BasicEnemy, handler));
                game.diff=1;
            }
            //Back Button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                if (mouseOver(mx,my,210, 350, 200, 64)){
                    game.gameState = Game.STATE.Menu;
                    return;
                }
            }
        }

        //Back Button
        if (game.gameState == Game.STATE.Help){
            if (mouseOver(mx,my,210, 350, 200, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }
        //Try again button and menu button
        if (game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Select;
                hud.setLevel(1);
                hud.setScore(0);
                spawn.setScoreKeep(0);
                return;
            }
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);
                spawn.setScoreKeep(0);
                return;
            }
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

    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setColor(Color.CYAN);
            g.setFont(fnt);
            g.drawString("Vidmo shooter", 135, 70);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);

            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 275, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 275, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 275, 390);
        } else if (game.gameState == Game.STATE.Help) {
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

        } else if (game.gameState == Game.STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 15);

            g.setColor(Color.RED);
            g.setFont(fnt);
            g.drawString("Game Over", 185, 70);

            g.setColor(Color.WHITE);
            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(), 195, 200);


            g.setFont(fnt2);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Menu ", 245, 290);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try again! ", 245, 390);
        } else if (game.gameState == Game.STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setColor(Color.RED);
            g.setFont(fnt);
            g.drawString("Select difficulty", 135, 70);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);

            g.drawRect(210, 150, 200, 64);
            g.drawString("Normal", 260, 195);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Hard", 260, 295);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 260, 395);

        }
    }
    public void tick(){

    }
}
