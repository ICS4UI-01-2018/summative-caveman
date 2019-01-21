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
    
    public Food(int effect, String name, float x, float y, int width, int height){
        super(effect, name, x, y,width, height);
    }
    
    /**
     * When the player eat the food (==have not eaten the food), player's health
     * increases by 100 at once. If the player already ate the food,
     * @return eaten = true
     */
    public boolean eat(){
        if(eaten == true){
            // nothing happen
        }else if(eaten == false){
            player.health = player.health + 100;
        }
        return eaten = true;
    }
}
