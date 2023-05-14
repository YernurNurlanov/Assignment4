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