import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.DNode;
import java.util.Random;

public class test {
    public static void main(String[] args){
        DLL doublyList = new DLL();

        Random rand = new Random();

        for(int i=0; i < 50; i++){
            int int_random = rand.nextInt(50);
            doublyList.SortedInsert(new DNode(int_random));
        }
        doublyList.Print();
        DNode node = doublyList.Search(new DNode(7));
        System.out.println(node.getData());
    }
}
