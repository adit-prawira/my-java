package arrays.MobileContact;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0402 555 500");
    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        startPhone();
        printCommands();
        while(!quit){
            switch(choice){
                case 0:
                    printCommands();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    System.out.println("Shutting down phone...");
                    quit = true;
                    break;
            }
        }
    }
    private static void searchContact() {

    }

    private static void removeContact() {
    }

    private static void modifyContact() {
    }

    private static void addContact() {
        System.out.println("Enter contact name: ");
        String newContactName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newPhoneNumber);
        mobilePhone.addNewContact(newContact);
    }
    private static void startPhone(){System.out.println("Starting mobile phone...");}
    private static void printCommands() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To show command lists.");
        System.out.println("\t 1 - To show contact lists.");
        System.out.println("\t 2 - To add contact to phone.");
        System.out.println("\t 3 - To modify existing contact.");
        System.out.println("\t 4 - To remove existing contact.");
        System.out.println("\t 5 - To search for contact.");
        System.out.println("\t 6 - To turning off the mobile phone.");
    }
}
