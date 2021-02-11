package arrays.Banking;

import arrays.Array;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String bankName){
        this.name = bankName;
        this.branches= new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            // From Branch class this method will return a boolean value.
            // Hence, the return below.
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            // Same as above. Check Branch Class.
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }
    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            System.out.println("Customer details for branch" + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCostumers();
        }
    }
    private Branch findBranch(String branchName) {
        for(int i = 0; i< this.branches.size();i++){
            Branch branch = this.branches.get(i);
            if(branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null;
    }

}
