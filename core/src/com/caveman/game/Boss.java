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
public class Boss extends Slasher{
    
    public Boss(float x, float y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
        this.speed = super.speed;
    }
    
    @Override
    public float getEnemyX(){
        return this.xPos;
    }
    
    @Override
    public float getEnemyY(){
        return this.xPos;
    }
    
    @Override
    public void health(){
        this.health = 1000;
    }
}
