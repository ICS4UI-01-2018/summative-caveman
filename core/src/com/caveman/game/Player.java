/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

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

    public int x;
    public int y;
    private Rectangle player;
    private int speed;
    public int health;
    public int damage;
    private boolean collide;
    private int hitCount;
    private boolean alive;
    Items items;
    private boolean pickUp;

    
    public Player(int x, int y, int width, int height, int health, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        player = new Rectangle(x, y, width, height);
        this.health = health;
    }

    public int getPlayerX() {
        return this.x;
    }

    public int getPlayerY() {
        return this.y;
    }

    public void pickUpDropItems() {

    }

    public void moveUp() {
        player.y = player.y + speed;
    }

    public void moveDown() {
        player.y = player.y - speed;
    }

    public void moveLeft() {
        player.x = player.x - speed;
    }

    public void moveRight() {
        player.x = player.x + speed;
    }

    public boolean alive() {
        if (health <= 0) {
            return alive = false;
        }else{
            return true;
        }
    }
    
    public void collision(){
        hitCount = 0;
        
        if(collide){
            hitCount++;
        }
    }
    
    public boolean collide(){
        if(collide == true){
        return true;
        }else{
            return false;
    }
    }

    public void health() {
        int iniHealth = 500;
        health -= damage;

        if (health >= 500) {
            health = 500;
        } else if (health <= 0) {
            health = 0;
        }
    }

    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(player.x, player.y, player.width, player.height);
    }
    
    public boolean collidesWith(Rectangle rect) {
        return player.overlaps(rect);
}
    
    public Rectangle getBounds() {
        return player;
    }   
}
