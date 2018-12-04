/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author choij2116
 */
public class Enemy {
    
    public float x;
    public float y;
    public int health;
    public int damage;
    public int speed;
    public boolean collide;
    
    public Enemy(float x, float y, int health, int damage, int speed){
        this.x = x;
        this.y = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }
    
    public void move(){
        
    }
    
    public void trackPlayer(){
        
    }
    
    public void collision(){
        
    }
    
    public boolean collide(){
        if(collide = true){
            return true;
        }else{
            return false;
        }
    }
    
    public void attack(int damage){
        
    }
    
}
