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
public class Sword{
    
    
    
    private boolean Attack;
    private Rectangle sword;
    
    /**
     * Refer to Items
     * @param effect 
     * @param range that player can attack 
     * @param name of item == sword
     */
    public Sword(int effect, String name, float x, float y, int width, int height){
        
        sword = new Rectangle( x, y,width, height);
        
    }
    
    /**
     * if the player try to execute to attack enemy(== when attack key pressed),
     * it is executed when the enemy is within the attack range. 
     * When the player successfully attack the enemy, the enemy's health is 
     * decreased by 100 hp. 
     * Then, by making boolean attack = false, make it to attack the enemy only once at a time. 
     */
    public void Attack(){ 
        
    }
    
    public Rectangle getBounds(){
        return sword;
    }
    
    
    public void repostion(Player player, boolean dUp, boolean dDown, boolean dLeft, boolean dRight){
        if(dUp){
            sword.x = player.getPlayerX() + player.getBounds().width - 19;
            sword.y = player.getPlayerY() + 10;
            sword.height = 50;
            sword.width = 15;
        }else if(dLeft){
            sword.x = player.getPlayerX() - 20;
            sword.y = player.getPlayerY() + player.getBounds().height - 15;
            sword.height = 15;
            sword.width = 50;
        }else if(dDown){
            sword.x = player.getPlayerX() + 4;
            sword.y = player.getPlayerY() - 20;
            sword.height = 50;
            sword.width = 15;
        }else{
            sword.x = player.getPlayerX() + 10;
            sword.y = player.getPlayerY();
            sword.height = 15;
            sword.width = 50;
        }
    }

}
