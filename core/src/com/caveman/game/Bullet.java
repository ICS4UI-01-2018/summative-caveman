/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveman.game;

import com.sun.javafx.scene.traversal.Direction;

/**
 *
 * @author macdn5071
 */
public class Bullet {
    private Direction direction;
    private float speed = 1.2f;
    private float x;
    private float y;
    
    public Bullet(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void shoot(Direction direction){
        this.direction = direction;
    }
    
    public void moveInDirection(){
        
    }
}