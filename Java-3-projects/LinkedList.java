import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>{

    private class Node<E> { //inner class
        E data;
        Node<E> next;

        //constructors
        Node(E data){
            this(data, null);
        }
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getE(){
            return data;
        }
        public void setE(E newData){
            data = newData;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    //constructor
    public LinkedList(){
        head = null;
        tail = null;

        if(isEmpty()){
            size = 0;
        }
    }

    //setters and getters
    public Node<T> getHead(){
        return head;
    }
    public void setHead(Node<T> newHead){
        head = newHead;
    }
    public Node<T> getTail(){
        return tail;
    }
    public void setTail(Node<T> newTail){
        tail = newTail;
    }

    //methods
    public void addAtIndex(T data, int index) {
        size++;

        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else if(data == null){
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        else if(head == null){
            head = new Node<T>(data, null);
            return;
        }
 
        Node<T> current = head;
        int count = 0;
        while(count < index - 1){
            current = current.next;
            count++;
        }
        Node<T> addedNode = new Node<T> (data, current.next);
        current.next = addedNode;  
        
        for(Node<T> node = head; node != null; node = node.next){ //assigns tail
            if(node.next == null){
                tail = node;
            }
        }

    }

    public T getAtIndex(int index){
        if(index < 0 || index > this.size() - 1){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        Node<T> current = head;
        int count = 0;
        while(count < index){
            current = current.next;
            count++;
        }
        return current.data;

    }

    public T removeAtIndex(int index){

        Node<T> current = head;
        int count = 0;

        if(head == null){
            return null;
        }
        else if(index < 0 || index > this.size - 1){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else if(index == 0){
            head = head.next;
        }

        while(count < index){
            if(count == index - 1){
                current.next = current.next.next;
                break;
            }
            current = current.next;
            count++;
        }
        for(Node<T> node = head; node != null; node = node.next){ //assigns tail
            if(node.next == null){
                tail = node;
            }
        }

        size--;
        
        return current.data;
    }

    public T remove(T data){
        Node<T> current = head;
        boolean found = false;
        if(data == null){
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        if(head.data == data){
            Node<T> oldHead = head;
            if(head.next == null){
                head = null;
                tail = null;
                return null;
            }
            head = head.next;
            return oldHead.data;
        }
        while(!found){
            if(current.next == null){
                throw new NoSuchElementException("The data is not present in the list.");
            }
            else if(current.next.data == data){
                if(current.next == null){
                    head.next = null;
                    tail = head;
                    return current.data;
                }
                current.next = current.next.next; //skips over the target node
                found = true;
                break; 
            }

            current = current.next;
        }

        for(Node<T> node = head; node != null; node = node.next){ //assigns tail
            if(node.next == null){
                tail = node;
            }
        }
        return current.data;
    }

    public void clear(){
        head = null;
    }

    public boolean isEmpty() {
        return (head == null && tail == null); //the list is empty if head and tail is null
    }

    public int size(){
        return size;
    }

    public String toString() {

        Node<T> current = head; //traversal starts at the front
        String result = ""; //result starts empty
        if(head == null && tail == null){
            return null + "\n\n" + "Head: " + head + "\n" + "Tail: " + tail;
        }
        while (current != null) {  //keep going until there's no more nodes to point to
            result = result + current.data.toString() + "\n";
            current = current.next; //move over to next node
        }

        return result + "\n" + "Head: " + head.data + "\n" + "Tail: " + tail.data;
    }

    public static void main(String[] args) {

        LinkedList<String> newList = new LinkedList<>();
        newList.addAtIndex("Humpty Dumpty", 0);
        newList.addAtIndex("Humpty Dumpty", 1);
        newList.addAtIndex("Itsy Bitsy Spider", 2);
        newList.addAtIndex("Twinkle, Twinkle Little Star", 3);
        newList.addAtIndex("Wheels on the Bus", 4);

        //newList.removeAtIndex(0);
        //newList.removeAtIndex(3);

        newList.remove("Humpty Dumpty");

        System.out.println(newList.getAtIndex(1));
        System.out.println(newList.toString());

    }

}
