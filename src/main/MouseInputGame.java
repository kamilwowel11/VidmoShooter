package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputGame extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    GameObject tempPlayer = null;


    MouseInputGame(Game game, Handler handler,HUD hud) {
        this.handler = handler;
        this.game = game;
        this.hud=hud;
    }

    public void findPlayer() {
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                tempPlayer = handler.object.get(i);
                break;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (Game.gameState == Game.STATE.Game) {
            int mx = e.getX();
            int my = e.getY();
            //System.out.println("mx: " + mx + " my: " + my + " tempPlayer: " + tempPlayer);
            if (tempPlayer != null) {
                    GameObject tempBullet = new PlayerBullet((int) tempPlayer.x + 16, (int) tempPlayer.y + 16, ID.PlayerBullet,100,handler,hud);
                    handler.addObject(tempBullet);

                    float angle = (float) Math.atan2(my - tempPlayer.y - 16, mx - tempPlayer.x - 16);


                    tempBullet.velX = (float) ((hud.bulletSpeed) * Math.cos(angle));
                    tempBullet.velY = (float) ((hud.bulletSpeed) * Math.sin(angle));

            } else {
                findPlayer();
            }
        }
    }
    public void mouseReleased(MouseEvent e){

    }



}
