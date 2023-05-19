import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable<MyTestingClass, String>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = r.nextInt(0, 1000000);
            table.put(new MyTestingClass(id), "Student " + i);
        }
        table.chainSizes();
        System.out.println("Start testing replace() method");
        MyHashTable<Object, Object> Table = new MyHashTable<Object, Object>();
        Table.put(1,123);
        Table.put(2,"///");
        Table.put(3,true);
        Table.replace(2, "///", 1234567);
        System.out.println(Table.contains(1234567));
        Table.chainSizes();
    }
}
class MyTestingClass {
    private int id;
    public MyTestingClass(int id){
        this.id = id;
    }
    public int hashCode(){
        return id % 11;
    }
}