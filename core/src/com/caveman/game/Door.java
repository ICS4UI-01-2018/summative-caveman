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
public class Door extends Wall {

    private Rectangle door;
    private int colourNum;

    /**
     *
     * @param x the x position of the door
     * @param y the y position of the door
     * @param width the width of the door
     * @param height the height of the door
     * @param colourNum the number to determine what colour the door should be
     */
    public Door(float x, float y, int width, int height, int colourNum) {
        super(x, y, width, height, colourNum);
        door = super.getBounds();

    }

    /**
     * a method to unlock the door which blocks player by making height and
     * width as 0, remove the door.
     */
    public void unlock() {
        door.height = 0;
        door.width = 0;
        super.updateBounds(door);
    }
}
