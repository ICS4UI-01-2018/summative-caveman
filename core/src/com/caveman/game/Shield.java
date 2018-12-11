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
    
    private int range;
    Enemy enemy;
    
    public Shield(int effect, String name, int range){
        super(effect,name);
        this.range = range;
        
        if(enemy.attack == true){
            enemy.attack = false;
        }
    }
    
    public int getRange(){
        return this.range;
    }
}
