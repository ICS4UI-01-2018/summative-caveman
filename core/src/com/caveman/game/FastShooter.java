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
public class FastShooter extends Shooter{
    
    Player player;
    private int attackSpeed = 10;

    public FastShooter(int x, int y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
        this.attackSpeed = attackSpeed;
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
    
    @Override
    public void health(){
        this.health = super.health;
    }

    /**
     *
     * @param damage
     * @param attackRange
     * @param player
     */
    @Override
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
