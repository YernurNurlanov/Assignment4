public class MyHashTable<K, V>{
    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    // Array of hash table nodes
    private HashNode<K, V>[] chainArray;
    // Default node array size
    private int M = 11;
    // Current number of elements in the table
    private int size;
    // Constructor with default number of chains
    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    // Constructor with changeable number of chains
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    // Returns the size.
    public int getSize(){
        return size;
    }
    // Returns the hash value of the key.
    private int hash(K key){
        return key.hashCode() % M;
    }
    // Adds the key-value pair to the hash table.
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> node = new HashNode<>(key, value);
        if (chainArray[index] == null) {
            chainArray[index] = node;
        }
        else {
            for (int i = 0; i < size; i++){
                HashNode<K, V> element = chainArray[index];
                if (element.key.equals(key)){
                    element.value = value;
                    return;
                }
            }
            HashNode<K, V> curr = chainArray[index];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }
    // Returns the value related to the given key.
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }
    // Removes the key-value pair from the hash table corresponding to the given key.
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> curr = chainArray[index];
        HashNode<K, V> prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = curr.next;
                }
                else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }
    // Checks if the given value is contained in a hash table.
    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }
    // Returns the key related to the given value.
    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> curr = chainArray[i];
            while (curr != null) {
                if (curr.value.equals(value)) {
                    return curr.key;
                }
                curr = curr.next;
            }
        }
        return null;
    }
}
