package arrays.MobileContact;

import java.util.Scanner;

public class MainMobile {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0402 555 500");
    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        startPhone();
        printCommands();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
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
        System.out.println("============= Search =============");
        System.out.println("Search for: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Contact Found:");
        System.out.println(existingContact.getName() + " - "+ existingContact.getPhoneNumber());

    }

    private static void removeContact() {
        System.out.println("============= Delete =============");
        System.out.println("Enter existing contact name to delete: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        if(mobilePhone.removeExistingContact(existingContact)){
            System.out.println("Successfully deleting contact");
        }else{
            System.out.println("Error occurred during deletion.");
        }
    }

    private static void modifyContact() {
        System.out.println("============== Edit ==============");
        boolean quitInputPage = false;
        int option = 0;
        System.out.println("Enter existing contact name to update: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);

        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        showOptions();
        while(!quitInputPage){
            System.out.println("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 0:
                    showOptions();
                    break;
                case 1:
                    System.out.println("Enter new contact name: ");
                    String newContactName = scanner.nextLine();
                    Contact updatedContactName = Contact.createContact(newContactName, existingContact.getPhoneNumber());
                    if(mobilePhone.updateExistingContact(existingContact, updatedContactName)){
                        System.out.println("SuccessFully update contact name");
                    }else{
                        System.out.println("Error updating name");
                    }
                    break;
                case 2:
                    System.out.println("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    Contact updatedContactNumber = Contact.createContact(existingContact.getName(), newPhoneNumber);
                    if(mobilePhone.updateExistingContact(existingContact, updatedContactNumber)){
                        System.out.println("SuccessFully update contact number");
                    }else{
                        System.out.println("Error updating contact number");
                    }
                    break;
                case 3:
                    System.out.println("Enter new contact name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new phone number: ");
                    String newNumber = scanner.nextLine();
                    Contact newContact = Contact.createContact(newName, newNumber);
                    if(mobilePhone.updateExistingContact(existingContact, newContact)){
                        System.out.println("SuccessFully update contact");
                    }else{
                        System.out.println("Error updating contact");
                    }
                    break;
                case 4:
                    quitInputPage = true;
                    break;
            }
        }
    }

    private static void showOptions() {
        System.out.println("Options:\n");
        System.out.println("0 - To show options.");
        System.out.println("1 - To update contact name only.");
        System.out.println("2 - To update phone number only.");
        System.out.println("3 - To update both name and phone number.");
        System.out.println("4 - To cancel and quit edit.");
    }

    private static void addContact() {
        System.out.println("============= Add Contact =============");
        System.out.println("Enter contact name: ");
        String newContactName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newPhoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: " + newContactName + " - "+ newPhoneNumber);
        }else{
            System.out.println("Can't add contact under "+ newContactName);
        }
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
