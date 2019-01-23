/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.math.Rectangle;

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
    private Rectangle item;
    
    public Items(int effect, String name, float x, float y, int width, int height){
        this.effect = effect;
        this.x = x;
        this.y = y;
        item = new Rectangle(x, y, width, height);
        this.name = name;
    }

    public int getEffect() {
        return this.effect;
    }

    public String getName() {
        return this.name;
    }
    
    /**
    *create x and y positions for items
    *set positions for the items
    */

    
    /**
     * create and set the position of new items 
     * @param x x-position of the new items will be located
     * @param y y-position of the new items will be located
     */
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    
    public Rectangle getBounds() {
        return item;
    }  
    
}
