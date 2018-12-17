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
public class Food extends Items {
    
    Player player;
    private boolean eaten; 
    
    public Food(int effect, String name){
        super(effect, name);
    }
        
    public void Heal(){
        if(eaten == false){
            player.health = player.health + 100;
            eaten = true;
        }
    }
    
    public boolean eat(){
        if(eaten == true){
            return true;
        }else{
            return false;
        }
    }
}
