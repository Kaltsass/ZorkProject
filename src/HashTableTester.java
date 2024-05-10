import java.util.Hashtable;

public class HashTableTester {

    public static void main(String[] args){
        Hashtable<Integer,String> table = new Hashtable<>(10);

        table.put(1,"RoomOne");
        table.put(112,"RoomTwo");
        table.put(213,"RoomThree");
        table.put(344,"RoomFour");
        table.put(777,"SecretRoom");

        table.remove(4);
        for(Integer key : table.keySet()){
            System.out.println(key.hashCode() % 10 +"\t"+ key + "\t" + table.get(key));

        }
    }
}
