/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dungeondelvers;
import java.util.Random; 
import java.util.Scanner; 

/**
 * Student ID: B2200273 & B2101241 
 * Student Name: Zoya Khan & Cheah Wan Xin 
 * Date: 7 April 2023
 */

public class Dungeon {
    private Monster[] monsters; 
    
    public Dungeon(int totalFloor){
        this.monsters = new Monster[totalFloor]; 
        for (int i = 0; i < monsters.length; i++){
            if (i%2 == 1){
                this.monsters[i] = new Goblin((i*10), i, (i*20), (int)(Math.round((i/3)+1)));
            } else{
                this.monsters[i] = new Thief((i*10), i, (i*20), (i*2)); 
            }
        }
    }
    
    public String currentFloor(){ 
        int count = 0; 
            for(int i = 0; i < monsters.length; i++){
                if (this.monsters[i].getLife() == 0){
                    count++; 
                }
            }
        return "You are currently at floor " + count; 
    }
    
    //Additional Method to display the current floor at the end of the game 
    public String endFloor(int floorNum , int totalFloor){ 
        int count = 0; 
        
        //Displays Winning Floor which is one less than the current floor 
        if ((floorNum-1) == totalFloor){
            for(int i = 0; i < monsters.length; i++){
                if (this.monsters[i].getLife() == 0){
                    count++; 
                }
            }
        return "You are currently at floor " + (count - 1); 
        }
        
        //Displays Losing Floor which is same as the current floor 
        else {
            return currentFloor();
        }
    }
    
