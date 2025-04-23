/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dungeondelvers;
import java.util.Scanner; 

/**
 * Student ID: B2200273 & B2101241 
 * Student Name: Zoya Khan & Cheah Wan Xin
 * Date: 7 April 2023
 */

public class DungeonDelvers {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in); 
        
        int choice; 
        int floorNum = 0; 
        
        System.out.print("Enter the Number of Levels you wish to have : ");
        int totalFloor = input.nextInt(); 
        
        Dungeon dungeon = new Dungeon(totalFloor+1); 
        Party party = new Party(); 
        Merchant merchant = new Merchant(); 
        String str = "Enter the dungeon"; 
        
        // MENU LOOP 
        do{
            System.out.printf("""
                              \n                 Select an option below: 
                                                  1. Create an Adventurer 
                                                  2. Remove an Adventurer 
                                                  3. View Party
                                                  4. Visit Merchant
                                                  5. %s
                                                  6. Exit Game 
                              
                               Enter your choice:      """,  str);
            choice = input.nextInt(); 
            input.nextLine(); 
            System.out.println(); 
            
            if (choice == 1){
                System.out.print("Enter adventurer's name: ");
                String name = input.nextLine(); 
                System.out.print("Enter adventurer's gender: ");
                char gender = input.next().charAt(0); 

                if (party.addAdventurer(new Adventurer(name, gender))){
                    System.out.println("Added Successfully!");
                } else{
                    System.out.println("Container is FULL! Unable to Add New Adventurers.");
                } 
                party.assignWeapon();
            }
            else if (choice == 2){
                System.out.print("Which adventurer would you like to remove? \n");
                System.out.print(party.toString()); 
                System.out.print("\nEnter your choice (from 1 - 4): "); 
                int choice2 = input.nextInt(); 
                party.removeAdventurer((choice2)-1);
            }
            else if (choice == 3){
                System.out.println(party.toString());
            }
            else if (choice == 4){
                if (!merchant.hasWeapons()) {
                     System.out.println("Sorry! The Merchant is all sold out!");
                     continue; 
                }
                Merchant.purchaseWeapon(party, merchant); //Additional Method in Merchant class 
            }
            else if (choice == 5){
                int temp = dungeon.continueDungeon(party, dungeon, totalFloor, floorNum); //Additional Method in Dungeon class
                if (temp == -1){
                    break;
                }
                floorNum = temp;
                str = "Continue down the dungeon"; 
            }
            else if (choice == 6){
                break;
            }
            else{
                System.out.println("Invalid Input. Please Try Again!");
            }
        }while (choice != 6); 
        
        System.out.println("********************************* End of the Game ********************************** \n");
        System.out.print(dungeon.endFloor(floorNum, totalFloor));
        System.out.printf("\nParty's Gold : %d$ \n ", Adventurer.getGold()); 
        System.out.println("\n What a Great battle ! Hope to see you guys on another adventure soon.. FAREWELL !  ");
    }
}