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
 */
public class Player {
    
    private int x;
    private int y;
    private Rectangle player;
    private int speed;
    public int health;
    private boolean collide;
    
    public Player(int x, int y, int width, int height, int health, int speed){
        this.speed = speed;
        player = new Rectangle(x,y,width,height);
        this.health = health;
    }
    
    public int getPlayerX(){
        return this.x;
    }
    
    public int getPlayerY(){
        return this.y;
    }
    
    public void pickUpDropItems(){
        
    }
    
    public void moveUp(){
        player.y = player.y + speed;
    }
    
    public void moveDown(){
        player.y = player.y - speed;
    }
    
    public void moveLeft(){
        player.x = player.x - speed;
    }
    
    public void moveRight(){
        player.x = player.x + speed;
    }
    
    public void health(){
        
    }
    
    public void collision(){
        
    }
    
    public boolean collide(){
        if(collide == true){
            return true;
        }else{
            return false;
        }
    }
    
    public void damage(){
        if(collide == true){
            
        }else{
            
        }
    }
    public void draw(ShapeRenderer shapeBatch){
        shapeBatch.rect(player.x, player.y, player.width, player.height);
    }
}
