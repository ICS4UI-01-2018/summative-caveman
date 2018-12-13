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
    private int attackSpeed = 5;
    private boolean Attack;

    public Shooter(int x, int y, int health, int damage, int speed, int attackRange) {
        super(x, y, health, damage, speed, attackRange);
        this.attackSpeed = attackSpeed;
        this.attackRange = 200;
        this.speed = 0;
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
        if(Attack == true){
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    player.health = player.health - damage;
                    Attack = false;
                } 
            }
        }
    }
    
    public boolean Attacking(){
        if(Attack == true){
            return true;
        }else{
            return false;
        }
    }
}
