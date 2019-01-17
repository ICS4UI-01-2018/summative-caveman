package com.caveman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import java.util.ArrayList;

public class Caveman extends ApplicationAdapter {

    private SpriteBatch batch;
    private ShapeRenderer shapeBatch;
    // private Texture img;
    private Player player;
    private ArrayList<Enemy> enemy;
    private ArrayList<Wall> walls;
    private Rectangle healthBar;
    private Rectangle door;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private ArrayList<Enemy> enemies;
    private boolean pUpAllowed;
    private boolean pLeftAllowed;
    private boolean pRightAllowed;
    private boolean pDownAllowed;
    private int timer;
    public Slasher slasher;
    public Shooter shooter;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        walls = new ArrayList<Wall>();
        enemy = new ArrayList<Enemy>();
        //img = new Texture("badlogic.jpg");
        cam = new OrthographicCamera(800, 600);
        viewport = new FitViewport(800, 600, cam);
        viewport.apply();
        cam.position.x = 400;
        cam.position.y = 300;
        cam.update();
        pUpAllowed = true;
        pDownAllowed = true;
        pRightAllowed = true;
        pLeftAllowed = true;
        healthBar = new Rectangle(100, 25, 600, 25);
        walls.add(new Door(325, 550, 150, 25, 1));
        player = new Player(390, 290, 20, 20, 5, 4);
        //enemies
        enemies.add(new Enemy(300, 150, 1, 25, 1, 200, 20, 20));
        //first room
        walls.add(new Wall(25, 100, 25, 400, 0));
        walls.add(new Wall(750, 100, 25, 400, 0));
        walls.add(new Wall(25, 75, 750, 25, 0));
        walls.add(new Wall(25, 500, 325, 25, 0));
        walls.add(new Wall(450, 500, 325, 25, 0));
        //first hallway
        walls.add(new Wall(325, 525, 25, 200, 0));
        walls.add(new Wall(450, 525, 25, 200, 0));
        //second room
        walls.add(new Wall(-125, 700, 475, 25, 0));
        walls.add(new Wall(450, 700, 475, 25, 0));
        walls.add(new Wall(-125, 1325, 475, 25, 0));
        walls.add(new Wall(450, 1325, 475, 25, 0));
        walls.add(new Wall(-125, 725, 25, 250, 0));
        walls.add(new Wall(-125, 1075, 25, 250, 0));
        walls.add(new Wall(900, 725, 25, 250, 0));
        walls.add(new Wall(900, 1075, 25, 250, 0));
        //second hallway
        walls.add(new Wall(925, 950, 200, 25, 0));
        walls.add(new Wall(925, 1075, 200, 25, 0));
        //third room
        walls.add(new Wall(1125, 825, 25, 150, 0));
        walls.add(new Wall(1125, 1075, 25, 150, 0));
        walls.add(new Wall(1850, 825, 25, 400, 0));
        walls.add(new Wall(1125, 800, 325, 25, 0));
        walls.add(new Wall(1550, 800, 325, 25, 0));
        walls.add(new Wall(1125, 1225, 325, 25, 0));
        walls.add(new Wall(1550, 1225, 325, 25, 0));
        //third hallway
        walls.add(new Wall(1425, 600, 25, 200, 0));
        walls.add(new Wall(1550, 600, 25, 200, 0));
        //fourth hallway
        walls.add(new Wall(1425, 1250, 25, 200, 0));
        walls.add(new Wall(1550, 1250, 25, 200, 0));
        //fourth room
        walls.add(new Wall(1425, 200, 25, 400, 0));
        walls.add(new Wall(1425, 175, 750, 25, 0));
        walls.add(new Wall(1575, 600, 600, 25, 0));
        walls.add(new Wall(2150, 200, 25, 150, 0));
        walls.add(new Wall(2150, 450, 25, 150, 0));
        //fifth hallway
        walls.add(new Wall(2175, 325, 200, 25, 0));
        walls.add(new Wall(2175, 450, 200, 25, 0));
        //fifth room
        walls.add(new Wall(2375, 325, 400, 25, 0));
        walls.add(new Wall(2350, 475, 25, 600, 0));
        walls.add(new Wall(2775, 325, 25, 750, 0));
        walls.add(new Wall(2375, 1050, 150, 25, 0));
        walls.add(new Wall(2625, 1050, 150, 25, 0));
        //sixth room
        walls.add(new Wall(1425, 1450, 25, 400, 0));
        walls.add(new Wall(1425, 1850, 750, 25, 0));
        walls.add(new Wall(1575, 1425, 600, 25, 0));
        walls.add(new Wall(2150, 1450, 25, 150, 0));
        walls.add(new Wall(2150, 1700, 25, 150, 0));
        //sixth hallway
        walls.add(new Wall(2500, 1075, 25, 150, 0));
        walls.add(new Wall(2625, 1075, 25, 150, 0));
        //seventh room
        walls.add(new Wall(2375, 1200, 25, 350, 0));
        walls.add(new Wall(2750, 1200, 25, 350, 0));
        walls.add(new Wall(2400, 1525, 100, 25, 0));
        walls.add(new Wall(2650, 1525, 100, 25, 0));
        walls.add(new Wall(2400, 1200, 100, 25, 0));
        walls.add(new Wall(2650, 1200, 100, 25, 0));

