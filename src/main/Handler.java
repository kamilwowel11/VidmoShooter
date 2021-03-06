package main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    GameObject tempBullet;

    public int speed = 5;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            //GameObject tempObject = object.get(i);
            //tempObject.tick();
            object.get(i).tick();
//            if (object.get(i) != null) {
//                tempBullet = object.get(i);
//                if (tempBullet.id == ID.PlayerBullet) {
//                    if (tempBullet.getY() < 0 || tempBullet.getY() > Game.HEIGHT || tempBullet.getX() < 0 || tempBullet.getX() > Game.WIDTH) {
//                        object.remove(tempBullet);
//                    }
//                }
//            }

        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            //GameObject tempObject = object.get(i);
            //tempObject.render(g);
            object.get(i).render(g);
        }

    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void clearEnemies() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() != ID.Player) {
                this.removeObject(tempObject);
                i--;
            }
        }
    }

}
