/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;

/**
 * Student ID: B2101241 & B2200273
 * Student Name: Cheah Wan Xin 
 * Date: 7 April 2023
 */

public class Thief extends Monster{
    private int greed; 
    
    public Thief(int life, int attack, int gold, int greed) {
        this.life = life ;
        this.attack = attack; 
        this.gold = gold;
        this.greed = greed; 
    }
    
    //Abstract method from the Monster class
    @Override
    public int specialAttack(int monsterLevel){
        return this.greed; 
    }

    public int getGreed() {
        return greed;
    }

    public void setGreed(int greed) {
        this.greed = greed;
    }
    
    @Override
    public String toString(){
        return "Thief currently has " + this.life + " HP, and can steal " + this.greed + " gold from you!"; 
    }
}
