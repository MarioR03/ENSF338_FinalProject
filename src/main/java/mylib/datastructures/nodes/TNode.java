package main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public TNode(){
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public TNode(int data,int balance, TNode parent, TNode left, TNode right){
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    // Getter and setter for "left"
    public TNode getLeft() {
        return left;
    }
    public void setLeft(TNode left) {
        this.left = left;
    }
    public TNode getRight() {
        return right;
    }
    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void print(){
        System.out.println("placeho lder");
    }


}
