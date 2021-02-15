package InterAbs.Travelling;

public class MyLinkedList implements NodeList{
    private ListItem root = null;
    public MyLinkedList(ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            // If the list is empty, it becomes the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0){
                // newItem is greater, move right if possible
                // therefore, check whether or the next item is exist or not.
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                }else{
                    // There is no next item, so insert the new item at the end of list
                    // and set the previous item if the newItem as the processed currentItem
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }else if (comparison > 0){
                // newItem is inferior to the currentItem
                // therefore, check whether or not the previous item of the currentItem exist.
                if(currentItem.previous() != null){
                    // Access the previous item of the current item, and set its next item to the newItem
                    // and, set the previous item of the currentItem to be the previous item of the newItem.
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    // Set the next item of the newItem as the processed currentItem
                    // and, set the previous item of the current item as the newItem
                    newItem.setNext(currentItem).setPrevious(newItem);
                }else{
                    // set the newItem as the root/head which is the first item of the list
                    // as there is no previous item.
                    // therefore change the position of this.root which is initially stored from the constructor
                    // with the newItem, and set the previous item of the this.root as the newItem
                    newItem.setNext(this.root).setPrevious(newItem);
                    // change the root value to be the newItem.
                    this.root = newItem;
                }
                return true;
            }else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
