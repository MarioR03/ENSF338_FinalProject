package main.java.mylib.datastructures.nodes;

import main.java.mylib.datastructures.trees.BST;

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
     * @return - data from node (int)
     */
    public int getData() {
        return data;
    }
    /**
     * Sets Data Value
     * @param data - data for the node to hold (int)
     */
    public void setData(int data) {
        this.data = data;
    }

    // Getter and setter for "left"
    /**
     * Gets Left node
     * @return - TNode to the left of this TNode
     */
    public TNode getLeft() {
        return left;
    }
    /**
     * Sets Left Node
     * @param left - Sets left TNode for this TNode
     */
    public void setLeft(TNode left) {
        this.left = left;
    }
    /**
     * Gets Right Node
     * @return - TNode to the right of this TNode
     */
    public TNode getRight() {
        return right;
    }
    /**
     * sets Right Node
     * @param right - Sets right TNode for this TNode
     */
    public void setRight(TNode right) {
        this.right = right;
    }

    /**
     * Gets Parent Node
     * @return - Parent TNode
     */
    public TNode getParent() {
        return parent;
    }
    /**
     * Sets Parent Node
     * @param parent - New parent TNode
     */
    public void setParent(TNode parent) {
        this.parent = parent;
    }
    /**
     * Gets Node Balance
     * @return - balance of TNode
     */
    public int getBalance() {
        return balance;
    }
    /**
     * Sets Node Balance
     * @param balance - Sets the balance of the TNode
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

    public static void main(String[] args){
        System.out.println("Initializing a set of null nodes and assigning them values of 1,2,3");
        TNode nodeOne = new TNode();
        TNode nodeTwo = new TNode();
        TNode nodeThree = new TNode();
        nodeOne.setData(1);
        nodeTwo.setData(2);
        nodeThree.setData(3);
        System.out.println(String.format("nodeOne has data value %d",nodeOne.getData()));
        System.out.println(String.format("nodeTwo has data value %d",nodeTwo.getData()));
        System.out.println(String.format("nodeThree has data value %d",nodeThree.getData()));
        System.out.print("\n");
        System.out.println("------------------------------");
        System.out.println("Use Left/Right/Parent setters to establish 2 as the root, with 1 and 3 on the left and right");
        System.out.println("We will use BST PrintBF to test if the correct connections were made");
        nodeTwo.setLeft(nodeOne);
        nodeTwo.setRight(nodeThree);
        nodeOne.setParent(nodeTwo);
        nodeThree.setParent(nodeTwo);
        BST test = new BST(nodeTwo);
        test.printBF();
        System.out.print("\n");
        System.out.println("------------------------------");
        System.out.println("Add node using second constructor to establish node with value 5 below node of value 3");
        TNode nodeFive = new TNode(5,0,nodeThree,null,null);
        nodeThree.setRight(nodeFive);
        test.printBF();
    }

}
