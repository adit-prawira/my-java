package arrays.MobileContact;

import java.util.ArrayList;

public class MobilePhone {
    private String myPhoneNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String inputPhoneNumber){
        this.myPhoneNumber = inputPhoneNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact has already been saved on memory");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateExistingContact(Contact oldContact, Contact newContact){
        int position = findExistingContact(oldContact);
        if(position < 0){
            System.out.println("Contact not found");
            return false;
        }
        myContacts.set(position, newContact);
        System.out.println("Replaced: "+oldContact.getName()+" ---> " + newContact.getName());
        return true;
    }

    public boolean removeExistingContact(Contact contact){
        int position = findExistingContact(contact);
        if(position < 0){
            System.out.println("Contact not found or already deleted");
            return false;
        }
        System.out.println(contact.getName() + " is deleted from memory");
        myContacts.remove(contact);
        return true;
    }

    public String queryExistingContact(Contact contact){
        return (findExistingContact(contact) >= 0) ? contact.getName() : null;
    }

    public void printContactList(){
        int size = myContacts.size();
        System.out.println("Contacts in the mobile phone:\n");
        for(int i = 0; i< size; i++){
            Contact contact = myContacts.get(i);
            System.out.println(contact.getName() + " - "+ contact.getPhoneNumber());
        }
    }

    private int findExistingContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String name) {
        for(int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(name.equals(contact.getName())){
                return i;
            }
        }
        return -1;
    }


}
