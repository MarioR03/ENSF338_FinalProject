package main.java.mylib.datastructures.nodes;
/**
 * Nodes for Tree data structures
 */
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
        this.balance = 0;
    }
    public TNode(int data,int balance, TNode parent, TNode left, TNode right){
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    /**
     * Returns data value
     */
    public int getData() {
        return data;
    }
    /**
     * Sets Data Value
     */
    public void setData(int data) {
        this.data = data;
    }

    // Getter and setter for "left"
    /**
     * Gets Left node
     */
    public TNode getLeft() {
        return left;
    }
    /**
     * Sets Left Node
     */
    public void setLeft(TNode left) {
        this.left = left;
    }
    /**
     * Gets Right Node
     */
    public TNode getRight() {
        return right;
    }
    /**
     * sets Right Node
     */
    public void setRight(TNode right) {
        this.right = right;
    }

    /**
     * Gets Parent Node
     */
    public TNode getParent() {
        return parent;
    }
    /**
     * Sets Right Node
     */
    public void setParent(TNode parent) {
        this.parent = parent;
    }
    /**
     * Gets Node Balance
     */
    public int getBalance() {
        return balance;
    }
    /**
     * Sets Node Balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     * Prints node data
     */
    public void print(){
        System.out.println(String.format("Node data value is %d,", this.getData()));
    }


}
