/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import java.util.ArrayList;

/**
 *
 * @author macdn5071
 */
public class Shooter extends Enemy {

    Player player;
    Enemy enemy;
    private int attackSpeed;
    private ArrayList<Bullet> firedShots = new ArrayList<Bullet>();
    

    public Shooter(float x, float y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
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
        Bullet bullet = new Bullet(xPos, yPos);
        if (attack == true) {
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    firedShots.add(bullet);
                    bullet.shoot(enemy.direction);
                    player.health = player.health - damage;
                    attack = false;
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
