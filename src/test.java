import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.DNode;
import java.util.Random;

public class test {
    public static void main(String[] args){
        CSLL circle = new CSLL();

        Random rand = new Random();

        for(int i=0; i < 50; i++){
            int int_random = rand.nextInt(50);
            circle.SortedInsert(new DNode(int_random));
        }
        circle.Print();
        System.out.println("---------");
        circle.Sort();
        circle.Print();


        // SLL linkedList = new SLL();
        // for(int i=0; i < 50; i++){
        //     int int_random = rand.nextInt(50);
        //     linkedList.InsertTail(new DNode(int_random));
        // }
        // linkedList.Sort();
        // linkedList.Print();
    }
}
