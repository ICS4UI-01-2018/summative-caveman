/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author choij2116
 */
public class Sword extends Player{
    
    
    public Sword(){
        
        this.range = 15;
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
        }else{
            return Attack = false;
        }
    }
}
