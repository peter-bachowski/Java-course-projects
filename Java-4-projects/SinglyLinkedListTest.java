/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedListTest<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;
    /*
     * Do not add a constructor.
     */
    /**
     * Adds the element to the specified index.
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     * 
     * ASSUMPTIONS:
     * - You may assume that the index will always be valid [0, size]
     * - You may assume that the data will not be null
     *
     * @param index the index to add the new element
     * @param data  the data to add
     */
    public void addAtIndex(int index, T data) {
        if(index == 0){
            head = new SinglyLinkedListNode<T>(data, head);
            if(tail == null){
                tail = head;
            }
        }
        else if(index == size){
            SinglyLinkedListNode<T> addedArray = new SinglyLinkedListNode<T>(data);
            tail.setNext(addedArray);
            tail = addedArray;
        }
        else{
            int arrayIndexCount = 0;
            SinglyLinkedListNode<T> current = head;
            while(arrayIndexCount < index){
                if(arrayIndexCount == index-1){
                    current.setNext(new SinglyLinkedListNode<T>(data, current.getNext()));
                    break;
                }
                current = current.getNext();
                arrayIndexCount++;
            }
        }
        size++;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedListTest<Integer> array1 = new SinglyLinkedListTest<>(); 
        array1.addAtIndex(0, 0);
        array1.addAtIndex(0, 1);

    }
}