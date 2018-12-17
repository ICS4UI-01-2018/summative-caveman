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
    
    public float x;
    public float y;
    private Rectangle player;
    private int speed;
    public int health;
    public int damage;
    private boolean collide;
    private int hitCount;
    private boolean alive;
    Items items;
    private boolean pickUp;
    private boolean useItems;
    private int numItems = 0;
    Food food;
    Key key;
    Shield shield;
    private int numFood = 0;
    private int numKey = 0;
    private int numShield = 0;

    
    public Player(float x, float y, int width, int height, int health, int speed){
        this.x = x;
        this.y = y; 
        this.speed = 5;
        player = new Rectangle(x,y,width,height);
        this.health = 500;
    }
    
    public float getPlayerX(){
        return this.x;
    }
    
    public float getPlayerY(){
        return this.y;
    }
    
    public void pickUpItems(){
        
        if(numItems < 5){
            if(pickUp == true){
                if(items == food){
                    numFood++;
                }else if(items == key){
                    numKey++;
                }else if(items == shield){
                    numShield++;
                }
                numItems++;
                pickUp = false;
            }
        }else if(numItems >= 5){
            pickUp = false;
        }
    }
    
    public void usingItems(){
        if(numItems > 0){
            if(useItems == true){
                if(items == food && numFood > 0){
                    food.Heal();
                    numFood--;
                }else if(items == key && numKey > 0){

                }else if(items == shield && numShield > 0){
                    shield.Shield();
                    numShield--;
                }
                useItems = false;
            }
        }else if(numItems <= 0){
            useItems = false;
        }
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
