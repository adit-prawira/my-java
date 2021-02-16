package InterAbs.MyLinkedList;

public class Node extends ListItem{
    public Node(Object o){
        super(o);
    }
    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink= item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null){
            // Convert the Object value into string for comparison purposes.
            return ((String) super.getValue()).compareTo((String)item.getValue());
        }else{
            return -1;
        }

    }
}
