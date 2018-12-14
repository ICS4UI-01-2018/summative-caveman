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
public abstract class Items {
    private int effect;
    private String name;
    
    
    public Items(int effect, String name){
        
        this.effect = effect;
        
        this.name = name;
    }
    
    public int getEffect(){
        return this.effect;
    }
    
   
    public String getName(){
        return this.name;
    }
    
    
    
    
      
    
    
}
