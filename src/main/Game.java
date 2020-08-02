package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;
    public int diff = 0;

    // 0 = normal
    // 1 = hard


    private Handler handler;
    private HUD hud;
    private Random r;
    private Spawner spawn;
    private Menu menu;
    private Shop shop;
    private MouseInputGame mouseInputGame;


    public enum STATE {
        Menu,
        Game,
        Help,
        End,
        Select,
        Shop
    }

    ;

    public static STATE gameState = STATE.Menu;

    public Game() {

        handler = new Handler();
        hud = new HUD();
        shop = new Shop(handler, hud);
        spawn = new Spawner(handler, hud, this);
        menu = new Menu(this, handler, hud, spawn,shop);
        mouseInputGame = new MouseInputGame(this,handler);

        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        this.addMouseListener(mouseInputGame);

        new Window(WIDTH, HEIGHT, "Vidmo Shooter", this);

        r = new Random();


        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player,0, handler));
            mouseInputGame.findPlayer();
            handler.clearEnemies();
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH) - 50, r.nextInt(HEIGHT) - 50, ID.BasicEnemy,100, handler));
        } else if (gameState == STATE.Menu) {
            for (int i = 0; i < 10; i++) {
                handler.addObject(new MenuParticles(r.nextInt(WIDTH) - 50, r.nextInt(HEIGHT) - 50, ID.MenuParticles,0, handler));
            }

        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {

        if (gameState == STATE.Game) {
            if (!paused) {
                hud.tick();
                spawn.tick();
                handler.tick();
                if (HUD.HEALTH <= 0) {
                    HUD.HEALTH = 100;
                    gameState = STATE.End;
                    handler.object.clear();

                }
            }

        } else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            menu.tick();
            handler.tick();
        }


    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);


        if (paused) {
            Font fnt = new Font("arial", Font.BOLD, 50);
            g.setFont(fnt);
            g.drawString("PAUSED", 25, 25);
        }
        if (gameState == STATE.Game) {
            hud.render(g);
            handler.render(g);
        } else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            menu.render(g);
            handler.render(g);
        } else if (gameState == STATE.Shop) {
            shop.render(g);
        }


        g.dispose();
        bs.show();

    }

    @Override
    public void run() {
        //Game Loop in game -> popular one
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    public static float clamp(float var, float min, float max) {
        if (var >= max)
            return max;
        else if (var <= min)
            return min;
        else
            return var;
    }

    public static void main(String args[]) {
        new Game();
    }
}
