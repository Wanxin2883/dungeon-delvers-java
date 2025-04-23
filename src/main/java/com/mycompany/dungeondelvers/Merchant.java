/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;
import java.util.Scanner; 

/**
 * Student ID: B2101241 & B2200273
 * Student Name: Cheah Wan Xin & Zoya Khan 
 * Date: 7 April 2023
 */

public class Merchant {
    private Weapon[] weapons;

    public Merchant() {
        weapons = new Weapon[5];
        for (int i = 0; i < this.weapons.length; i++) {
            this.weapons[i] = Weapon.generateRandomWeapon();
        }
    }
    
    public Weapon sellWeapon(int partyGold, int index) { 
        if (index < 0 || index > this.weapons.length || this.weapons[index] == null) {
            return null; // invalid index or no weapon at that index
        }
        
        if (partyGold < this.weapons[index].getPrice()) {
            return null; // not enough gold
        }
        
        Adventurer.setGold(partyGold-(this.weapons[index].getPrice()));
        Weapon weaponToSell = this.weapons[index];
        this.weapons[index] = null;
        return weaponToSell;
    }
    
    public boolean hasWeapons() {
        for (int i = 0; i < this.weapons.length; i++) {
            if (this.weapons[i] != null) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        String output = "The Merchant has the following wares:\n";
        for (int i = 0; i < this.weapons.length; i++) {
            if (this.weapons[i] != null) {
                Weapon weapon = this.weapons[i];
                output += "Weapon " + (i + 1) + " (" + weapon.getPrice() + ") : " + weapon.getName() + " with " + weapon.getDamage() + " base damage.\n";
            }
        }
        return output;
    }
    
    //Additional Method for option 4 in main menu 
    public static void purchaseWeapon(Party party, Merchant merchant) {
        //assume that user input a valid adventurers & weapon number 
        Scanner input = new Scanner(System.in);
        System.out.println("Which weapon would you like to purchase? ");
        System.out.println(merchant.toString());
        System.out.print("Enter your choice: "); 
        int choice3 = input.nextInt(); 

        if (choice3 >= 1 && choice3 <= 5){
            Weapon weapon = merchant.sellWeapon(Adventurer.getGold(), (choice3-1));
            if (weapon == null){
                System.out.println("Unable to Purchase Weapon. Please Try Again!");
            } else{
                System.out.println("\nWhich Adventurer will carry the purchased weapon? "); 
                System.out.println(party.toString());
                System.out.print("Enter your choice (from 1 - 4): "); 
                int choice4 = input.nextInt();

                party.giveWeapon(weapon, (choice4-1));
                System.out.println("\nPurchased Successfully!");
                System.out.printf("Remaining Party's Gold: %d$\n", Adventurer.getGold());
            }
        } else{
            System.out.println("Unable to Purchase Weapon. Please Try Again!");
        }
    } 
}
