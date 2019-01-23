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

    private boolean Attack;
    private Rectangle sword;
    private int range;
    private int sPos;

    /**
     * Refer to Items
     *
     * @param effect
     * @param range that player can attack
     * @param name of item == sword
     */
    public Sword(int effect, String name, float x, float y, int width, int height, int range) {

        sword = new Rectangle(x, y, width, height);
        this.range = range;

    }

    /**
     * if the player try to execute to attack enemy(== when attack key pressed),
     * it is executed when the enemy is within the attack range. When the player
     * successfully attack the enemy, the enemy's health is decreased by 100 hp.
     * Then, by making boolean attack = false, make it to attack the enemy only
     * once at a time.
     */
    public void Attack() {
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

    public int sPos() {
        return sPos;
    }

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

    public Rectangle getBounds() {
        return sword;
    }

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
