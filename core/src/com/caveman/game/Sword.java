/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Sword {

    private boolean attacking;
    private Rectangle sword;
    private int range;
    private int sPos;

    /**
     *
     * @param x the x position of the sword
     * @param y the y position of the sword
     * @param width the width of the sword
     * @param height the height of the sword
     * @param range the effective range of the sword
     */
    public Sword(float x, float y, int width, int height, int range) {

        sword = new Rectangle(x, y, width, height);
        this.range = range;

    }

    /**
     * sets the swords x and y coordinates into an attacking position
     */
    public void attack() {
        if (sPos == 0) {
            sword.x = sword.x + range;

        } else if (sPos == 90) {
            sword.y = sword.y + range;
        } else if (sPos == 180) {
            sword.x = sword.x - range;
        } else if (sPos == 270) {
            sword.y = sword.y - range;
        }
    }

    /**
     * change the attacking boolean
     *
     * @param i the boolean were going to change into
     */
    public void changeAttackStatus(boolean i) {
        attacking = i;
    }

    /**
     * get the attack status
     *
     * @return the attacking boolean
     */
    public boolean getAttackStatus() {
        return attacking;
    }

    /**
     * returns the sword into non-attacking position
     */
    public void sheath() {
        if (sPos == 0) {
            sword.x = sword.x - range;

        } else if (sPos == 90) {
            sword.y = sword.y - range;
        } else if (sPos == 180) {
            sword.x = sword.x + range;
        } else if (sPos == 270) {
            sword.y = sword.y + range;
        }
    }

    /**
     * get the sword rectangle
     *
     * @return the sword rectangle
     */
    public Rectangle getBounds() {
        return sword;
    }

    /**
     * change the swords rotation
     *
     * @param player the player the we are basing the position off of
     * @param dUp the up boolean of whether the player is facing that direction
     * @param dDown the down boolean of whether the player is facing that
     * direction
     * @param dLeft the left boolean of whether the player is facing that
     * direction
     * @param dRight the right boolean of whether the player is facing that
     * direction
     */
    public void repostion(Player player, boolean dUp, boolean dDown, boolean dLeft, boolean dRight) {
        if (dUp) {
            sword.x = player.getPlayerX() + player.getBounds().width - 19;
            sword.y = player.getPlayerY() + 10;
            sword.height = 50;
            sword.width = 15;
            sPos = 90;
        } else if (dLeft) {
            sword.x = player.getPlayerX() - 20;
            sword.y = player.getPlayerY() + player.getBounds().height - 15;
            sword.height = 15;
            sword.width = 50;
            sPos = 180;
        } else if (dDown) {
            sword.x = player.getPlayerX() + 4;
            sword.y = player.getPlayerY() - 20;
            sword.height = 50;
            sword.width = 15;
            sPos = 270;
        } else {
            sword.x = player.getPlayerX() + 10;
            sword.y = player.getPlayerY();
            sword.height = 15;
            sword.width = 50;
            sPos = 0;
        }
    }

}
