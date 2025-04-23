/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;

/**
 * Student ID: B2101241 & B2200273
 * Student Name: Cheah Wan Xin & Zoya Khan 
 * Date: 7 April 2023
 */

public abstract class Monster {
    protected  int life; 
    protected int attack; 
    protected int gold;

    public Monster () {
        
    }
    
    public Monster(int life, int attack, int gold ){
        this.life = life;  
        this.attack = attack;
        this.gold = gold; 
    }
    
    //Abstract method 
    public abstract int specialAttack(int monsterLevel);
    
    public void setLife(int life) {
        if (this.life <= 0){
            this.life = 0; 
        } else{
            this.life = life;
        }
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLife() {
        return life;
    }
    
    public int getAttack() {
        return attack;
    }
    
    public int getGold() {
        return gold;
    }
    
    public String toString(){
        return "Monster currently has " + this.life + "HP."; 
    } 
}