        timer = 0;

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pUpAllowed = true;
        pDownAllowed = true;
        pRightAllowed = true;
        pLeftAllowed = true;
        for (int i = 0; i < enemies.size(); i++) {

            Enemy e = enemies.get(i);
            e.changeUpAllowed(true);
            e.changeRightAllowed(true);
            e.changeDownAllowed(true);
            e.changeLeftAllowed(true);
        }
        for (int i = 0; i < walls.size(); i++) {
            if (player.collidesWith(walls.get(i).getBounds()) && (player.getPlayerX() + 20) > (walls.get(i).getBounds().x + walls.get(i).getBounds().width)) {
                pLeftAllowed = false;
            } else if (player.collidesWith(walls.get(i).getBounds()) && (player.getPlayerX() < walls.get(i).getBounds().x)) {
                pRightAllowed = false;
            } else if (player.collidesWith(walls.get(i).getBounds()) && (player.getPlayerY() < walls.get(i).getBounds().y)) {
                pUpAllowed = false;
            } else if (player.collidesWith(walls.get(i).getBounds()) && (player.getPlayerY() + 20) > (walls.get(i).getBounds().y + walls.get(i).getBounds().height)) {
                pDownAllowed = false;
            }

            if (player.collidesWith(walls.get(i).getBounds()) && walls.get(i) instanceof Door) {
                Door d = (Door) walls.get(i);
                d.unlock();
            }
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            if (e.collidesWith(player.getBounds()) && (e.getEnemyX() + 20) > (player.getBounds().x + player.getBounds().width)) {
                e.changeLeftAllowed(false);
                pRightAllowed = false;
            }
            if (e.collidesWith(player.getBounds()) && (e.getEnemyX() < player.getBounds().x)) {
                e.changeRightAllowed(false);
                pLeftAllowed = false;
            }
            if (e.collidesWith(player.getBounds()) && (e.getEnemyY() < player.getBounds().y)) {
                e.changeUpAllowed(false);
                pDownAllowed = false;
            }
            if (e.collidesWith(player.getBounds()) && (e.getEnemyY() + 20) > (player.getBounds().y + player.getBounds().height)) {
                e.changeDownAllowed(false);
                pUpAllowed = false;
            }

            for (int j = 0; j < walls.size(); j++) {
                if (e.collidesWith(walls.get(j).getBounds()) && (e.getEnemyX() + 20) > (walls.get(j).getBounds().x + walls.get(j).getBounds().width)) {
                    e.changeLeftAllowed(false);
                }
                if (e.collidesWith(walls.get(j).getBounds()) && (e.getEnemyX() < walls.get(j).getBounds().x)) {
                    e.changeRightAllowed(false);
                }
                if (e.collidesWith(walls.get(j).getBounds()) && (e.getEnemyY() < walls.get(j).getBounds().y)) {
                    e.changeUpAllowed(false);
                }
                if (e.collidesWith(walls.get(j).getBounds()) && (e.getEnemyY() + 20) > (walls.get(j).getBounds().y + walls.get(j).getBounds().height)) {
                    e.changeDownAllowed(false);
                }
            }
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).trackPlayer(player);

            if (player.collidesWith(enemies.get(i).getBounds()) && healthBar.width > 0 && timer == 0) {
                healthBar.width = healthBar.width - enemies.get(i).getDamage();
                timer = 75;
            } else if (timer != 0) {
                timer = timer - 1;
            }

        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) && pUpAllowed) {
            player.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && pLeftAllowed) {
            player.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && pRightAllowed) {
            player.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && pDownAllowed) {
            player.moveDown();
        }
         
        shapeBatch.setColor(Color.CHARTREUSE);
           enemy.get(1).draw(shapeBatch);
           enemy.get(2).draw(shapeBatch);
        

        healthBar.setPosition(player.getPlayerX() - 290, player.getPlayerY() - 265);

        cam.position.x = player.getPlayerX() + (player.getBounds().width / 2);
        cam.position.y = player.getPlayerY() + (player.getBounds().height / 2);
        cam.update();
        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeType.Filled);

        for (int i = 0; i < enemies.size(); i++) {
            shapeBatch.setColor(Color.CYAN);
            enemies.get(i).draw(shapeBatch);
        }
        shapeBatch.setColor(Color.GOLD);
        player.draw(shapeBatch);
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).getColourNum() == 0) {
                shapeBatch.setColor(Color.GRAY);
            } else if (walls.get(i).getColourNum() == 1) {
                shapeBatch.setColor(Color.BROWN);
            }

            shapeBatch.rect(walls.get(i).getBounds().x, walls.get(i).getBounds().y, walls.get(i).getBounds().width, walls.get(i).getBounds().height);

        }

        shapeBatch.setColor(Color.GREEN);
        shapeBatch.rect(healthBar.x, healthBar.y, healthBar.width, healthBar.height);
        //enemies.get(1).draw(shapeBatch);

        shapeBatch.end();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        //img.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
