package main.java.mylib.datastructures.trees;
import main.java.mylib.datastructures.nodes.TNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class AVL extends BST{

    private TNode root;

    public AVL(){
        this.root = null;
    }

    public AVL(int val){
        TNode constructorNode = new TNode();
        constructorNode.setData(val);
        this.root = constructorNode;
    }

    public AVL(TNode node) {

        //read all nodes under root into array. These nodes have the same data values but are not references to the old nodes children
        ArrayList<TNode> allNodes = getAllChildren(node);

        //set the root of the tree to the corresponding new node root and remove it from the list
        this.root = allNodes.get(0);
        this.root.setBalance(0);
        allNodes.remove(0);


        // for all remaining nodes in array{
        for(int i = 0; i < allNodes.size();i++){

        // add one node into AVl
            //System.out.println(allNodes.get(i).getData());
            Insert(allNodes.get(i));
            System.out.println(this.root.getLeft());
            // check and rebalance if needed

        }
    }


    public void Insert(TNode node){

        super.Insert(node);
        // At this point, node is added identically like a a Binary Search Tree

        node.setBalance(0);
        // For each parent node above added node, if value is greater than nodes data, decrememnt balance
        // If it is less than or equal to nodes data, incrememnt the balance
        TNode updateBalanceFactorNode = node.getParent();
        while(updateBalanceFactorNode != null){

            int currentBalanceFactor = updateBalanceFactorNode.getBalance();

            if(updateBalanceFactorNode.getData() > node.getData())
                updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);
            else{
                updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);
            }
            updateBalanceFactorNode = updateBalanceFactorNode.getParent();

        }



    }

    //Recursively finds the height of a node
//    public static int Height(TNode node) {
//        if (node == null) {
//            return 0;
//        }
//        System.out.println(node.getLeft());
//        int leftHeight = Height(node.getLeft());
//        int rightHeight = Height(node.getRight());
//        return Math.max(leftHeight, rightHeight) + 1;
//    }

    // Gets all nodes under a node, ordered by height.
    // Inserting into the AVL in this order should minimize pivoting needed
    private ArrayList<TNode> getAllChildren(TNode node) {
        if (node == null) {
            System.out.println("Argument passed has no nodes");
            throw new IllegalArgumentException();
        }
        // The queue is used to traverse the nodes breadth first, while the array will store the nodes in the order they come in
        ArrayList<TNode> nodeArray = new ArrayList<>();
        LinkedList<TNode> queue = new LinkedList<>();


        queue.add(node);

        while (queue.size() > 0) {

            // For each child, initialize a new node with the same data. This is so the new node is independent of the old node
            TNode current = queue.removeFirst();
            TNode nodeToAdd = new TNode();
            nodeToAdd.setData(current.getData());
            nodeArray.add(nodeToAdd);

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

        }
    return nodeArray;
    }


    // Updates the balance factors of ancestor nodes of the given node
    private void adjustBalanceNumbers(TNode node){


    }
    public TNode getRoot(){
        return this.root;
    }

public void printInOrder(){
        super.printInOrder();
}
    public void printBF(){
        super.printBF();
    }


}
