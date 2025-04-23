/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;
import java.util.Random;

/*
 * Student ID: B2101241 & B2200273
 * Student Name: Cheah Wan Xin & Zoya Khan 
 * Date: 7 April 2023
 */

public class Adventurer {
    private final String name;
    private final char gender;
    private final int str;
    private int life;
    private final int wis;
    private Weapon weap;
    private static int gold = 50;

    
    public Adventurer(String name, char gender) {
        this.name = name;
        this.gender = gender;
        
        Random rand = new Random();
        this.str = rand.nextInt(16) + 3;
        this.life = rand.nextInt(16) + 3;
        this.wis = rand.nextInt(16) + 3;
        this.weap = null;
    }
    
    
    //Additional Method to get bonus damage 
    public int bonusDamage(){
        if (this.weap != null) {
            if (this.weap.getName().contains("sword") && this.str >= 14) {
                return str;
            } else if (this.weap.getName().contains("Wand") && this.wis >= 10) {
                return (int) (this.wis * 1.5);
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }
   
    //Calculating total damage by weapons name     
    public int attack() {
        if (this.weap != null) {
            if (this.weap.getName().contains("sword") && this.str >= 14) {
                return this.weap.getDamage() + str;
            } else if (this.weap.getName().contains("Wand") && this.wis >= 10) {
                return (int) (this.weap.getDamage() + this.wis * 1.5);
            } else {
                return this.weap.getDamage();
            }
        } else {
            return 1;
        }
    }

    //Validation to keep adventuters life <= 0 
    public void setLife(int life) {
        if (life < 0) {
            this.life = 0;
        } else {
            this.life = life;
        }
    }

    public void setWeap(Weapon weap) {
        this.weap = weap;
    }

    public static void setGold(int gold) {
        if (gold < 0) {
            Adventurer.gold = 0;
        } else{
            Adventurer.gold = gold;
        }
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return this.gender;
    }

    public int getStr() {
        return this.str;
    }

    public int getLife() {
        return this.life;
    }

    public int getWis() {
        return this.wis;
    }

    public Weapon getWeap() {
        return this.weap;
    }

    public static int getGold() {
        return gold;
    }
    
    //Additional Method to use in to string 
    public String heOrShe() {
        if (this.gender == 'F' || this.gender == 'f'){
            return "She";
        } else{
            return "He";
        }
    }

    @Override
    public String toString() {
        if (this.weap != null) {
            return this.name + " has " + this.life + " HP, " + this.str + " Strength, " + this.wis + " Wisdom. " + 
                   this.heOrShe() + " is carrying a " + this.weap.getName() + " that deals " + this.weap.getDamage() + " base damage.";
        } else {
            return this.name + " has " + this.life + " HP, " + this.str + " Strength, " + this.wis + " Wisdom. " +  
                   this.heOrShe() + " is not carrying a Weapon!";
        }
    }
}
