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
public class Shooter extends Enemy {

    Player player;
    private int attackSpeed = 5;

    public Shooter(float x, float y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
        this.attackSpeed = attackSpeed;
        this.damage = 100;
        this.attackRange = 200;
        this.speed = 0;
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

    /**
     *
     */
    @Override
    public void health() {
        this.health = 150;
    }

    
}