    //Additional Method for option 5 in main class
    public int continueDungeon(Party party, Dungeon dungeon, int totalFloor, int floorNum){
        Scanner input = new Scanner (System.in);
        Random random = new Random(); 
        Adventurer[] adventurers = party.getAdventurer();
        
        if (party.checkNullAdventurers() == 4){
            System.out.println("Sorry you CAN'T fight! There are no Adventurers added!"); 
            return floorNum; 
        }
        
        System.out.printf("""
                                \t\t**********************************
                                    \t\t      WELCOME TO THE DUNGEON
                                      \t\t        Get Ready To Fight!
                                            \t\t      Floor %d
                                \t\t**********************************  \n\n""", floorNum);
        if(floorNum == 0){
            System.out.println("Monster in Floor 0 has 0 HP. You are free to bribe or attack the monster!\n");
        }
        
        System.out.print("""
                           Do you want to ATTACK (1) or BRIBE (2) the Monster? 
                           Enter your choice:  """);
        int choice5 = input.nextInt(); 

        if (choice5 == 1){ 
            
            //attack from the adventurer to the monster
            System.out.println();
             
            for (int i = 0; i < adventurers.length; i++){
                
                if (adventurers[i] != null && this.monsters[floorNum].getLife() > 0){

                   System.out.printf("%s has attacked the Monster with bonus damage of %s.\n", adventurers[i].getName(), adventurers[i].bonusDamage());

                    this.monsters[floorNum].setLife(this.monsters[floorNum].getLife() - adventurers[i].attack());

                    if(this.monsters[floorNum].getLife() < 0){
                        this.monsters[floorNum].setLife(0); 
                    }
                    
                    System.out.println( " --- " + this.monsters[floorNum].toString() + " --- " );
                }
            }

            //When monster is defeated 
            if (this.monsters[floorNum].getLife() == 0){
                System.out.println("\nCongrats! The Monster is defeated!");
                Adventurer.setGold((Adventurer.getGold())+(this.monsters[floorNum].getGold()));
                floorNum++;
            }

            //When moster still alive
            else{
                System.out.println("\nMonster is ready to attack NOW!!");
                System.out.println("     TAKE COVER!!   \n ");

                //Monster attacks the adventurer 
                int num = random.nextInt(4); // choose random adventurer to attack
                while(true){
                    if(adventurers[num] != null){
                        
                        // NORMAL ATTACK
                        party.dealDamageTo(num, this.monsters[floorNum].getAttack());
                        if (adventurers[num].getLife() == 0){
                            System.out.printf(" --- %s is defeated by the Monster! --- \n", adventurers[num].getName());
                            adventurers[num] = null;
                        } else{
                            System.out.printf(" --- Life of %s is reduced by %d  --- \n", adventurers[num].getName(), this.monsters[floorNum].getAttack());
                            
                            // SPECIAL ATTACK
                            if (Math.random() <= 0.1) { //10% chance of special attack to execute
                              Monster currentMonster = this.monsters[floorNum];

                            //Checks if the instance in the array is Goblin or Thief 
                                //If Goblin
                                if (currentMonster instanceof Goblin) {
                                    System.out.print("\nOH NO..! Goblin will now unleash its Special Attack. \n");

                                    //Initiate Goblin class special attack  
                                    int damage = ((Goblin) currentMonster).specialAttack(floorNum);
                                    
                                    System.out.printf(" --- Goblin has attacked each Adventurer with %d Anger ! --- \n", damage);

                                    //Each adventurer's life reduced !
                                    for (int j = 0; j < adventurers.length; j++){
                                        if (adventurers[j] != null){
                                            adventurers[j].setLife(adventurers[j].getLife() - damage);
                                            
                                            //If adventurer gets killed by Special Attack
                                            if (adventurers[j].getLife() == 0){
                                                System.out.printf(" --- %s is defeated by the Goblin! --- \n", adventurers[j].getName());
                                                adventurers[j] = null;
                                            }
                                            //Adventurer survive from special attack, life reduced 
                                            else{
                                                System.out.printf(" --- Current Life of %s is %d  --- \n", adventurers[j].getName(), adventurers[j].getLife());
                                            }
                                        }
                                    }
                                } 
                                    
                                //If Thief
                                else if (currentMonster instanceof Thief){
                                    System.out.print("\nOH NO..! Thief will now unleash its Special Attack. \n");

                                    //Initiate Thief class special attack
                                    int steal = ((Thief) currentMonster).specialAttack(floorNum);
                                    Adventurer.setGold(Adventurer.getGold() - steal);

                                    ((Thief) currentMonster).setGold(((Thief) currentMonster).getGold() + steal);
                                    System.out.printf("--- Thief has Stolen %d $ Gold from the Party ---- \n", steal);

                                    //Check if gold is 0
                                    if(Adventurer.getGold() == 0){   
                                        System.out.println("--- BEWARE.. Remaining Party Gold is 0 --- ");  
                                    }
                                    else{
                                        System.out.printf("--- Remaining Party Gold :  %d $  --- \n ", Adventurer.getGold());
                                    }
                                } 
                            }
                        }
                        break;       
                    }
                    //Assign random adventurer if one of it is null 
                    num = random.nextInt(4);
                }
                
                //check the adventurer is all killed or not 
                if (party.checkNullAdventurers() == 4){
                    System.out.println("\nAll the Adventurers are defeated by the Monsters. ");
                    System.out.println("    ~ YOU LOSE!! ~    \n");
                    return -1; 
                }
            }
        }
    
        //When the adventurer choose to bribe the monsters 
        else if (choice5 == 2){
            int newGold = (Adventurer.getGold())-(15*(floorNum));
            if (Adventurer.getGold() > 15*(floorNum)){
                Adventurer.setGold(newGold);
                System.out.println("Bribed Successfully!");
                System.out.printf("   --- Current Party's Gold: %d$ ---\n", Adventurer.getGold());
                this.monsters[floorNum].setLife(0); 
                floorNum++; 
            } else{
                //If there is not enough gold, then can't bribe the monster
                System.out.println("Sorry, you can't bribe the Monster!");  
            }
        }
        
        else{
            System.out.println("Invalid Input. Please Try Again!");
        }
        
        //Check whether all the floor are cleared 
        if ((floorNum-1) == totalFloor){
            System.out.println("All the Monsters are defeated!");
            System.out.println("     ~ YOU WIN !! ~  \n ");
            return -1; 
        }
        return floorNum; 
    }
}