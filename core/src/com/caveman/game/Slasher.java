/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author macdn5071
 */
public class Slasher extends Enemy{
    
    private int attackRange;
    
    public Slasher(float x, float y, int health, int damage, int speed){
        super(x, y, health, damage, speed);
    }
    
    @Override
    public void move(){
        
    }
    
    public void trackPlayer(){
        
    }
    
    @Override
    public void collision(){
        
    }
    
    @Override
    public boolean collide(){
        return collide = true;
    }
    
    public void attack(int damage, int attackRange, Player player){
        if(player.x <= attackRange || player.y <= attackRange){
            player.health = player.health - damage;
        }
    }
}
