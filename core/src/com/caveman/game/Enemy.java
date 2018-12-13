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

    /**
     *
     * @param x
     * @param y
     * @param health
     * @param damage
     * @param speed
     * @param attackRange
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
     * @return
     */
    public float getEnemyX() {

        return this.xPos;
    }

    /**
     *
     * @return
     */
    public float getEnemyY() {

        return this.yPos;
    }

    /**
     *
     */
    public void health() {

    }

    /**
     *
     * @param player
     */
    public void trackPlayer(Player player) {
        int playX = player.getPlayerX();
        int playY = player.getPlayerY();
        if (dead == false) {
            if (player.getPlayerX() <= attackRange * 3) {
                if (this.xPos > playX) {
                    this.xPos = xPos - speed;
                } else if (this.xPos < playX) {
                    this.xPos = xPos + speed;
                } else {
                    this.xPos = xPos;
                }
                if (this.yPos > playY) {
                    this.yPos = yPos - speed;
                } else if (this.yPos < playY) {
                    this.yPos = yPos + speed;
                } else {
                    this.yPos = yPos;
                }
            }
        } else if (dead == true) {

        }
    }

    /**
     *
     * @return
     */
    public boolean track() {
        return tracking == true;
    }

    /**
     *
     */
    public void dying() {
        if (health <= 0) {
            dead = true;
        }
    }

    /**
     *
     * @return
     */
    public boolean hasDied() {

        return dead == true;
    }

    /**
     *
     * @param damage
     * @param attackRange
     * @param player
     */
    public void attack(int damage, int attackRange, Player player) {
        if (player.getPlayerX() <= this.getEnemyX() + attackRange) {
            player.health = player.health - damage;
            attack = true;
        } else if (player.getPlayerY() <= this.getEnemyY() + attackRange) {
            player.health = player.health - damage;
            attack = true;
        } else if (player.getPlayerX() >= this.getEnemyX() - attackRange) {
            player.health = player.health - damage;
            attack = true;
        } else if (player.getPlayerY() >= this.getEnemyY() - attackRange) {
            player.health = player.health - damage;
            attack = true;
        } else {
            attack = false;
        }
    }

    /**
     *
     * @return
     */
    public boolean attacking() {
        return attack == true;
    }

}
