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
    private float x;
    private float y;
    private Rectangle item;

    /**
     *
     * @param effect used to differentiate between different types of similar
     * items
     * @param x the x position of the item
     * @param y the y position of the item
     * @param width the width of the item
     * @param height the height of the item
     */
    public Items(int effect, float x, float y, int width, int height) {
        this.effect = effect;
        this.x = x;
        this.y = y;
        item = new Rectangle(x, y, width, height);

    }

    /**
     * get the effect integer
     *
     * @return the effect integer
     */
    public int getEffect() {
        return this.effect;
    }

    /**
     * get the item rectangle
     *
     * @return the item rectangle
     */
    public Rectangle getBounds() {
        return item;
    }

}
