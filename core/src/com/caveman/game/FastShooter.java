/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import java.util.ArrayList;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class FastShooter extends Shooter {

    Player player;

    private int attackSpeed = 15;
    private ArrayList<Bullet> firedShots = new ArrayList<Bullet>();

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
    public FastShooter(float x, float y, int health, int damage, int speed, int attackRange, int width, int height) {
        super(x, y, health, damage, speed, attackRange, width, height);
        this.attackSpeed = attackSpeed;
        this.attackRange = super.attackRange;
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

    @Override
    public void health() {
        this.health = super.health;
    }

    
}
