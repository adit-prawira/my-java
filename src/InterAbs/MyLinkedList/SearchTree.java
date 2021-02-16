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
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while(currentItem != null){
            int comparison  = currentItem.compareTo(item);
            if(comparison < 0){
                // When item is greater than currentItem
                // traverse to the right side of the tree
                // the parentItem holds the value of the current item
                // then the value of the currentItem is changed to the value of the next item
                parentItem = currentItem;
                currentItem = currentItem.next();
            }else if (comparison > 0){
                // When item is less than currentItem
                // traverse to the left side of the tree
                // the parentItem holds the value of the current item
                // then the value of the currentItem is changed to the value of the previous item
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }else{
                // when the item is equal to the currentItem, then the target item to be deleted is met.
                // then call performRemoval method to actually remove this item from the tree
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    // A method that will remove item from the tree
    private void performRemoval(ListItem item, ListItem parent) {
        // The condition where there is no right tree of the item
        if(item.next() == null){
            // no right tree, then this make parent to go the left tree (which may be null)
            if(parent.next() == item){
                // The condition if the right child of the parent is the item
                // If yes, then take the left child of the item
                // and set it as the right child of the parent
                parent.setNext(item.previous());
            }else if(parent.previous() == item){
                // The condition if the left child of the parent is the item
                // if yes, then take the right child of the item
                // and set it as the left child of the parent
                parent.setPrevious(item.previous());
            }else{
                // Otherwise, parent is actually IS the item
                // deleting the root
                this.root = item.previous();
            }
        }else if(item.previous() == null){
            if(parent.next() == item){
                parent.setNext(item.next());
            }else if(parent.previous() == item){
                parent.setPrevious(item.next());
            }else{
                this.root = item.next();
            }
        }else{
            // the condition where the left and right value of the current tree is defined
            // set currentItem as the right child of "item".
            // This mean that from the right sub-tree, find the smallest value which is the leftmost value
            ListItem currentItem = item.next();
            ListItem leftmostParent = item;
            while(currentItem.previous() != null){
                leftmostParent = currentItem;
                currentItem = currentItem.previous();
            }
            // Set the smallest value into item node to be deleted
            item.setValue(currentItem.getValue());
            // and delete the smallest
            if(leftmostParent == item){
                // there was no leftmost node, so currentItem points to the smallest
                // node (the one that must now be deleted)
                item.setNext(currentItem.next());
            }else{
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null);
                leftmostParent.setPrevious(currentItem.next());
            }

        }
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
