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
    }

}
