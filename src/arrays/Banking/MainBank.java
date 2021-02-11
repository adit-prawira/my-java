package arrays.Banking;

public class MainBank {
    public static void main(String[] args){
        Bank bank = new Bank("Commonwealth Bank");
        bank.addBranch("Parkville");
        bank.addCustomer("Parkville", "Adit", 15000);
        bank.addCustomer("Parkville", "Josh", 90.5);
        bank.addCustomer("Parkville", "Ryan", 7111);

        bank.addBranch("South Melbourne");
        bank.addCustomer("South Melbourne", "Tim", 10);
        bank.addCustomer("South Melbourne", "Remi", 100);
        bank.addCustomer("South Melbourne", "Theo", 90);

        bank.addCustomerTransaction("South Melbourne", "Tim", 50);
        bank.addCustomerTransaction("Parkville", "Adit", 90000);
        bank.addCustomerTransaction("South Melbourne", "Remi", 80);
    }
}
