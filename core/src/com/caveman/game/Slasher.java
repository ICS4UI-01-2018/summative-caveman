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

    Player player;

    public Slasher(int x, int y, int health, int damage, int speed, int attackRange) {
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
        this.health = 300;
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
