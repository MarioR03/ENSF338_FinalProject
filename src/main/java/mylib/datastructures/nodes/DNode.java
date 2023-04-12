package main.java.mylib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode next;
    private DNode previous;

    //constructor
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    //methods
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public DNode getNext() {
        return next;
    }
    public void setNext(DNode next) {
        this.next = next;
    }
    public DNode getPrevious() {
        return previous;
    }
    public void setPrevious(DNode previous) {
        this.previous = previous;
    }
    public String toString(){
        return Integer.valueOf(this.data).toString();
    }

    public static void main(String[] args){
        System.out.println("Creating a list of values 1,2,3,4");
        DNode nodeOne = new DNode(1);
        DNode nodeTwo = new DNode(2);
        DNode nodeThree = new DNode(3);
        DNode nodeFour = new DNode(4);

        nodeOne.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);

        nodeFour.setPrevious(nodeThree);
        nodeThree.setPrevious(nodeTwo);
        nodeTwo.setPrevious(nodeOne);

        System.out.println("Printing the forward of a list using getNext loop");
        DNode current = nodeOne;
        for(int i = 0; current != null; i++){
            System.out.println(current.toString());
            current = current.getNext();
        }
        System.out.print("\n");
        System.out.println("------------------------------");
        System.out.println("Printing the reverse of a list using getPrevious loop");
        current = nodeFour;
        for(int i = 0; current != null; i++){
            System.out.println(current.toString());
            current = current.getPrevious();
        }
    }
}
