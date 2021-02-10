package arrays.grocery;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

//    public static void processArrayList() {
//        ArrayList<String> newArray = new ArrayList<String>(groceryList.getGroceryList());
//        String[] copyArray = new String[groceryList.getGroceryList().size()];
//        copyArray = groceryList.getGroceryList().toArray(copyArray);
//    }

    private static void addItem() {
        System.out.println("Please enter the grocery item: ");
        String newItem = scanner.nextLine();
        groceryList.addGroceryItem(newItem);
    }
    private static void modifyItem() {
        System.out.println("Enter the item name: ");
        String currentItem = scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(currentItem, newItem);

    }
    private static void removeItem() {
        System.out.println("Please enter item to remove: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    private static void searchItem() {
        System.out.println("Search for: ");
        String searchedItem = scanner.nextLine();
        if(groceryList.onFile(searchedItem)){
            System.out.println("Found " + (searchedItem) + " in grocery list.");
        }else{
            System.out.println(searchedItem + " is not found in grocery list.");
        }
    }


    private static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item in the list");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }
}
