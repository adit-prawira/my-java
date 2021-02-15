package InterAbs.Travelling;

public class MainTravelling {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String stringData = "5 7 3 9 8 2 1 0 4 6";
        String[] data = stringData.split(" ");
        for(String city: data){
            // Create new Item with value set to the string city
            // In this case the Object parameter to the Node class
            // is String type parameter
            list.addItem(new Node(city));
        }
        list.traverse(list.getRoot());
        list.removeItem(new Node("3"));
        list.traverse(list.getRoot());
    }
}
