package arrays.Banking;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> costumers;
    private String name;

    public Branch(String branchName){
        this.name = branchName;
        this.costumers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){
            this.costumers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        this.costumers.indexOf()
    }


}
