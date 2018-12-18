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
    
    public Sword(int effect, int range, String name){
        super(effect, name);
        
        this.range = 15;
    }
    
    public int getRange(){
        return this.range;
    }
    
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
    
    public boolean Attacking(){
        if(enemy.attack == true){
            return Attack = true;
        }else if(enemy.attack == false){
            return Attack = false;
        }
        return false;
    }
}
