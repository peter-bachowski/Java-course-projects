public class SinglyLinkedList<T>{

    private static class Node<T> { //inner class
        private T data;
        private Node<T> next;

        private Node(T data){
            this(data, null);
        }
        private Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    //constructor
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void addToFront(T newData){
        if(newData == null){
            throw new NullPointerException("You cannot add null data. Please try again.");
        }
        else if(head == null && tail == null){
            head = new Node<T> (newData, null);
            tail = head;
        }
        else{
            head = new Node<T>(newData, head);
        }
    }

    public void removeFromFront(){
        if(head == null && tail == null){
            throw new NullPointerException("You cannot remove null data. Please try again.");
        }
        else if(head.next == null && tail.next == null){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
        }
    }

    public void addToBack(T newData){
        if(newData == null){
            throw new NullPointerException("You cannot add null data. Please try again.");
        }
        else if(head == null && tail == null){
            head = new Node<T> (newData, null);
            tail = head;
        }
        else{
            tail.next = new Node<T>(newData);
            tail = tail.next;
        }
    }

    public void removeFromBack(){
        if(head == null && tail == null){
            throw new NullPointerException("You cannot remove null data. Please try again.");
        }
        Node<T> current = head;
        if(current.next == null){
            head = null;
            tail = null;
        }
        else{
            while(current != null){
                if(current.next.next == null){
                    current.next = null;
                    tail = current;
                    return;
                }
            }
        }
    }

    public String toString(){
        String theList = "";
        Node<T> current = head;
        while(current != null){
            theList += current.data + " ";
            current = current.next;
        }
        return theList;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addToFront(2);
        list1.addToFront(1);
        list1.addToFront(0);
        list1.addToBack(3);
        list1.addToBack(4);
        list1.removeFromFront();
        list1.removeFromFront();
        list1.removeFromFront();
        list1.removeFromBack();
        list1.removeFromBack();
        System.out.println(list1.toString());
    }
}
