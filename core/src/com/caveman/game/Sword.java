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
    
    public Sword(int range, String name){
        super(name);
        
        this.range = range;
    }
    
    public int getRange(){
        return this.range;

    }
    
    public void Attack(int damage){ 
        if(Attack == true){
            if(enemy.xPos <= player.x + range && enemy.xPos >= player.x - range){
                if(enemy.yPos <= player.y + range && enemy.yPos <= player.y + range){
                    enemy.health = enemy.health - damage;
                    Attack = false;
                }
            }
        }else{
            // nothing
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
