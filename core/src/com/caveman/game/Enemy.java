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

    int xPos;
    int yPos;

    public int health;
    public int damage;
    public int speed;
    public boolean collide;
    public boolean dead;
    Player player;

    public Enemy(int x, int y, int health, int damage, int speed) {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    public int getEnemyX() {
        return this.xPos;
    }

    public int getEnemyY() {
        return this.yPos;
    }

    public void move() {

    }

    public void trackPlayer(Player player) {
        int playX = player.getPlayerX();
        int playY = player.getPlayerY();
        if (dead == false) {
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
        } else if (dead == true) {

        }
    }

    public void collision() {

    }

    public boolean collide() {
        return collide = true;
    }

    public void dying() {
        if (health <= 0) {
            dead = true;
        }
    }

    public boolean hasDied() {
        if (dead == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param damage
     */
    public void attack(int damage) {

    }

}
