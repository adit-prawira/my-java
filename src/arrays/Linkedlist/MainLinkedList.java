package arrays.Linkedlist;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class MainLinkedList {
    public static void main(String[] args){
        Customer customer = new Customer("Adit", 100.50);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(500);
        System.out.println("Balance for " + customer.getName() + " is "+ customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        System.out.println("\nInitial ArrayList");
        intList.add(1);
        intList.add(3);
        intList.add(4);
        for(int i = 0; i< intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

        //  Code below will result in adding new element not changing it. Hence,
        //  creating and store new data which will consume time to process.
        //  0:1
        //  1:2
        //  2:3
        //  3:4
        System.out.println("\nArray list after adding element of 2 at index 1");
        intList.add(1, 2);
        for(int i = 0; i< intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }
    }
}
