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
public class Shooter extends Enemy {

    Player player;
    Enemy enemy;
    private int attackSpeed;
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
    public Shooter(float x, float y, int health, int damage, int speed, int attackRange, int width, int height) {
        super(x, y, health, damage, speed, attackRange, width, height);
        this.attackSpeed = 5;
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
     * @param damage is how much the enemy takes away health
     * @param attackRange is how far the enemy can attack
     * @param player tracks the player's actions
     */
    @Override
    public void attack(int damage, int attackRange, Player player) {
        // if they are in range to attack, deal damage on a timer
        if (attack == true) {
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    Bullet bullet = new Bullet(xPos, yPos);
                    firedShots.add(bullet);
                    // bullet.shoot(enemy.direction);
                    attack = false;
                    if(bullet.equals(player.x)){
                        player.health = player.health - damage;
                    }else if(bullet.equals(player.y)){
                        player.health = player.health - damage;
                    }
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void health() {
        this.health = 150;
    }

}
