/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;
import java.util.Random;

/**
 * Student ID: B2101241 & B2200273
 * Student Name: Cheah Wan Xin & Zoya Khan 
 * Date: 7 April 2023
 */

public class Weapon {
    private String name; 
    private int damage; 
    private int price;  
    
    public Weapon (String name, int damage, int price) {
        this.name = name; 
        this.damage = damage; 
        this.price = price; 
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public static Weapon generateRandomWeapon() {
        Random rand = new Random();
        
        String[] weaponNames = {"Shortsword", "Broadsword", "Mithril sword", "Plain Wand", "Embellished Wand", "Wand of Death" ,"Spiked Mace", "Warhammer"};
        int nameIndex = rand.nextInt(weaponNames.length);
        String name = weaponNames[nameIndex];
        
        int[] baseDamage = {4, 8, 12, 2, 5, 10, 3, 6} ;
        int damage = baseDamage[nameIndex];
        
        int[] weaponPrices = {10, 15, 22, 8, 12, 20, 8, 16};
        int price = weaponPrices[nameIndex];
        
        return new Weapon(name, damage, price);
    }
}
