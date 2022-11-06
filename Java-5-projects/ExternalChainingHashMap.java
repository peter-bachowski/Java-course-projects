public class ExternalChainingHashMap<E,T>{
    private Object[] hashMapArray;
    private static final int INITIAL_CAPACITY = 13;

    //constructor
    public ExternalChainingHashMap(){
        hashMapArray = new Object[INITIAL_CAPACITY];
    }
    
    //getter
    public int getInitialCapacity(){return INITIAL_CAPACITY;}

    /***methods ***/

    //@override method hashCode()
    public int hashCode(E key){ 
        if(key instanceof String){ //converts the key string into a char array, then totals the dec values of each char to get an integer key
            char[] charArray = ((String)key).toCharArray();
            int keyValue = 0;
            for(char element: charArray){
                keyValue += (int)element;
            }
            return Math.abs(keyValue % INITIAL_CAPACITY);
        }
        else{
            return Math.abs((int)key % INITIAL_CAPACITY);
        }
    }
    
    public T put(E key, T value){
        if(key == null || value == null){
            throw new NullPointerException("The data you have entered is null or the key you are using is invalid. Please try again.");
        }
        if(hashMapArray[hashCode(key)] == null){
            HashMapNode<E,T> head = new HashMapNode<E,T>(key,value);
            hashMapArray[hashCode(key)] = head;
            return null;
        }
        else{ //searches the linked list at the hashed index of the array for the key
            HashMapNode<E,T> head = (HashMapNode<E,T>)hashMapArray[hashCode(key)];
            HashMapNode<E,T> current = head;
            while(current != null){
                if(current.getKey() == key){
                    T oldData = current.getData();
                    current.setData(value);
                    return oldData; //returns the previous data at the current node
                }
                current = current.getNext();
            }

            T oldValue = ((HashMapNode<E,T>)(hashMapArray[hashCode(key)])).getData(); //copies the data at the previous head node of the hash index
            
            head = new HashMapNode<E,T>(key,value);
            head.setNext((HashMapNode<E,T>)hashMapArray[hashCode(key)]); //sets the next node as the previous head
            hashMapArray[hashCode(key)] = head;
            return oldValue;
        }
    }

    public T delete(E key){
        if(key == null){
            throw new NullPointerException("The data you have entered is null or the key you are using is invalid. Please try again.");
        }
        HashMapNode<E,T> head = (HashMapNode<E,T>)hashMapArray[hashCode(key)];
        HashMapNode<E,T> current = head;

        if(head == null){
            throw new NullPointerException("You cannot remove null data. Please try again.");
        }
        else if(head.getKey() == key){
            T oldData = head.getData();
            hashMapArray[hashCode(key)] = head.getNext();
            head = head.getNext();
            return oldData;
        }
        else{
            if(head.getNext() == null){
                T oldData = head.getData();
                hashMapArray[hashCode(key)] = null;
                return oldData;
            }
            while(current.getNext() != null){
                if(current.getNext().getKey() == key){
                    T oldData = current.getNext().getData();
                    current.setNext(current.getNext().getNext());
                    return oldData; //returns the previous data at the current node
                }
                current = current.getNext();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ExternalChainingHashMap<Integer,Integer> hashMap1 = new ExternalChainingHashMap<>();
        hashMap1.put(8,8);
        hashMap1.put(11,11);
        hashMap1.put(25,25);
        hashMap1.put(19,19);
        hashMap1.put(32,32);
        hashMap1.put(45,6513);
        hashMap1.put(58,6513);

        hashMap1.delete(8);
        hashMap1.delete(58);
        hashMap1.delete(19);
        hashMap1.delete(45);
        hashMap1.delete(32);

    }

}
