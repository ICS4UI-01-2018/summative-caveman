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
public class Shield extends Items {
    
    Player player;
    Enemy enemy;
    
    public Shield(int effect, String name){
        super(effect,name);
    }
    
    /**
     * if the player used a shield, and enemy attacked the player within the range,
     * it negates their attacks. 
     */
    public void Shield(){
        if(enemy.xPos <= player.x + enemy.attackRange && enemy.xPos >= player.x - enemy.attackRange){
            if(enemy.yPos <= player.y + enemy.attackRange && enemy.yPos >= player.y - enemy.attackRange){
                if(enemy.attack == true){
                    enemy.attack = false;
                }
            }
        }
    }
}
