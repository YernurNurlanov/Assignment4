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
    
}
