/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author macdn5071
 */
public class Shooter extends Enemy{
     
    Player player;

    public Shooter(int x, int y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
    }

    /**
     *
     * @return
     */
    @Override
    public int getEnemyX() {
        return this.xPos;
    }

    /**
     *
     * @return
     */
    @Override
    public int getEnemyY() {
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
    public void move() {

    }
    
    /**
     *
     */
    @Override
    public void health(){
        this.health = 150;
    }

    public void attack(int damage, int attackRange, Player player) {
        if (player.getPlayerX() <= this.getEnemyX() + attackRange) {
            player.health = player.health - damage;
        } else if (player.getPlayerY() <= this.getEnemyY() + attackRange) {
            player.health = player.health - damage;
        } else if (player.getPlayerX() >= this.getEnemyX() - attackRange) {
            player.health = player.health - damage;
        } else if (player.getPlayerY() >= this.getEnemyY() - attackRange) {
            player.health = player.health - damage;
        }
    }
}
