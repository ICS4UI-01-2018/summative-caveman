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
public abstract class Items {
    private int damage;
    private int range;
    private String name;
    
    
    public Items(int effect, int range, String name){
        this.damage = damage;
        this.range = range;
        this.name = name;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
    public int getRange(){
        return this.range;
    }
    
    public String getName(){
        return this.name;
    }
    
      
    
    
}
