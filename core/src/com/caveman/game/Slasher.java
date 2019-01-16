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
public class Slasher extends Enemy {

    
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
    public Slasher(float x, float y, int health, int damage, int speed, int attackRange, int width, int height) {
        super(x, y, health, damage, speed, attackRange, width, height);
        this.speed = 15;
        this.attackRange = 10;
        this.damage = 50;
    }

    /**
     *
     * @return their x position
     */
    @Override
    public float getEnemyX() {
        return this.xPos;
    }

    /**
     *
     * @return their y position
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
    public void health(){
        this.health = 300;
    }

}
