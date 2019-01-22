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
public class Sword extends Items{
    private int range;
    Enemy enemy;
    Player player;
    private boolean Attack;
    
    /**
     * Refer to Items
     * @param effect 
     * @param range that player can attack 
     * @param name of item == sword
     */
    public Sword(int effect, String name, float x, float y, int width, int height, int range){
        super(effect, name, x, y,width, height);
    
        this.range = 15;
    }
    
    /**
     * if the player try to execute to attack enemy(== when attack key pressed),
     * it is executed when the enemy is within the attack range. 
     * When the player successfully attack the enemy, the enemy's health is 
     * decreased by 100 hp. 
     * Then, by making boolean attack = false, make it to attack the enemy only once at a time. 
     */
    public void Attack(){ 
        if(Attack == true){
            if(enemy.xPos <= player.x + range && enemy.xPos >= player.x - range){
                if(enemy.yPos <= player.y + range && enemy.yPos <= player.y + range){
                    enemy.health = enemy.health - 100;
                    Attack = false;
                }
            }
        }else{
            Attack = false; 
        }
    }
}
