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
public class Items {

    private int effect;
    private String name;
    private float x;
    private float y;
    
    public Items(int effect, String name){
        this.effect = effect;
        
        this.name = name;
    }

    public int getEffect() {
        return this.effect;
    }

    public String getName() {
        return this.name;
    }

    public Items CreateNew(float x, float y){
        Items i = new Items(effect, name);
        i.setPosition(x, y);
        return i;
    }
    
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
}
