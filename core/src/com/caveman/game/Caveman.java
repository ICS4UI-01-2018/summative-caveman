package com.caveman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import java.util.ArrayList;

public class Caveman extends ApplicationAdapter {

    private SpriteBatch batch;
    private ShapeRenderer shapeBatch;
    private Texture eImg;
    private Texture pImg0;
    private Texture pImg90;
    private Texture pImg270;
    private Texture pImg180;
    private Texture sImg0;
    private Texture sImg90;
    private Texture sImg270;
    private Texture sImg180;
    private boolean dLeft;
    private boolean dRight;
    private boolean dUp;
    private boolean dDown;
    private Player player;
    private Sword sword;
    private ArrayList<Wall> walls;
    private ArrayList<Items> items;
    private Rectangle healthBar;
    private Rectangle door;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private ArrayList<Enemy> enemies;
    private boolean pUpAllowed;
    private boolean pLeftAllowed;
    private boolean pRightAllowed;
    private boolean pDownAllowed;
    private float mouseX;
    private float mouseY;
    private float rotate;
    private int keyCount;
    private int swordTimer;
    private int pTimer;
    private int eTimer;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private BitmapFont font;

    @Override
    public void create() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("RunyTunesRevisitedNF.ttf"));
        parameter = new FreeTypeFontParameter();
        parameter.size = 10;
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font = generator.generateFont(parameter);
        generator.dispose();
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        keyCount = 0;
        walls = new ArrayList<Wall>();
        items = new ArrayList<Items>();
        enemies = new ArrayList<Enemy>();
        dLeft = false;

        dRight = false;
        dUp = false;
        dDown = false;
        eTimer = 0;
        eImg = new Texture("slime.png");
        pImg0 = new Texture("guy0.png");
        pImg90 = new Texture("guy90.png");
        pImg180 = new Texture("guy180.png");
        pImg270 = new Texture("guy270.png");
        sImg0 = new Texture("sword0.png");
        sImg90 = new Texture("sword90.png");
        sImg180 = new Texture("sword180.png");
        sImg270 = new Texture("sword270.png");
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

        player = new Player(390, 290, 40, 40, 5, 4);
        sword = new Sword(0, " ", player.getPlayerX() - 15, player.getPlayerY(), 15, 50, 10);
        //enemies
        enemies.add(new Enemy(300, 150, 3, 25, 1, 200, 40, 40));
        //items
        items.add(new Key(1, "hi", 430, 320, 20, 20));
        items.add(new Shield(1, "hi", 230, 320, 20, 20, 15));
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
        walls.add(new Wall(2500, 1075, 25, 200, 0));
        walls.add(new Wall(2625, 1075, 25, 200, 0));
        //seventh room
        walls.add(new Wall(2375, 1250, 25, 350, 0));
        walls.add(new Wall(2750, 1250, 25, 350, 0));
        walls.add(new Wall(2400, 1575, 100, 25, 0));
        walls.add(new Wall(2650, 1575, 100, 25, 0));
        walls.add(new Wall(2400, 1250, 100, 25, 0));
        walls.add(new Wall(2650, 1250, 100, 25, 0));
        //seventh hallway
        walls.add(new Wall(2175, 1575, 200, 25, 0));
        walls.add(new Wall(2175, 1700, 200, 25, 0));

        pTimer = 0;

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

            if (player.collidesWith(walls.get(i).getBounds()) && walls.get(i) instanceof Door && keyCount > 0) {
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

        for (int i = 0; i < items.size(); i++) {
            if (player.collidesWith(items.get(i).getBounds())) {
                if (items.get(i) instanceof Key) {
                    items.get(i).getBounds().width = 0;
                    items.get(i).getBounds().height = 0;
                    keyCount = keyCount + 1;
                }
                if (items.get(i) instanceof Shield) {
                    items.get(i).getBounds().width = 0;
                    items.get(i).getBounds().height = 0;

                }
            }
        }

        mouseX = Gdx.input.getX();
        mouseY = Gdx.input.getY();
        rotate = MathUtils.atan2(300 - mouseY, 400 - mouseX) + (float) Math.PI;

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).trackPlayer(player);

            if (player.collidesWith(enemies.get(i).getBounds()) && !(enemies.get(i).hasDied()) && healthBar.width > 0 && pTimer == 0) {
                healthBar.width = healthBar.width - enemies.get(i).getDamage();
                pTimer = 75;
            } else if (pTimer != 0) {
                pTimer = pTimer - 1;
            }

        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).trackPlayer(player);

            if (sword.getAttackStatus() && enemies.get(i).collidesWith(sword.getBounds()) && healthBar.width > 0 && eTimer == 0) {
                enemies.get(i).health = enemies.get(i).health - 1;

                eTimer = 30;
            } else if (eTimer != 0) {
                eTimer = eTimer - 1;
            }
            enemies.get(i).dying();
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

        healthBar.setPosition(player.getPlayerX() - 290, player.getPlayerY() - 265);

        cam.position.x = player.getPlayerX() + (player.getBounds().width / 2);
        cam.position.y = player.getPlayerY() + (player.getBounds().height / 2);
        cam.update();

        sword.repostion(player, dUp, dDown, dLeft, dRight);

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            sword.attack();
            sword.changeAttackStatus(true);

        }
        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            sword.changeAttackStatus(false);
        }

        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeType.Filled);
        shapeBatch.setColor(Color.GOLD);

        shapeBatch.line(player.getPlayerX() + player.getBounds().width / 2, player.getPlayerY() + player.getBounds().height / 2, player.getPlayerX() + player.getBounds().width / 2 + (float) (50f * MathUtils.cos(-rotate)), player.getPlayerY() + player.getBounds().height / 2 + (float) (50f * MathUtils.sin(-rotate)));
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).getColourNum() == 0) {
                shapeBatch.setColor(Color.GRAY);
            } else if (walls.get(i).getColourNum() == 1) {
                shapeBatch.setColor(Color.BROWN);
            }

            shapeBatch.rect(walls.get(i).getBounds().x, walls.get(i).getBounds().y, walls.get(i).getBounds().width, walls.get(i).getBounds().height);

        }
        for (int i = 0; i < items.size(); i++) {
            shapeBatch.rect(items.get(i).getBounds().x, items.get(i).getBounds().y, items.get(i).getBounds().width, items.get(i).getBounds().height);

        }

        shapeBatch.setColor(Color.GREEN);
        shapeBatch.rect(healthBar.x, healthBar.y, healthBar.width, healthBar.height);
        //enemies.get(1).draw(shapeBatch);

        shapeBatch.end();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //batch.draw(pImg1, player.getPlayerX()+player.getBounds().width/2, player.getPlayerY()+player.getBounds().height/2, player.getPlayerX()+player.getBounds().width/2+(float)(50f*MathUtils.cos(-rotate)), player.getPlayerY()+player.getBounds().height/2+(float)(50f*MathUtils.sin(-rotate)));
        //batch.draw(pImg1, player.getBounds().x, player.getBounds().y,  player.getBounds().width/2+(float)(50f*MathUtils.cos(-rotate)), player.getBounds().height/2+(float)(50f*MathUtils.sin(-rotate)), 40, 40,1,1,rotate,0,0,160,160,false,false);
        if (rotate < 5.634448 && rotate > 3.7895408) {
            batch.draw(pImg90, player.getBounds().x, player.getBounds().y, 40, 40);
            batch.draw(sImg90, sword.getBounds().x, sword.getBounds().y, sword.getBounds().width, sword.getBounds().height);
            dLeft = false;
            dRight = false;
            dUp = true;
            dDown = false;
        } else if (rotate < 3.7895408 && rotate > 2.4967983) {
            batch.draw(pImg180, player.getBounds().x, player.getBounds().y, 40, 40);
            batch.draw(sImg180, sword.getBounds().x, sword.getBounds().y, sword.getBounds().width, sword.getBounds().height);
            dLeft = true;
            dRight = false;
            dUp = false;
            dDown = false;
        } else if (rotate < 2.4967983 && rotate > 0.6439831) {
            batch.draw(pImg270, player.getBounds().x, player.getBounds().y, 40, 40);
            batch.draw(sImg270, sword.getBounds().x, sword.getBounds().y, sword.getBounds().width, sword.getBounds().height);
            dLeft = false;
            dRight = false;
            dUp = false;
            dDown = true;
        } else {
            batch.draw(pImg0, player.getBounds().x, player.getBounds().y, 40, 40);
            batch.draw(sImg0, sword.getBounds().x, sword.getBounds().y, sword.getBounds().width, sword.getBounds().height);
            dLeft = false;
            dRight = true;
            dUp = false;
            dDown = false;
        }

        for (int i = 0; i < enemies.size(); i++) {

            batch.draw(eImg, enemies.get(i).getBounds().x, enemies.get(i).getBounds().y, enemies.get(i).getBounds().width, enemies.get(i).getBounds().height);
        }
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
