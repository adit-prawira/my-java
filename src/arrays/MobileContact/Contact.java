package arrays.MobileContact;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String inputName, String inputPhoneNumber){
        this.name = inputName;
        this.phoneNumber = inputPhoneNumber;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Factory Method
    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }
}
