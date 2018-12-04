/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author choij2116
 */
public class Player {
    
    private Rectangle player;
    private int speed;
    private int health;
    private boolean collide;
    
    public Player(float x, float y, int width, int height, int health, int speed){
        this.speed = speed;
        player = new Rectangle(x,y,width,height);
        this.health = health;
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
    
    public void Health(){
        
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
}
