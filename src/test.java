import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.DNode;
import java.util.Random;

public class test {
    public static void main(String[] args){
        // CSLL circle = new CSLL();

        Random rand = new Random();

        // for(int i=0; i < 50; i++){
        //     int int_random = rand.nextInt(50);
        //     circle.InsertHead(new DNode(int_random));
        // }
        // circle.Print();
        // System.out.println("---------");
        // circle.Sort();
        // circle.Print();


        // CDLL dcircle = new CDLL();
        
        // for(int i =0; i< 20; i++){
        //     int num = rand.nextInt(20);
        //     dcircle.InsertHead(new DNode(num));
        // }

        // dcircle.Print();
        // System.out.println("-----");
        // dcircle.Sort();
        // dcircle.Print();

        CSLL doubly = new CSLL();
        doubly.InsertHead(new DNode(2));
        doubly.InsertHead(new DNode(1));
        doubly.InsertHead(new DNode(3));
        // for(int i=0; i < 3; i++){
        //     int int_random = rand.nextInt(50);
        //     doubly.InsertHead(new DNode(int_random));
        // }
        doubly.Print();
        System.out.println("head: " + doubly.getHead() + " tail: " + doubly.getTail());
        System.out.println("---");
        doubly.Sort();
        doubly.Print();

        //System.out.println("head: " + doubly.getHead() + " tail: " + doubly.getTail());
    }
}
