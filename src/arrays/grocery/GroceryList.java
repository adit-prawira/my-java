package arrays.grocery;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();
    public void addGroceryItem(String item){
        groceryList.add(item);

    }
    public void printGroceryList(){
        int size = groceryList.size();
        System.out.println("You have " + size+" items");
        for(int i = 0; i< size; i++ ){
            System.out.println((i+1)+". "+groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery Item number "+ (position+1)+ " has been modified");
    }

    public void removeGroceryItem(int position){
        String removedItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.print("You have removed "+(removedItem)+"(item number"+(position+1)+") from your grocery list.");
    }

    public String findItem(String searchItem){
        int position = groceryList.indexOf(searchItem);
        return (position >= 0) ? groceryList.get(position) : null;
    }
}

