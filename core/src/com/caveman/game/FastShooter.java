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
public class FastShooter extends Shooter{
    
    Player player;
    
    private int attackSpeed = 15;

    public FastShooter(float x, float y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
        this.attackSpeed = attackSpeed;
        this.attackRange = super.attackRange;
        this.damage = 215;
        this.speed = 5;
    }

    /**
     *
     * @return
     */
    @Override
    public float getEnemyX() {
        return this.xPos;
    }

    /**
     *
     * @return
     */
    @Override
    public float getEnemyY() {
        return this.yPos;
    }

    /**
     *
     * @param player
     */
    @Override
    public void trackPlayer(Player player) {
        super.trackPlayer(player);
    }
    
    @Override
    public void health(){
        this.health = super.health;
    }
}
