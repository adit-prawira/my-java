package InterAbs.Travelling;

public abstract class ListItem {
    // The attributes are set to be protected instead of private,
    // because the concrete subclass need to access these attributes.
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected Object value;

    public ListItem(Object o){
        this.value = o;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);

    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
