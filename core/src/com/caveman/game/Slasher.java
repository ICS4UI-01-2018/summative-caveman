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
public class Slasher extends Enemy {

    public int attackRange;
    Player player;

    public Slasher(int x, int y, int health, int damage, int speed) {
        super(x, y, health, damage, speed);
    }

    @Override
    public int getEnemyX() {
        return this.xPos;
    }

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
    public void move() {

    }

    public void attack(int damage, int attackRange, Player player) {
        if (player.getPlayerX() == this.getEnemyX() + -attackRange) {
            player.health = player.health - damage;
        } else if (player.getPlayerX() == this.getEnemyY() + -attackRange) {
            player.health = player.health - damage;
        }
    }
}
