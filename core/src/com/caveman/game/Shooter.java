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
public class Shooter extends Enemy {

    Player player;
    Enemy enemy;
    private int attackSpeed = 5;
    private boolean Attack;

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

    public void attack(int damage, int attackRange, Player player) {
        if(enemy.attack == true){
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    player.health = player.health - damage;
                    enemy.attack = false;
                } 
            }
        }
    }
}
