/**
 * Your implementation of a MaxHeap.
 */
public class MaxHeap<T extends Comparable<? super T>> {

    /*
     * The initial capacity of the MaxHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;
    private int capacity;

    /**
     * This is the constructor that constructs a new MaxHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MaxHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }


    //add wrapper method
    public void add(T newData){
        if(newData == null){
            throw new NullPointerException("You cannot add null data. Please try again.");
        }
        size++;
        if(size >= capacity){ //if the array is full, create a new array with double the capacity and copy the data to the new array
            int index = 0;
            T[] tempArray = (T[]) new Comparable[capacity*2];
            for(T element: backingArray){
                tempArray[index] = element;
                index++;
            }
            capacity *= 2;
            backingArray = tempArray; //sets the backing array equal to the 
        }
        backingArray[size] = newData;

        if(size == 1){ //if the array is empty
            backingArray[size] = newData;
        }
        else{
            backingArray[size] = upHeap(size, newData);
        }  
    }

    //add helper method
    public T upHeap(int currentIndex, T data){
        T parent = backingArray[currentIndex/2];
        if(parent == null || data.compareTo(parent)<0){ //if the data is larger than the parent
            return data;
        }
        else{ //if the data is smaller than the parent
            backingArray[currentIndex] = parent;
            backingArray[currentIndex/2] = data;
            upHeap(currentIndex/2, data);
                 
            return parent;       
        }
    }

    /**
     * Removes and returns the max item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * You may assume that the heap is not empty.
     *
     * @return The data that was removed.
     */
    public T remove() {
        T oldData = null;
        if(size == 1){ 
            oldData = backingArray[1];
            backingArray[1] = null;
        }
        else{
            oldData = backingArray[1];
            backingArray[1] = backingArray[size];
            backingArray[size] = null;
            downHeap(1);
        } 
        size--;
        return oldData;
    }
    
    private T downHeap(int currentIndex){

        T current = backingArray[currentIndex];
        T leftChild;
        T rightChild;

        if(2*currentIndex >= INITIAL_CAPACITY || 2*currentIndex+1 >= capacity){
            leftChild = rightChild = null;
        } 
        else{
            leftChild = backingArray[2*currentIndex]; 
            rightChild = backingArray[2*currentIndex+1];
        }

        if(leftChild == null && rightChild == null){
            return current;
        }
        else if(leftChild == null){
            if(current.compareTo(rightChild)>0){
                return current;
            }
            else{
                backingArray[2*currentIndex+1] = current;
                backingArray[currentIndex] = rightChild;
                downHeap(2*currentIndex+1);
            }
        }
        else if(rightChild == null){
            if(current.compareTo(leftChild)>0){
                return current;
            }
            else{
                backingArray[2*currentIndex] = current;
                backingArray[currentIndex] = leftChild;
                downHeap(2*currentIndex);
            }
        }
        else if(current.compareTo(leftChild)> 0 && current.compareTo(rightChild)>0){
            return current;
        }
        else if(leftChild.compareTo(rightChild)>0){
            backingArray[2*currentIndex] = current;
            backingArray[currentIndex] = leftChild;
            downHeap(2*currentIndex);
        }
        else if(leftChild.compareTo(rightChild)<0){
            backingArray[2*currentIndex+1] = current;
            backingArray[currentIndex] = rightChild;
            downHeap(2*currentIndex+1);
        }
        return current;
    }
    

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap1 = new MaxHeap<>();
        heap1.add(45);
        heap1.add(35);
        heap1.add(28);
        heap1.add(0);
        heap1.add(14);
        heap1.add(7);
        heap1.add(21);


        heap1.remove();
    }
}


