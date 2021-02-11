package arrays.Banking;

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
