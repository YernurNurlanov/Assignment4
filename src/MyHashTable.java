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
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    public int getSize(){
        return size;
    }
    private int hash(K key){
        return key.hashCode() % M;
    }
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
