/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Boss extends Slasher {

    /**
     *
     * refer to enemy class for javadoc
     * @param x
     * @param y
     * @param health
     * @param damage
     * @param speed
     * @param attackRange
     * @param width
     * @param height
     */
    public Boss(float x, float y, int health, int damage, int speed, int attackRange, int width, int height) {
        super(x, y, health, damage, speed, attackRange, width, height);
        this.speed = super.speed;
        this.attackRange = 20;
        this.damage = 250;
    }

    @Override
    public float getEnemyX() {
        return this.xPos;
    }

    @Override
    public float getEnemyY() {
        return this.xPos;
    }

    @Override
    public void health() {
        this.health = 1000;
    }
}