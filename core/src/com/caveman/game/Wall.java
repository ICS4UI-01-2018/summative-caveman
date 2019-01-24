/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * The Wall class
 *
 * @author tarra7926
 */
public class Wall {

    private Rectangle Wall;
    private int colourNum;

    /**
     *
     * @param x the x position of the wall
     * @param y the y position of the wall
     * @param width the width of the wall
     * @param height the height of the wall
     * @param colourNum the number to determine what colour the wall should be
     */
    public Wall(float x, float y, int width, int height, int colourNum) {
        Wall = new Rectangle(x, y, width, height);
        this.colourNum = colourNum;
    }

    /**
     * get the wall rectangle
     *
     * @return the wall rectangle
     */
    public Rectangle getBounds() {
        return Wall;
    }

    /**
     * update the wall rectangle
     *
     * @param rect the walls updated measurements
     */
    public void updateBounds(Rectangle rect) {
        Wall = rect;
    }

    /**
     *
     * @return the colourNum
     */
    public int getColourNum() {
        return colourNum;
    }
}
