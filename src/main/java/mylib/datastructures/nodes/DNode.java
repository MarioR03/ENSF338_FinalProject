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
}
