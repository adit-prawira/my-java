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

        bank.listCustomers("Parkville", true);
        bank.listCustomers("South Melbourne", true);
        bank.addBranch("Melbourne CBD");
        if(!bank.addCustomer("Melbourne CBD", "Brian", 50)){
            System.out.println("Error: Melbourne CBD branch does not exist");
        }
        if(!bank.addBranch("Parkville")){
            System.out.println("Error: Parkville branch has already exist");
        }

        if(!bank.addCustomerTransaction("Parkville", "Dio", 10)){
            System.out.println("Error: Customer does not exist in this branch");
        }

        if(!bank.addCustomer("Parkville", "Adit", 500)){
            System.out.println("Error: Customer Adit already exist");
        }


    }
}
