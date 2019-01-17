/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.badlogic.gdx.math.Rectangle;
import com.sun.javafx.scene.traversal.Direction;

/**
 *
 * @author choij2116
 * @author modia9548
 * @author tarra7926
 * @author macdn5071
 */
public class Bullet {

    private Direction direction;
    //private Rectangle proj;
    private final float speed = 5;
    private float x;
    private float y;
    Enemy enemy;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void shoot(Direction direction) {
        this.direction = direction;
    }

    public void moveInDirection() {
        x += speed;
        y += speed;
    }
    
    //public boolean collison(Rectangle proj){
    //    return Bullet.overlaps();
    //}
}
