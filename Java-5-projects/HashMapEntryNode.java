/**
 * Map entry class used for implementing the ExternalChainingHashMap.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class HashMapEntryNode<K, V> {

    private K key;
    private V value;
    private HashMapEntryNode<K, V> next;

    /**
     * Constructs a new HashMapEntryNode with only the given key and value.
     *
     * @param key   The key in the new entry.
     * @param value The value in the new entry.
     */
    public HashMapEntryNode(K key, V value) {
        this(key, value, null);
    }

    /**
     * Constructs a new HashMapEntryNode with the given key, value, and next reference.
     *
     * @param key   The key in the new entry.
     * @param value The value in the new entry.
     * @param next  The next entry in the external chain.
     */
    public HashMapEntryNode(K key, V value, HashMapEntryNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Gets the key.
     *
     * @return The key.
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return The value.
     */
    public V getValue() {
        return value;
    }

    /**
     * Gets the next entry.
     *
     * @return The next entry.
     */
    public HashMapEntryNode<K, V> getNext() {
        return next;
    }

    /**
     * Sets the key.
     *
     * @param key The new key.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Sets the value.
     *
     * @param value The new value.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Sets the next entry.
     *
     * @param next The new next entry.
     */
    public void setNext(HashMapEntryNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String key = this.key == null ? "null" : this.key.toString();
        String value = this.value == null ? "null" : this.value.toString();
        return String.format("(%s, %s)", key, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        // DO NOT USE THIS METHOD IN YOUR CODE! This is for testing ONLY!
        if (!(o instanceof HashMapEntryNode)) {
            return false;
        } else {
            HashMapEntryNode<K, V> that = (HashMapEntryNode<K, V>) o;
            return that.getKey().equals(key) && that.getValue().equals(value);
        }
    }
}