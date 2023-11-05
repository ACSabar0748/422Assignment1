/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg422assignment1;


import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author alexa
 */
public class Main {

    
    public static ArrayList<Pet> petList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        //This code is the beginning of the program and shows the main menu 
        System.out.println("Pet Database Program");
        menuOptions();
        
    }
    
    public static void menuOptions() {       
        
        //This code is the print showing the options for the program
        System.out.println("What would you like to do?");
        
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Update an existing pet");
        System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program");
        System.out.println("Your Choice: ");  
        
        //This is the input code, input 1-7 and depending on the input, a method is initialized

        int menu = scan.nextInt();
        switch (menu) {
            case 1:
                viewPets();
                break;
            case 2:
                addPet();
                break;
            case 3:
                updatePet();
                break;
            case 4: 
                removePet();
                break;
            case 5:
                searchName();
                break;
            case 6:
               searchAge();
               break;
            case 7:
                System.exit(0);
                break;
        }
    }   
    
    //This method displays all of the pets in the database
    public static void viewPets() {
        
        //This is the display for the Header in the list
        System.out.println("+---------------------+");
        System.out.printf("|%-3s", " ID ");
        System.out.printf("|%-10s", " NAME ");
        System.out.printf("|%-4s", " AGE ");
        System.out.print("|\n");
        System.out.println("+---------------------+");
        
        //This is the code for the individual
        for (int i = 0; i < petList.size(); i++) {
            System.out.printf("|%3d" , i);
            System.out.print(" | ");
            System.out.printf("%-9s", petList.get(i).getName());
            System.out.printf("|%4d", petList.get(i).getAge());
            System.out.print(" |\n");
        }
        System.out.println("+---------------------+");
        System.out.println(petList.size() + " rows in set.\n");
        menuOptions();
    }
    
    //This method adds a pet to the database
    public static void addPet() {

        int i = 0;
        
        System.out.println("How many pets do you want to add?");
        int amountNum = scan.nextInt();
        
        //While true the user can add a pet's name and age until they type "done"
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
        menuOptions();
    }
    
    //This method updates an existing pet data with new information after inputing the ID of the pet.
    public static void updatePet() {
        String originalName;
        int originalAge;
        
        viewPets();
        
        System.out.println("Enter the pet ID you want to update: ");
        int update = scan.nextInt();
        
        System.out.println("Enter new name and new age: ");
        String updatePetInfo = scan.nextLine();
        
        //The variables for the new data
        String newName = updatePetInfo.split("\\s+")[0];
        int newAge = Integer.parseInt(updatePetInfo.split("\\s+")[1]);
        
        //The varaibles for the old data
        originalName = petList.get(update).getName();
        originalAge = petList.get(update).getAge();
        
        //Updating the old pet with the new information
        petList.get(update).setName(newName);
        petList.get(update).setAge(newAge);
        
        System.out.println(originalName + " " + originalAge + " changed to " + newName + " " + newAge);  
        
        menuOptions();
    }
    
    //This method removes a pet in the database
    public static void removePet() {
        viewPets();
        System.out.println("Enter a pet ID to remove: ");
        int id = scan.nextInt();
        
        System.out.println(petList.get(id).getName() + " has been removed from the list");
        petList.remove(id);
        menuOptions(); 
    }
    
    //This method searches a name and displays pets based on if they contain the name
    public static void searchName() {      
        System.out.println("Enter name to search: ");
        String nameInput = scan.nextLine();
        
        //This is the display for the Header in the list
        System.out.println("+---------------------+");
        System.out.printf("|%-3s", " ID ");
        System.out.printf("|%-10s", " NAME ");
        System.out.printf("|%-4s", " AGE ");
        System.out.print("|\n");
        System.out.println("+---------------------+");
        
        //For loop that displays the searched name results
        for (Pet name : petList) { 
            String itemName = name.getName(); 
            if (itemName.contains(nameInput)) { 
                for (int i = 0; i < petList.size(); i++) {
                    System.out.printf("|%3d" , i);
                    System.out.print(" | ");
                    System.out.printf("%-9s", petList.get(i).getName());
                    System.out.printf("|%4d", petList.get(i).getAge());
                    System.out.print(" |\n");
                }
                System.out.println("+---------------------+");
            } 
        }
        menuOptions();
    }
    
    //This method searches a age and displays pets based on if they contain the age
    public static void searchAge() {
        System.out.println("Enter age to search: ");
        int ageInput = scan.nextInt();
        
        //This is the display for the Header in the list
        System.out.println("+---------------------+");
        System.out.printf("|%-3s", " ID ");
        System.out.printf("|%-10s", " NAME ");
        System.out.printf("|%-4s", " AGE ");
        System.out.print("|\n");
        System.out.println("+---------------------+");
        
        //For loop that displays the searched age results
        for (Pet age : petList) { 
            int itemAge = age.getAge(); 
            if (itemAge == ageInput) { 
                for (int i = 0; i < petList.size(); i++) {
                    System.out.printf("|%3d" , i);
                    System.out.print(" | ");
                    System.out.printf("%-9s", petList.get(i).getName());
                    System.out.printf("|%4d", petList.get(i).getAge());
                    System.out.print(" |\n");
                }
                System.out.println("+---------------------+");
            } 
        }
        menuOptions();
    }
}
