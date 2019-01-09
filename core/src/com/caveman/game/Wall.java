/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author tarra7926
 */
public class Wall {
    private Rectangle Wall;
    private int colourNum;
    
    
    public Wall(float x, float y, int width, int height, int colourNum){
        Wall = new Rectangle(x, y, width, height);
        this.colourNum = colourNum;
    }
    
    
    public Rectangle getBounds(){
        return Wall;
    }
    public void updateBounds(Rectangle rect){
        Wall = rect;
    }
    public int getColourNum(){
        return colourNum;
    }
}
