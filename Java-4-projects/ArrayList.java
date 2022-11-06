public class ArrayList<T> {
    
    private Object[] myArray;
    private int size;
    private static final int INITIAL_CAPACITY = 9;

    //constructor
    public ArrayList(){
        myArray = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    //getter
    public Object[] getMyArray(){
        return myArray;
    }

    //
    public void addToFront(T data){
        if(data == null){
            throw new NullPointerException("You cannot add a null value to the array. Please try again.");
        }
        else if(myArray[0] == null){
            myArray[0] = data;
            size++;
            return;
        }
        else if(myArray.length == size){
            Object[] newArray = new Object[myArray.length * 2];
            int index = 0;
            for(Object element : myArray){
                newArray[index] = element;
                index++;
            }
            myArray = newArray;
        }
        Object[] backingArray = new Object[myArray.length];
        int index = 0;
        backingArray[0] = data;
        for(Object element : myArray){
            if(element == null){
                break;
            }
            backingArray[index+1] = element;
            index++;
        }
        myArray = backingArray;
        size++;
    }

    //
    public void addToBack(T data){
        if(data == null){
            throw new NullPointerException("You cannot add a null value to the array. Please try again.");
        }
        else if(myArray[0] == null){
            myArray[0] = data;
            size++;
            return;
        }
        else if(myArray.length == size){
            Object[] newArray = new Object[myArray.length * 2];
            int index = 0;
            for(Object element : myArray){
                newArray[index] = element;
                index++;
            }
            myArray = newArray;
        }
        myArray[size] = data;
        size++;
    }
    //
    public void removeFromFront(){
        if(myArray[0] == null){
            throw new NullPointerException("You cannot remove an element from a null array. Please try again.");
        }
        int index = 0;
        for(Object element : myArray){
            if(index == size-1){
                myArray[index] = null;
                break;
            }
            myArray[index] = myArray[index+1];
            index++;
        }
        size--;
    }
    //
    public void removeFromBack(){
        if(myArray[0] == null){
            throw new NullPointerException("You cannot remove an element from a null array. Please try again.");
        }
        myArray[size-1] = null;
        size--;
    }
    //
    public String toString(){
        String theArray = "";
        int index = 0;
        for(Object element : myArray){
            theArray += element;
            if(index != myArray.length - 1){
                theArray += ",";
            }
            index++;
        }
        return "[" + theArray + "]";
    }
    //
    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.addToFront(9);
        myArray.addToFront(8);
        myArray.addToFront(7);
        myArray.addToFront(6);
        myArray.addToFront(5);
        myArray.addToFront(4);
        myArray.addToFront(3);
        myArray.addToFront(2);
        myArray.addToFront(1);

        myArray.removeFromBack();
        myArray.removeFromFront();
        myArray.removeFromFront();

        System.out.println(myArray.toString());
    }
}
