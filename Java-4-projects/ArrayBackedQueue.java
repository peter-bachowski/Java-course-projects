public class ArrayBackedQueue<T> {

    private static final int INITIAL_CAPACITY = 5;
    private int capacity;
    private int size;
    private Object[] arrayQueue;
    private int front;
    private int back;

    public ArrayBackedQueue(){
        size = 0;
        front = 0;
        back = 0;
        capacity = INITIAL_CAPACITY;
        arrayQueue = new Object[INITIAL_CAPACITY];
    }

    public void enqueue(T data){
        
        if(arrayQueue[back] == null){
            arrayQueue[back] = data;
        }
        else if(size == capacity){
            Object[] copyArray = new Object[capacity*2];

            int count = 0;
            for(int index = front; count < size ; index++){
                if(index == capacity){
                    index = 0;
                }
                copyArray[count] = arrayQueue[index];
                count++;
            }
            copyArray[size] = data;
            arrayQueue = copyArray;
            capacity = capacity*2;
            front = 0;
        }
        size += 1;
        back = (front+size) % capacity;
    }

    public void dequeue(){
        if(size == 0){
            throw new NullPointerException("The array is null. You cannot remove null data from the array. Please try again.");
        }
        arrayQueue[front] = null;
        front +=1;
        size --;
        if(front >= capacity){
            front = 0;
        }
    }

    public String toString(){
        String arrayString = "";
        for(Object element : arrayQueue){
            arrayString += element + " "; 
        }
        return String.format("[ %s]\nFront: %d\nBack: %d", arrayString, front, back);
    }

    public static void main(String[] args) {
        ArrayBackedQueue<String> array1 = new ArrayBackedQueue<>();

        array1.enqueue("a");
        array1.enqueue("b");
        array1.enqueue("c");
        array1.enqueue("d");
        array1.enqueue("e");

        array1.dequeue();
        array1.dequeue();
        array1.dequeue();
        array1.dequeue();

        array1.enqueue("f");
        array1.enqueue("g");
        array1.enqueue("h");

        System.out.println(array1.toString());
    }

}
