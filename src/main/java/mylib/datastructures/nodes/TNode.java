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


}
