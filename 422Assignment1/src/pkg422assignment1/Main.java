/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg422assignment1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author alexa
 */
public class Main {

    /**
     * @param args the command line arguments
    */
    public static ArrayList<Pet> petList = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
                
        System.out.println("Pet Database Program");
        menuOptions();
        
    }
    
    public static void menuOptions() {
        Scanner choice = new Scanner(System.in);
        
        System.out.println("What would you like to do?");
        
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Update an existing pet");
        System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program");
        System.out.println("Your Choice: ");  
        
        int menu = choice.nextInt();
        switch (menu) {
            case 1:
                viewPets();
                break;
            case 2:
                addPet();
                break;
            case 3:
                //updatePet();
                break;
            case 4: 
                //removePet();
                break;
            case 5:
                //searchName();
                break;
            case 6:
               // searchAge();
                break;
            case 7:
                break;
        }
    }   
    
    
    public static void viewPets() {
        
        System.out.println("+---------------------+");
        System.out.printf("|%-3s", " ID ");
        System.out.printf("|%-10s", " NAME ");
        System.out.printf("|%-4s", " AGE ");
        System.out.print("|\n");
        System.out.println("+---------------------+");
        
        for (int i = 0; i < petList.size(); i++) {
            System.out.printf("|%3d" , i);
            System.out.print(" | ");
            System.out.printf("%-9s", petList.get(i).getName());
            System.out.printf("|%4d", petList.get(i).getAge());
            System.out.print(" |\n");
        }
        System.out.println("+---------------------+");
        System.out.println(petList.size() + " rows in set.\n");
    }
    
    public static void addPet() {
        Scanner amount = new Scanner(System.in);
        int i = 0;
        
        System.out.println("How many pets do you want to add?");
        int amountNum = amount.nextInt();
        
        while(true) {
            if (petList.size() < amountNum) {
                System.out.print("Add pet (name, age): ");
                Scanner data = new Scanner(System.in);
                String petData = data.nextLine();
                
                if (petData.toLowerCase().equals("done")) {
                    if(i == 1) {
                        System.out.println(i + " pet added.");
                    }
                    else {
                        System.out.println(i + " petss added.");
                    }
                    break;
                }                
                else {
                    String[] splitData = petData.split(" ");
                    if (splitData.length == 2) {
                        int age = Integer.parseInt(splitData[1]);
                        Pet newPet = new Pet(splitData[0], age);
                        petList.add(newPet);
                        i++;                       
                    }
                }
            }
        }
    }
}
