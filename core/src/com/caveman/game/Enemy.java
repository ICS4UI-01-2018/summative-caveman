/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.sun.xml.internal.ws.handler.HandlerProcessor.Direction;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Enemy {

    float xPos;
    float yPos;

    public int health;
    public int damage;
    public int speed;
    public int attackRange;
    public boolean collide;
    public boolean dead;
    Player player;
    public boolean attack;
    public boolean tracking;
    public Direction direction;

    /**
     *
     * @param x controls x position
     * @param y controls y position
     * @param health tracks current enemy health
     * @param damage is how much the enemy takes away health
     * @param speed is how fast the enemy moves
     * @param attackRange is how far the enemy can attack
     */
    public Enemy(float x, float y, int health, int damage, int speed, int attackRange) {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.attackRange = attackRange;
    }

    /**
     *
     * @return enemy X position
     */
    public float getEnemyX() {
        return this.xPos;
    }

    /**
     *
     * @return enemy Y position
     */
    public float getEnemyY() {
        return this.yPos;
    }

    public void move() {

    }
    
    public void health(){
        
    }

    /**
     *
     * @param player tracks the player's movement
     */
    public void trackPlayer(Player player) {
        float playX = player.getPlayerX();
        float playY = player.getPlayerY();
        // if the enemy is not dead, follow the player up to their range times 3
        if (dead == false) {
            if (player.getPlayerX() <= attackRange * 4) {
                if (this.xPos > playX) {
                    // they follow using their x or y position modified by their speed stat
                    // their direction updates too so they can attack accurately
                    this.xPos = xPos - speed;
                    direction = Direction.LEFT;
                } else if (this.xPos < playX) {
                    this.xPos = xPos + speed;
                    direction = Direction.RIGHT;
                } else {
                    this.xPos = xPos;
                    direction = direction;
                }
                if (this.yPos > playY) {
                    this.yPos = yPos - speed;
                    direction = Direction.DOWN;
                } else if (this.yPos < playY) {
                    this.yPos = yPos + speed;
                    direction = Direction.UP;
                } else {
                    this.yPos = yPos;
                    direction = direction;
                }
            }
        } else if (dead == true) {

        }
    }

    /**
     *
     * @return where the player is if in range
     */
    public boolean track() {
        return tracking == true;
    }

    /**
     * tells the game if the enemy is dead
     */
    public void dying() {
        if (health <= 0) {
            dead = true;
        }
    }

    /**
     *
     * @return if the enemy has died
     */
    public boolean hasDied() {
        return dead == true;
    }

    /**
     *
     * @param damage is how much the enemy takes away health
     * @param attackRange is how far the enemy can attack
     * @param player tracks the player's actions
     */
    public void attack(int damage, int attackRange, Player player) {
        // if they are in range to attack, deal damage on a timer
        if (attack == true) {
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    player.health = player.health - damage;
                    attack = false;
                }
            }
        }
    }

    /**
     *
     * @return if the enemy is attacking or not
     */
    public boolean attacking() {
        return attack == true;
    }

}
