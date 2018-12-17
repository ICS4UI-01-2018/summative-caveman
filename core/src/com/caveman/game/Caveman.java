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
    //private Texture img;
    private Player player;
    // private ArrayList<Enemies> enemies;
    private ArrayList<Rectangle> walls;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Rectangle wall1;
    private Rectangle wall2;
    private Rectangle wall3;
    private Rectangle wall4;
    private Enemy enemy;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();
        walls = new ArrayList<Rectangle>();
        //img = new Texture("badlogic.jpg");
        cam = new OrthographicCamera(800, 600);
        viewport = new FitViewport(800, 600, cam);
        viewport.apply();
        cam.position.x = 400;
        cam.position.y = 300;
        cam.update();

        player = new Player(390, 290, 20, 20, 5, 4);

        walls.add(new Rectangle(25, 100, 25, 400));
        walls.add(new Rectangle(750, 100, 25, 400));
        walls.add(new Rectangle(25, 75, 750, 25));
        walls.add(new Rectangle(25, 500, 750, 25));

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.moveDown();
        }

        shapeBatch.setProjectionMatrix(cam.combined);
        shapeBatch.begin(ShapeType.Line);

        shapeBatch.setColor(Color.GRAY);
        for (int i = 0; i < walls.size(); i++) {
            shapeBatch.rect(walls.get(i).x, walls.get(i).y, walls.get(i).width, walls.get(i).height);
        }

        player.draw(shapeBatch);

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
