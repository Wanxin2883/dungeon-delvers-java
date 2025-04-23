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

public class Goblin extends Monster{
    private int anger; 
    
    public Goblin(int life, int attack, int gold, int anger) {
        this.life = life;  
        this.attack = attack ; 
        this.gold = gold;
        this.anger = anger;
    }
    
    //Abstract method from the Monster class 
    @Override
    public int specialAttack(int monsterLevel){
        return this.anger; 
    }

    public int getAnger() {
        return anger;
    }

    public void setAnger(int anger) {
        this.anger = anger;
    }
    
    @Override 
    public String toString(){
        return "Goblin currently has " + this.life + " HP, and an anger of " + this.anger; 
    }
}
