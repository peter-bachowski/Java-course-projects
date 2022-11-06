public class HashMapNode<E,T> {
    private T data;
    private HashMapNode<E,T> next;
    private E key;

    public HashMapNode(E key, T data){
        this(key, data, null);
    }
    public HashMapNode(E key, T data, HashMapNode<E,T> next){
        this.key = key;
        this.data = data;
        this.next = next;
    }

    public T getData(){return data;}
    public E getKey(){return key;}
    public HashMapNode<E,T> getNext(){return next;}
    public void setData(T newData){data = newData;}
    public void setNext(HashMapNode<E,T> newNext){next = newNext;}
}
