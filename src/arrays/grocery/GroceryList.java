package arrays.grocery;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();
    public ArrayList<String> getGroceryList(){
        return groceryList;
    }
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

    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position >= 0){
            changeGroceryItem(position, newItem);
        }
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if(position >= 0){
            deleteGroceryItem(position);
        }
    }

    public boolean onFile(String searchItem){
        return findItem(searchItem) >= 0;
    }

    // Private helper functions
    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }
    private void changeGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery Item number "+ (position+1)+ " has been modified.\n");
    }
    private void deleteGroceryItem(int position){
        String removedItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.print("You have removed "+(removedItem)+" from your grocery list.\n");
    }


}

