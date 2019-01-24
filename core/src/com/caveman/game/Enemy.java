/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
//import com.sun.javafx.scene.traversal.Direction;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Enemy {

    float xPos;
    float yPos;
    private Rectangle enemy;
    public int health;
    public int damage;
    public int speed;
    public int attackRange;
    public boolean dead;
    public boolean upAllowed;
    public boolean leftAllowed;
    public boolean rightAllowed;
    public boolean downAllowed;

    /**
     *
     * @param x controls x position
     * @param y controls y position
     * @param health tracks current enemy health
     * @param damage is how much the enemy takes away health
     * @param speed is how fast the enemy moves
     * @param attackRange is how far the enemy can attack
     * @param width how wide the enemy is
     * @param height how tall the enemy is
     */
    public Enemy(float x, float y, int health, int damage, int speed, int attackRange, int width, int height) {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.attackRange = attackRange;
        enemy = new Rectangle(xPos, yPos, width, height);
    }

    /**
     *
     * @return enemy X position
     */
    public float getEnemyX() {
        return enemy.x;
    }

    /**
     *
     * @return enemy Y position
     */
    public float getEnemyY() {
        return enemy.y;
    }

    /**
     * get the health integer
     *
     * @return the health integer
     */
    public int getEnemyHealth() {
        return health;
    }

    /**
     * change the upAllowed variable
     *
     * @param upAllowed what we are changing the variable to
     */
    public void changeUpAllowed(boolean upAllowed) {
        this.upAllowed = upAllowed;
    }

    /**
     * change the leftAllowed variable
     *
     * @param leftAllowed what we are changing the variable to
     */
    public void changeLeftAllowed(boolean leftAllowed) {
        this.leftAllowed = leftAllowed;
    }

    /**
     * change the rightAllowed variable
     *
     * @param rightAllowed what we are changing the variable to
     */
    public void changeRightAllowed(boolean rightAllowed) {
        this.rightAllowed = rightAllowed;
    }

    /**
     * change the downAllowed variable
     *
     * @param downAllowed what we are changing the variable to
     */
    public void changeDownAllowed(boolean downAllowed) {
        this.downAllowed = downAllowed;
    }

    /**
     * get the upAllowed Boolean
     *
     * @return the upAllowed boolean
     */
    public boolean getUpAllowed() {
        return upAllowed;
    }

    /**
     * get the leftAllowed Boolean
     *
     * @return the leftAllowed boolean
     */
    public boolean getLeftAllowed() {
        return leftAllowed;
    }

    /**
     * get the rightAllowed Boolean
     *
     * @return the rightAllowed boolean
     */
    public boolean getRightAllowed() {
        return rightAllowed;
    }

    /**
     * get the downAllowed Boolean
     *
     * @return the downAllowed boolean
     */
    public boolean getDownAllowed() {
        return downAllowed;
    }

    /**
     * has the enemy track the enemy player while in range
     *
     * @param player the player the enemy will be tracking
     */
    public void trackPlayer(Player player) {

        float playX = player.getPlayerX() + player.getBounds().width / 2;
        float playY = player.getPlayerY() + player.getBounds().height / 2;

        float distanceSQ = (this.enemy.x + 10 - playX) * (this.enemy.x + 10 - playX) + (this.enemy.y + 10 - playY) * (this.enemy.y + 10 - playY);
        if (distanceSQ > 300 * 300) {
            return;
        }

        if (dead == false) {
            if (enemy.x + 10 > playX && leftAllowed) {
                enemy.x = enemy.x - speed;

            } else if (enemy.x + 10 < playX && rightAllowed) {
                enemy.x = enemy.x + speed;

            } else {
                enemy.x = enemy.x;

            }
            if (enemy.y + 10 > playY && downAllowed) {
                enemy.y = enemy.y - speed;

            } else if (enemy.y + 10 < playY && upAllowed) {
                enemy.y = enemy.y + speed;

            } else {
                enemy.y = enemy.y;
            }
        }
    }

    /**
     *
     * @param shapeBatch
     */
    public void draw(ShapeRenderer shapeBatch) {
        shapeBatch.rect(enemy.x, enemy.y, enemy.width, enemy.height);
    }

    /**
     * tells the game if the enemy is dead
     */
    public void dying() {
        if (health <= 0) {
            dead = true;
            enemy.width = 0;
            enemy.height = 0;
        }
    }

    /**
     *
     * @return if the enemy has died
     */
    public boolean hasDied() {
        return dead;
    }

    /**
     * get the enemy rectangle
     *
     * @return the enemy rectangle
     */
    public Rectangle getBounds() {
        return enemy;
    }

    /**
     * get the attack range
     *
     * @return the attackRagne integer
     */
    public int getAttackRange() {
        return attackRange;
    }

    /**
     * get the damage
     *
     * @return the damage integer
     */
    public int getDamage() {
        return damage;
    }

    /**
     * check whether the rectangle overlaps with the enemy or not
     *
     * @param rect the rectangle we will be checking
     * @return the overlap boolean
     */
    public boolean collidesWith(Rectangle rect) {
        return enemy.overlaps(rect);
    }
}
