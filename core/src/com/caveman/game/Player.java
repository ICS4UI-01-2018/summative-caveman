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
    public int damage;
    private boolean collide;
    private boolean alive;
    Items items;
    private boolean pickUp;
    private boolean useItems;
    private int numItems = 0;
    Food food;
    Key key;
    Door door;
    Shield shield;
    Sword sword;
    private int numFood = 0;
    private int numShield = 0;
    private boolean swording;

    /**
     * 
     * @param x x position of the player
     * @param y y position of the player
     * @param width width of the player
     * @param height height of the player
     * @param health health of the player
     * @param speed the speed of the player
     */
    
    public Player(float x, float y, int width, int height, int health, int speed){
        this.x = x;
        this.y = y; 
        this.speed = 5;
        player = new Rectangle(x,y,width,height);
        this.health = 1000;
    }
    
    /**
     * 
     * @return the x position of the player
     */
    public float getPlayerX(){
        return player.x;
    }
    
    /**
     * 
     * @return the y position of the player
     */
    public float getPlayerY(){
        return player.y;
    }
    
    /**
     * method to pick up items 
     * if they picked up the items, the number of items the player picked up is increased by 1
     * and total number of items the player has is also increased by 1
     * then the pickup is false to not pick up the same one again
     * number of items are not over 5 
     * if the number of items the player has is 5,
     * the player cannot pick up the item.
     */
    public void pickUpItems(){
        
        if(numItems < 5){
            if(pickUp == true){
                if(items == food){
                    numFood++;
                }else if(items == key){
                    door.unlock();
                }else if(items == shield){
                    numShield++;
                }
                numItems++;
                pickUp = false;
            }
        }else if(numItems >= 5 || numItems <= 0){
            if(pickUp == true){
                pickUp = false;
            }
        }
    }
    
    /**
     * method to use items
     * when the total number of items are bigger than 0 and use item button clicked,
     * item is used with some effects to the players by each different item
     * and the number of them is decreases.
     * if the player does not have any items, the player cannot use any items.
     */
    public boolean usingItems(int numFood, int numShield){
        if(numItems > 0){
            if(useItems == true){
                if(items == food && numFood > 0){
                    food.eat();
                    numFood--;
                }
                if(items == shield && numShield > 0){
                    shield.Shielded();
                    numShield--;
                }
                return useItems = false;
            }
        }else if(numItems <= 0){
            return useItems = false;
        }
        return useItems = false;
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
     * method to check the player is alive or not
     * if its health is or under 0, 
     * @return false and the player is dead.
     * if its health is over 0,
     * @return true and the player is alive. 
     */
    public boolean alive() {
        if (health <= 0) {
            return alive = false;
        }else{
        return alive = true;
        }
    }

    /**
     * initially, 1000 hp of health is given to the player when the game is just started.
     * health decreases by the amount of damages the player got. 
     * its health cannot be over 1000 nor be less than 0
     * if its health is negative, it shows as a 0 and the player dies 
     */
    public void health() {
        int iniHealth = 1000;
        health -= damage;

        if (health >= 1000) {
            health = 1000;
        } else if (health <= 0) {
            health = 0;
        }
    }
    
    
    public boolean collidesWith(Rectangle rect) {
        return player.overlaps(rect);
}
    
    public Rectangle getBounds() {
        return player;
    }   
}
