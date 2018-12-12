/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author choij2116
 */
public class Enemy {

    float xPos;
    float yPos;

    public int health;
    public int damage;
    public int speed;
    public boolean collide;
    Player player;
    public boolean attack;
    public boolean tracking;

    public Enemy(float x, float y, int health, int damage, int speed, int attackRange) {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }
    }
    
    public void collision(){
        
    }
        this.attackRange = attackRange;
    }

    public float getEnemyX() {
        return this.xPos;
    }

    public float getEnemyY() {
        return this.yPos;
    }

    public void health() {

    }
}
