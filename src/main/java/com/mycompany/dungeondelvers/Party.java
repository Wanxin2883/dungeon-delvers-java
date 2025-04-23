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

public class Party {
    private Adventurer[] adventurers;

    public Party() {
        this.adventurers = new Adventurer[4];
    }
    
    public boolean addAdventurer(Adventurer adventurer){
        for (int i = 0; i < this.adventurers.length; i++){
            if (this.adventurers[i] == null){
                this.adventurers[i] = adventurer; 
                return true; 
            }
        }
        return false; 
    }
    
    public void removeAdventurer(int index1) {
        if (index1 >= 0 && index1 < this.adventurers.length && this.adventurers[index1] != null) {
            // Set the element at the specified index to null
            this.adventurers[index1] = null;
        
            // Create a new array with size one less than the original array
            Adventurer[] updateArr = new Adventurer[this.adventurers.length];
            
            // Initialize a variable to keep track of the index in the new array
            int j = 0; 

            // Loop through the original array and copy non-null elements to the new array
            for (int i = 0; i < this.adventurers.length; i++) {
                if (this.adventurers[i] != null) {
                    updateArr[j] = this.adventurers[i];
                    j++;
                }
            }
            this.adventurers = updateArr; // Replace the original array with the new array
            System.out.println("Removed Successfully!"); 
        }
        else{
            System.out.println("This Adventurer does not exist.");
        }
    }
    
    //Give a weapon to the adventurer when the user purchased a weapon in the merchant class
    public void giveWeapon(Weapon weapon, int index2) {
        this.adventurers[index2].setWeap(weapon);
    }
    
    //Damage to the adventurer after monster attack 
    public void dealDamageTo (int index3, int damage) {
        Adventurer advent = this.adventurers[index3];
        advent.setLife((advent.getLife()- damage));
    }
    
    @Override
    public String toString(){
        String temp = ""; 
        for (int i = 0; i < this.adventurers.length; i++) {
            if (this.adventurers[i] != null){
                temp += this.adventurers[i].toString() + "\n"; 
            } 
        }
        return temp; 
    }
    
    //Additional Method to return a collection of adventurers
    public Adventurer[] getAdventurer(){
        return this.adventurers; 
    }
    
    //Additional Method to count Null Adventurers (i.e Dead Adventurers)
    public int checkNullAdventurers(){
        int count1 = 0; 
        for (int i = 0; i < this.adventurers.length; i++){
            if (this.adventurers[i] == null){
                count1++;
            }
        }
        return count1; 
    }
    
    //Additional Method to give random weapon to the adventurer once we created the adventurer 
    public void assignWeapon(){
        Random rand = new Random(); 
        int index2 = rand.nextInt(3);
        for (int i = 0; i < this.adventurers.length; i++){
            if (adventurers[index2] == null){
                index2 = rand.nextInt(3);
            } else{
                this.adventurers[index2].setWeap(Weapon.generateRandomWeapon());
            }
        }
    }
}
