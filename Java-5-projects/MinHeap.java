public class MinHeap{
    private static final int INITIAL_CAPACITY = 13;
    private static final int rootIndex = 1;
    private int size;
    private Integer[] heapBackingArray;
    private Integer root;
    private Integer capacity;

    //contructors
    public MinHeap(){
        size = 0;
        capacity = INITIAL_CAPACITY;
        heapBackingArray = new Integer[INITIAL_CAPACITY];
        root = heapBackingArray[0] = null;
    }

    //getters
    public int getSize(){
        return size;
    }

    /*****methods*****/

    //add wrapper method
    public void addToHeap(Integer newData){
        if(newData == null){
            throw new NullPointerException("You cannot add null data. Please try again.");
        }
        size++;
        if(size >= capacity){ //if the array is full, create a new array with double the capacity and copy the data to the new array
            int index = 0;
            Integer[] tempArray = new Integer[capacity*2];
            for(Integer element: heapBackingArray){
                tempArray[index] = element;
                index++;
            }
            capacity *= 2;
            heapBackingArray = tempArray; //sets the backing array equal to the 
        }
        heapBackingArray[size] = newData;

        if(size == 1){ //if the array is empty
            heapBackingArray[size] = root = newData;
        }
        else{
            heapBackingArray[size] = upHeap(size, newData);
        }  
    }

    //add helper method
    private Integer upHeap(int currentIndex, Integer data){
        Integer parent = heapBackingArray[currentIndex/2];
        if(parent == null || data > parent){ //if the data is larger than the parent
            return data;
        }
        else{ //if the data is smaller than the parent
            heapBackingArray[currentIndex] = parent;
            heapBackingArray[currentIndex/2] = data;
            upHeap(currentIndex/2, data);
                 
            return parent;       
        }
    }

    //delete wrapper method 
    public void deleteFromHeap(){
        if(size == 0){
            throw new NullPointerException("You cannot remove null data. Please try again.");
        }
        else{
            if(size == 1){ //if the array has only one element
                heapBackingArray[size] = root = null;
            }
            else{
                heapBackingArray[rootIndex] = heapBackingArray[size];
                heapBackingArray[size] = null;
                downHeap(rootIndex);
                root = heapBackingArray[rootIndex];
            } 
        }
        size--;
    }
    //delete helper method
    private Integer downHeap(int currentIndex){

        Integer current = heapBackingArray[currentIndex];
        Integer leftChild;
        Integer rightChild;

        if(2*currentIndex >= capacity || 2*currentIndex+1 >= capacity){//if the left and right children have an index out of bounds, set the children to null.
            leftChild = rightChild = null;
        } 
        else{
            leftChild = heapBackingArray[2*currentIndex]; 
            rightChild = heapBackingArray[2*currentIndex+1];
        }

        if((leftChild == null && rightChild == null) || (current < leftChild && current < rightChild)){
            return current;
        }
        else{
            if(rightChild == null || leftChild < rightChild){
                heapBackingArray[2*currentIndex] = current;
                heapBackingArray[currentIndex] = leftChild;
                downHeap(2*currentIndex);
            }
            else if(leftChild > rightChild){
                heapBackingArray[2*currentIndex+1] = current;
                heapBackingArray[currentIndex] = rightChild;
                downHeap(2*currentIndex+1);
            }
        }
        return current;


    }


    public static void main(String[] args) {
        MinHeap heap1 = new MinHeap();
        heap1.addToHeap(0);
        heap1.addToHeap(1);
        heap1.addToHeap(2);
        heap1.addToHeap(4);
        heap1.addToHeap(3);
        heap1.addToHeap(5);
        heap1.addToHeap(7);
        heap1.addToHeap(6);
        heap1.addToHeap(8);
        heap1.addToHeap(9);
        heap1.addToHeap(10);
        heap1.addToHeap(11);
        heap1.addToHeap(11);

        heap1.deleteFromHeap();
        //heap1.deleteFromHeap();
        //heap1.deleteFromHeap();
    }

}