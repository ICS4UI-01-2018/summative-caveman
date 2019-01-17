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
    public boolean collide;
    public boolean dead;
    Player player;
    public boolean attack;
    public boolean tracking;
    public boolean upAllowed;
    public boolean leftAllowed;
    public boolean rightAllowed;
    public boolean downAllowed;
    //public Direction direction;

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

    public void move() {

    }

    public void health() {

    }

    public void changeUpAllowed(boolean upAllowed) {
        this.upAllowed = upAllowed;
    }

    public void changeLeftAllowed(boolean leftAllowed) {
        this.leftAllowed = leftAllowed;
    }

    public void changeRightAllowed(boolean rightAllowed) {
        this.rightAllowed = rightAllowed;
    }

    public void changeDownAllowed(boolean downAllowed) {
        this.downAllowed = downAllowed;
    }

    public boolean getUpAllowed() {
        return upAllowed;
    }

    public boolean getLeftAllowed() {
        return leftAllowed;
    }

    public boolean getRightAllowed() {
        return rightAllowed;
    }

    public boolean getDownAllowed() {
        return downAllowed;
    }

    /**
     *
     * @param player tracks the player's movement
     */
    public void trackPlayer(Player player) {

        float playX = player.getPlayerX() + player.getBounds().width / 2;
        float playY = player.getPlayerY() + player.getBounds().height / 2;

        float distanceSQ = (this.enemy.x + 10 - playX) * (this.enemy.x + 10 - playX) + (this.enemy.y + 10 - playY) * (this.enemy.y + 10 - playY);
        if (distanceSQ > 300 * 300) {
            System.out.println("Not close enough " + distanceSQ);
            return;
        }
        // if the enemy is not dead, follow the player up to their range times 3
        if (dead == false) {

            if (enemy.x + 10 > playX && leftAllowed) {
                // they follow using their x or y position modified by their speed stat
                // their direction updates too so they can attack accurately
                enemy.x = enemy.x - speed;
                //direction = Direction.LEFT;
            } else if (enemy.x + 10 < playX && rightAllowed) {
                enemy.x = enemy.x + speed;
                // direction = Direction.RIGHT;
            } else {
                enemy.x = enemy.x;
                //direction = direction;
            }
            if (enemy.y + 10 > playY && downAllowed) {
                enemy.y = enemy.y - speed;
                //   direction = Direction.DOWN;
            } else if (enemy.y + 10 < playY && upAllowed) {
                enemy.y = enemy.y + speed;
                //     direction = Direction.UP;
            } else {
                enemy.y = enemy.y;
                //direction = direction; 
            }

        }
    }

    /**
     *
     * @return where the player is if in range
     */
    public boolean track() {
        return tracking == true;
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
        }
    }

    /**
     *
     * @return if the enemy has died
     */
    public boolean hasDied() {
        return dead == true;
    }

    /**
     *
     * @param damage is how much the enemy takes away health
     * @param attackRange is how far the enemy can attack
     * @param player tracks the player's actions
     */
    public void attack(int damage, int attackRange, Player player) {
        // if they are in range to attack, deal damage on a timer
        if (attack == true) {
            if (player.x <= this.getEnemyX() + attackRange && player.x >= this.getEnemyX() - attackRange) {
                if (player.y <= this.getEnemyY() + attackRange && player.y >= this.getEnemyY() - attackRange) {
                    player.health = player.health - damage;
                    attack = false;
                }
            }
        }
    }

    /**
     *
     * @return if the enemy is attacking or not
     */
    public boolean attacking() {
        return attack == true;
    }

    public Rectangle getBounds() {
        return enemy;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getDamage() {
        return damage;
    }

    public boolean collidesWith(Rectangle rect) {
        return enemy.overlaps(rect);
    }
}
