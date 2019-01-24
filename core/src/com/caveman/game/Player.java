/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Player {

    public float x;
    public float y;
    private Rectangle player;
    private int speed;
    public int health;
    private boolean alive;

    /**
     *
     * @param x x position of the player
     * @param y y position of the player
     * @param width width of the player
     * @param height height of the player
     * @param health health of the player
     * @param speed the speed of the player
     */
    public Player(float x, float y, int width, int height, int health, int speed) {
        this.x = x;
        this.y = y;
        this.speed = 5;
        player = new Rectangle(x, y, width, height);
        this.health = health;
    }

    /**
     *
     * @return the health of the player
     */
    public int getPlayerHealth() {
        return health;
    }

    /**
     *
     * @return the x position of the player
     */
    public float getPlayerX() {
        return player.x;
    }

    /**
     *
     * @return the y position of the player
     */
    public float getPlayerY() {
        return player.y;
    }

    /**
     * move up the player's position by changing its y position
     */
    public void moveUp() {
        player.y = player.y + speed;
    }

    /**
     * move down the player's position by changing its y position
     */
    public void moveDown() {
        player.y = player.y - speed;
    }

    /**
     * move left the player's position by changing its x position
     */
    public void moveLeft() {
        player.x = player.x - speed;
    }

    /**
     * move right the player's position by changing its x position
     */
    public void moveRight() {
        player.x = player.x + speed;
    }

    /**
     * check if a rectangle is colliding with the player
     *
     * @param rect the rectangle that will be checked
     * @return return the overlap boolean
     */
    public boolean collidesWith(Rectangle rect) {
        return player.overlaps(rect);
    }

    /**
     * get the player rectangle
     *
     * @return the player rectangle
     */
    public Rectangle getBounds() {
        return player;
    }
}
