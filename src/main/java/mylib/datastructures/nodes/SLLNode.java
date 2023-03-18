package main.java.mylib.datastructures.nodes;

public class SLLNode {
    private int data;
    private SLLNode next;

    //constructor
    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
    //methods
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public SLLNode getNext() {
        return next;
    }
    public void setNext(SLLNode next) {
        this.next = next;
    }
    public String toString(){
        return Integer.valueOf(this.data).toString();
    }
}
