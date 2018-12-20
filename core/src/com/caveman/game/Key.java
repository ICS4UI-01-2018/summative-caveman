/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

/**
 *
 * @author modia9548
 */
public class Key extends Items{
    Player player;
    private boolean unlock;
    
    public Key(String name){
        super(name);
    }
    
    //if key is equipped, door is now unlocked
    public void Open(){
        if(unlock == true){
            // door is locked or unlocked is next 
            
        }
    }
}
