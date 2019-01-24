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
    private Texture keyImg;
    private Texture bKeyImg;
    private boolean dLeft;
    private boolean dRight;
    private boolean dUp;
    private boolean dDown;
    private Player player;
    private Sword sword;
    private ArrayList<Wall> walls;
    private ArrayList<Items> items;
    private Rectangle healthBar;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private ArrayList<Enemy> enemies;
    private boolean pUpAllowed;
    private boolean pLeftAllowed;
    private boolean pRightAllowed;
    private boolean pDownAllowed;
    private boolean gameStart;
    private boolean gameWin;
    private boolean youDied;
    private float mouseX;
    private float mouseY;
    private float rotate;
    private int keyCount;
    private int swordTimer;
    private int keyTimer;
    private int pTimer;
    private int eTimer;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private BitmapFont font80;
    private BitmapFont font30;

    @Override
    public void create() {
        //intialize variables
        generator = new FreeTypeFontGenerator(Gdx.files.internal("RunyTunesRevisitedNF.ttf"));
        parameter = new FreeTypeFontParameter();
        parameter.size = 80;
        gameStart = false;
        keyTimer = 0;
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'’‘=()>?:";
        font80 = generator.generateFont(parameter);
        parameter.size = 30;
        font30 = generator.generateFont(parameter);
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
        gameWin = false;
        youDied = false;
        eTimer = 0;
        pUpAllowed = true;
        pDownAllowed = true;
        pRightAllowed = true;
        pLeftAllowed = true;
        //initialize images
        bKeyImg = new Texture("bosskey.png");
        keyImg = new Texture("key_(The_Legend_of_Zelda).png");
        eImg = new Texture("slime.png");
        pImg0 = new Texture("guy0.png");
        pImg90 = new Texture("guy90.png");
        pImg180 = new Texture("guy180.png");
        pImg270 = new Texture("guy270.png");
        sImg0 = new Texture("sword0.png");
        sImg90 = new Texture("sword90.png");
        sImg180 = new Texture("sword180.png");
        sImg270 = new Texture("sword270.png");
        //initialize, apply and update the viewport and camera position
        cam = new OrthographicCamera(800, 600);
        viewport = new FitViewport(800, 600, cam);
        viewport.apply();
        cam.position.x = 400;
        cam.position.y = 300;
        cam.update();
        //initialize player
        player = new Player(390, 290, 40, 40, 600, 4);
        //initialize healthbar
        healthBar = new Rectangle(100, 25, player.getPlayerHealth(), 25);
        sword = new Sword(player.getPlayerX() - 15, player.getPlayerY(), 15, 50, 10);
        //enemies
        enemies.add(new Enemy(200, 1000, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(400, 1000, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(600, 1000, 3, 25, 1, 200, 40, 40));

        enemies.add(new Enemy(1200, 1000, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(1400, 1000, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(1600, 1000, 3, 25, 1, 200, 40, 40));

        enemies.add(new Enemy(1600, 1600, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(1800, 1600, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(2000, 1600, 3, 25, 1, 200, 40, 40));

        enemies.add(new Enemy(1600, 400, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(1800, 400, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(2000, 400, 3, 25, 1, 200, 40, 40));

        enemies.add(new Enemy(2500, 500, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(2500, 700, 3, 25, 1, 200, 40, 40));
        enemies.add(new Enemy(2500, 900, 3, 25, 1, 200, 40, 40));

        //items
        items.add(new Key(0, 430, 320, 20, 20));
        items.add(new Key(0, 2100, 1600, 20, 20));
        items.add(new Key(1, 2525, 1400, 80, 80));
        //doors
        walls.add(new Door(325, 550, 150, 25, 1));
        walls.add(new Door(2500, 1100, 150, 25, 1));
        walls.add(new Door(325, 1325, 150, 25, 2));
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
        walls.add(new Wall(-125, 725, 25, 600, 0));
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
        walls.add(new Wall(2150, 1450, 25, 400, 0));
        //sixth hallway
        walls.add(new Wall(2500, 1075, 25, 200, 0));
        walls.add(new Wall(2625, 1075, 25, 200, 0));
        //seventh room
        walls.add(new Wall(2375, 1250, 25, 350, 0));
        walls.add(new Wall(2750, 1250, 25, 350, 0));
        walls.add(new Wall(2400, 1575, 350, 25, 0));
        walls.add(new Wall(2400, 1250, 100, 25, 0));
        walls.add(new Wall(2650, 1250, 100, 25, 0));
        //initialize player timer
        pTimer = 0;

    }

    @Override
    public void render() {
        //set gdx background
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //play the game when player hits enter
        if (gameStart && !gameWin && !youDied) {
            //set player direction booleans to true
            pUpAllowed = true;
            pDownAllowed = true;
            pRightAllowed = true;
            pLeftAllowed = true;
            //set all enemy direction booleans to true
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                e.changeUpAllowed(true);
                e.changeRightAllowed(true);
                e.changeDownAllowed(true);
                e.changeLeftAllowed(true);
            }
            //check all walls for player collision to stop the player from going through walls, or doors unless the player has the key for it
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
                    if (d.getColourNum() == 2) {
                        gameWin = true;
                    }
                    d.unlock();
                    keyCount = keyCount - 1;
                }
            }
            //checks enemies to make sure enemies and players cannot go through eachother, as well as making sure enemies don't go through walls
            for (int i = 0; i < enemies.size(); i++) {
                Enemy e = enemies.get(i);
                if (!e.hasDied()) {
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
            //picks up all items as well as spawns the boss when the final key is picked up
            for (int i = 0; i < items.size(); i++) {
                if (player.collidesWith(items.get(i).getBounds())) {
                    if (items.get(i) instanceof Key && keyTimer == 0) {
                        items.get(i).getBounds().width = 0;
                        items.get(i).getBounds().height = 0;
                        keyCount = keyCount + 1;
                        keyTimer = 75;
                    }
                    if (items.get(i).getEffect() == 1) {
                        Enemy e = new Enemy(300, 1000, 30, 25, 1, 200, 250, 250);
                        enemies.add(e);
                    }
                } else if (keyTimer > 0) {
                    keyTimer = keyTimer - 1;
                }
            }
            //use the mouse coordinates to calculate the rotation angle
            mouseX = Gdx.input.getX();
            mouseY = Gdx.input.getY();
            rotate = MathUtils.atan2(300 - mouseY, 400 - mouseX) + (float) Math.PI;

            //allows player to take damage from enemies with an immune timer, as well has setting the player to dead
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).trackPlayer(player);
                if (player.collidesWith(enemies.get(i).getBounds()) && !(enemies.get(i).hasDied()) && healthBar.width > 0 && pTimer == 0) {
                    healthBar.width = healthBar.width - enemies.get(i).getDamage();
                    pTimer = 175;
                } else if (pTimer != 0) {
                    pTimer = pTimer - 1;
                } else if (healthBar.width <= 0) {
                    youDied = true;
                }

            }

            //has enemies track the player as well as take damage from the enemies attack and die
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).trackPlayer(player);

                if (sword.getAttackStatus() && enemies.get(i).collidesWith(sword.getBounds()) && healthBar.width > 0 && eTimer == 0) {
                    enemies.get(i).health = enemies.get(i).health - 1;
                    eTimer = 130;
                } else if (eTimer != 0) {
                    eTimer = eTimer - 1;
                }
                enemies.get(i).dying();
            }
            //have the player move up when w is pressed and is not colliding upwards
            if (Gdx.input.isKeyPressed(Input.Keys.W) && pUpAllowed) {
                player.moveUp();
            }
            //have the player move up when w is pressed and is not colliding upwards
            if (Gdx.input.isKeyPressed(Input.Keys.A) && pLeftAllowed) {
                player.moveLeft();
            }
            //have the player move up when w is pressed and is not colliding upwards
            if (Gdx.input.isKeyPressed(Input.Keys.D) && pRightAllowed) {
                player.moveRight();
            }
            //have the player move up when w is pressed and is not colliding upwards
            if (Gdx.input.isKeyPressed(Input.Keys.S) && pDownAllowed) {
                player.moveDown();
            }
            //set the healthbar position
            healthBar.setPosition(player.getPlayerX() - 290, player.getPlayerY() - 265);

            //have the camera follow the player
            cam.position.x = player.getPlayerX() + (player.getBounds().width / 2);
            cam.position.y = player.getPlayerY() + (player.getBounds().height / 2);
            cam.update();
            //reposition the sword
            sword.repostion(player, dUp, dDown, dLeft, dRight);
            //have the player attack with left click and set attacking to true
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                sword.attack();
                sword.changeAttackStatus(true);

            }
            //when left click isn't clicked set attacking to false
            if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                sword.changeAttackStatus(false);
            }
            //when players hit enter and the game hasn't started the game will start
        } else if (!gameStart && Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            gameStart = true;

        }

        shapeBatch.end();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //draw the player and sword as well as set direction booleans when the game has started
        if (gameStart && !youDied && !gameWin) {
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
            //draw all enemies
            for (int i = 0; i < enemies.size(); i++) {

                batch.draw(eImg, enemies.get(i).getBounds().x, enemies.get(i).getBounds().y, enemies.get(i).getBounds().width, enemies.get(i).getBounds().height);
            }
            //draw items
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getEffect() == 0) {
                    batch.draw(keyImg, items.get(i).getBounds().x, items.get(i).getBounds().y, items.get(i).getBounds().width, items.get(i).getBounds().height);
                } else {
                    batch.draw(bKeyImg, items.get(i).getBounds().x, items.get(i).getBounds().y, items.get(i).getBounds().width, items.get(i).getBounds().height);
                }
            }
            //draw beginning text
        } else if (!gameStart) {
            font80.setColor(Color.GRAY);
            font30.setColor(Color.GRAY);
            font80.draw(batch, "Cave Man", 325, 425);
            font30.draw(batch, "How to Play:", 25, 200);
            font30.draw(batch, "‘W’ = Move Forward", 25, 170);
            font30.draw(batch, "‘S’ = Move Backwards", 25, 140);
            font30.draw(batch, "‘A’ = Move Left", 25, 110);
            font30.draw(batch, "‘D’= Move Right", 25, 80);
            font30.draw(batch, "‘Left Click’ = Attack", 25, 50);
            font30.draw(batch, "Hit ‘Enter’ to Start", 345, 330);
            //draw winning text
        } else if (gameWin) {
            font80.setColor(Color.GREEN);
            font80.draw(batch, "You Win!", player.getPlayerX() - 75, player.getPlayerY() + 100);
            //draw dead text
        } else if (youDied) {
            font80.setColor(Color.RED);
            font80.draw(batch, "You Died", player.getPlayerX() - 75, player.getPlayerY() + 100);
        }

        batch.end();

        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeType.Filled);
        //when the game has started draw all walls, doors, and the healthbar
        if (gameStart && !gameWin && !youDied) {
            for (int i = 0; i < walls.size(); i++) {
                if (walls.get(i).getColourNum() == 0) {
                    shapeBatch.setColor(Color.GRAY);
                } else if (walls.get(i).getColourNum() == 1) {
                    shapeBatch.setColor(Color.BROWN);
                } else if (walls.get(i).getColourNum() == 2) {
                    shapeBatch.setColor(Color.GOLD);
                }

                shapeBatch.rect(walls.get(i).getBounds().x, walls.get(i).getBounds().y, walls.get(i).getBounds().width, walls.get(i).getBounds().height);

            }

            shapeBatch.setColor(Color.GREEN);
            shapeBatch.rect(healthBar.x, healthBar.y, healthBar.width, healthBar.height);
        }
        shapeBatch.end();
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
