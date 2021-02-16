package InterAbs.MyLinkedList;

import java.util.List;

public class SearchTree implements NodeList{
    private ListItem root = null;
    public SearchTree(ListItem root){
        this.root= root;
    }
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            // As the root/head value is empty, then insert newItem as the first item of the tree
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0){
                // Move newItem to the right when it is greater than the currentItem
                if(currentItem.next() != null){
                    // when the currentItem has the next value
                    // move on to the next record or the right side of the tree and compare it with the newItem
                    // until null or other condition is met.
                    currentItem = currentItem.next();
                }else{
                    // When the currentItem doesn't have the next value, set the next value as the newItem
                    currentItem.setNext(newItem);
                    return true;
                }
            }else if(comparison > 0){
                // Move newItem to the left when it is less than the currentItem
                if(currentItem.previous() != null){
                    // when the currentItem has the previous  value
                    // move on to the previous record or the left side of the tree and compare it with the newItem
                    // until null or other condition is met.
                    currentItem = currentItem.previous();
                }else{
                    // When the currentItem doesn't have the previous value, set the previous value as the newItem
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else{
                // Not adding any duplicates
                System.out.println(newItem.getValue() + " is already present");
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
        // Recursive method
        if(root != null){
            // root.previous() and root.next() is the children of the current root
            // Call the traverse method to access the children of root.previous()
            // and the children of root.next().
            // The process will continue until there are no children left.

            traverse(root.previous()); // processes the left side/node of the tree
            System.out.println(root.getValue());
            traverse(root.next()); // processes the right side/node of the tree
        }
    }
}
