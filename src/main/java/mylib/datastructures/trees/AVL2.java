package main.java.mylib.datastructures.trees;
import main.java.mylib.datastructures.nodes.TNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class AVL2 extends BST {

    private TNode root;
    public AVL2(){
        this.root = null;
    }
    public AVL2(int val){
        TNode constructorNode = new TNode();
        constructorNode.setData(val);
        this.root = constructorNode;
    }

    public AVL2(TNode node){
        //Create an array of all nodes, first the root node, then all of its children
        ArrayList<TNode> allNodes = getAllChildren(node);
        //Set the corresponding root node to the new root
        this.root = allNodes.get(0);
        //Iteratively add the new nodes, balancing the tree each time
        for(int i = 0; i < allNodes.size();i++){
            //Insert a node into the tree

            Insert(allNodes.get(i));
            //Node imbalance is only relevant two levels up in this case, so check if node has grandparent
//            if(allNodes.get(i).getParent() != null && allNodes.get(i).getParent().getParent() != null){
//                //Check grandparent for node balance
//                Boolean nodeBalance = checkBalance(allNodes.get(i).getParent().getParent());
//                if(nodeBalance){
//                    balanceRotation(allNodes.get(i));
//                }
//
//            }
            }

        }
    public TNode getRoot(){
        return this.root;
    }

    public void setRoot(TNode node){
        super.setRoot(node);

    }

    public void Insert(int val){
        super.Insert(val);

    }

    public void Insert(TNode node){
        super.Insert(node);

        TNode pivotNode = node;

        //Find the pivot node for this insertion
        while(pivotNode.getBalance() == 0 && pivotNode.getParent() != null){
            pivotNode = pivotNode.getParent();
        }

        // Case 1: no pivot node exists, tree is balanced.

        if(pivotNode.getBalance() == 0) {
            // Get parent of inserted node, travel up tree updating balance factors

            TNode updateBalanceFactorNode = node.getParent();
            while (updateBalanceFactorNode != null) {

                // get balance factor of current node
                int currentBalanceFactor = updateBalanceFactorNode.getBalance();

                if (updateBalanceFactorNode.getData() >= node.getData()) {
                    updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);


                }

                else {
                    updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);

                }
                updateBalanceFactorNode = updateBalanceFactorNode.getParent();
            }
        }
            // Case 2, we are adding to the shorter subtree of an unbalanced tree, bringing it closer to balance

            // this long condition is just a compact way of saying we are in case 2 if:
            // Pivot == +1 and inserted node < pivot node, or Pivot == -1 and inserted node > pivot node,
            // as provided in the lecture notes

            else if((pivotNode.getBalance() == 1 && (node.getData() < pivotNode.getData())) || (pivotNode.getBalance() == -1 && (node.getData() >= pivotNode.getData()))){

                TNode updateBalanceFactorNode = node.getParent();
                int currentBalanceFactor = updateBalanceFactorNode.getBalance();

                //This block covers an edge case where a node is added to the root
                if(updateBalanceFactorNode == pivotNode) {
                    if (updateBalanceFactorNode.getData() >= node.getData())
                        updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);
                    else {
                        updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);
                    }
                }


                while (updateBalanceFactorNode != pivotNode) {

                // get balance factor of current node
                if (updateBalanceFactorNode.getData() >= node.getData())
                    updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);
                else {
                    updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);
                }
                updateBalanceFactorNode = updateBalanceFactorNode.getParent();
            }
        }

            //case 3, adding a node to the outside subtree. Rebalance is needed.
            else{

                TNode updateBalanceFactorNode = node.getParent();
            int currentBalanceFactor = updateBalanceFactorNode.getBalance();
            while (updateBalanceFactorNode != pivotNode) {

                // get balance factor of current node
                if (updateBalanceFactorNode.getData() >= node.getData())
                    updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);
                else {
                    updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);
                }
                updateBalanceFactorNode = updateBalanceFactorNode.getParent();
            }


                // Get the ancestor node, if there is one

                TNode ancestor = null;
                if(pivotNode.getParent() != null)
                    ancestor = pivotNode.getParent();

                // Get the child of the pivotNode on the way to the inserted node
                TNode son = node;
                while(son.getParent() != pivotNode){
                    son = son.getParent();
                }
                // Get the grandson node of the pivot
                TNode grandson = node;
                while(grandson.getParent() != son){
                grandson = grandson.getParent();
                }

            // This decides what type of rotation we must do, from avl tree lecture slides
            if (son.getBalance() == 1) { // right heavy

                if(treeHeight(son.getLeft()) - treeHeight(son.getRight()) < 0) { // --> outside --> case 3a
                            lRotate(pivotNode,ancestor,son,node);
                } else { // --> inside --> case 3b
                    rlRotate(pivotNode,ancestor,son,grandson,node);
                }
            } else if (son.getBalance() == -1) { // left heavy
                if (treeHeight(son.getLeft()) - treeHeight(son.getRight()) > 0){ // --> outside --> case 3a
                    rRotate(pivotNode,ancestor,son,node);
                }
                else { // --> inside --> case 3b
                    lrRotate(pivotNode,ancestor,grandson,son,node);
                }
            }
        }
    }
    // performs a left rotation
    private void lRotate(TNode pivot,TNode ancestor, TNode son,TNode insert){
        // If pivot is root

        if(ancestor == null){
        son.setLeft(pivot);
        pivot.setParent(son);
        pivot.setRight(null);
        setRoot(son);
        son.setParent(null);
        }
        else{
            ancestor.setRight(son);
            son.setParent(ancestor);

            pivot.setRight(son.getLeft());

            son.setLeft(pivot);
            pivot.setParent(son);
        }
        pivot.setBalance(0);
        TNode updateBalanceFactorNode = insert.getParent();
        while (updateBalanceFactorNode != null) {

            // get balance factor of current node
            int currentBalanceFactor = updateBalanceFactorNode.getBalance();

            if (updateBalanceFactorNode.getData() >= insert.getData()) {
                updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);


            }

            else {
                updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);

            }
            updateBalanceFactorNode = updateBalanceFactorNode.getParent();
        }





    }
    // performs a right rotation
        private void rRotate(TNode pivot,TNode ancestor, TNode son, TNode insert){

        // If pivot is root

        if(ancestor == null){
        son.setRight(pivot);
        pivot.setParent(son);
        pivot.setLeft(null);
        setRoot(son);
        son.setParent(null);
        }
        else{
            ancestor.setLeft(son);
            son.setParent(ancestor);
            pivot.setLeft(son.getRight());
            son.setRight(pivot);
            pivot.setParent(son);
        }
        pivot.setBalance(0);
        TNode updateBalanceFactorNode = insert.getParent();
        while (updateBalanceFactorNode != null) {

            // get balance factor of current node
            int currentBalanceFactor = updateBalanceFactorNode.getBalance();

            if (updateBalanceFactorNode.getData() >= insert.getData()) {
                updateBalanceFactorNode.setBalance(currentBalanceFactor - 1);


            }

            else {
                updateBalanceFactorNode.setBalance(currentBalanceFactor + 1);

            }
            updateBalanceFactorNode = updateBalanceFactorNode.getParent();
        }
    }
    //performs a left-right rotation, as outlined by the steps in the lecture slides
    private void lrRotate(TNode pivotNode,TNode ancestor,TNode grandson,TNode son,TNode node){
        pivotNode.setLeft(grandson);
        grandson.setParent(pivotNode);

        if(grandson.getLeft() != null)
            son.setRight(grandson.getLeft());
        grandson.getLeft().setParent(son);

        grandson.setLeft(son);
        son.setParent(grandson);

        if(ancestor == null)
            setRoot(grandson);

        else if(pivotNode.getData() > ancestor.getData()) {
            ancestor.setLeft(grandson);
            grandson.setParent(ancestor);
        }
        else{
            ancestor.setRight(grandson);
            grandson.setParent(ancestor);
        }
        if(grandson.getRight() != null){
            pivotNode.setLeft(grandson.getRight());
            grandson.getRight().setParent(pivotNode);
        }
        grandson.setRight(pivotNode);
        pivotNode.setParent(grandson);

        //If inserted node < grandson, set pivot to -1
        if (treeHeight((node.getRight())) - treeHeight(node.getLeft()) < treeHeight((grandson.getRight())) - treeHeight(grandson.getLeft())) {
            pivotNode.setBalance(-1);
        }
        else{
            pivotNode.setBalance(0);
            son.setBalance(1);
        }

    }
   //performs a right-left rotation, as outlined by the steps in the lecture slides
    private void rlRotate(TNode pivotNode,TNode ancestor,TNode grandson,TNode son,TNode node) {
        pivotNode.setRight(grandson);
        grandson.setParent(pivotNode);

        if (grandson.getRight() != null)
            son.setLeft(grandson.getRight());
        grandson.getRight().setParent(son);

        grandson.setRight(son);
        son.setParent(grandson);

        if (ancestor == null)
            setRoot(grandson);

        else if (pivotNode.getData() > ancestor.getData()) {
            ancestor.setRight(grandson);
            grandson.setParent(ancestor);
        } else {
            ancestor.setLeft(grandson);
            grandson.setParent(ancestor);
        }
        if (grandson.getLeft() != null) {
            pivotNode.setRight(grandson.getLeft());
            grandson.getLeft().setParent(pivotNode);
        }
        grandson.setLeft(pivotNode);
        pivotNode.setParent(grandson);

        //If inserted node > grandson, set pivot to -1
        if (treeHeight((node.getRight())) - treeHeight(node.getLeft()) > treeHeight((grandson.getRight())) - treeHeight(grandson.getLeft())) {
            pivotNode.setBalance(-1);
        }
        else{
            pivotNode.setBalance(0);
            son.setBalance(1);
        }
    }


    public void Delete(int val){
    super.Delete(val);
    }
    public TNode Search(int val){
        return super.Search(val);
    }
    public void printInOrder(){
        super.printInOrder();
    }
    public void printBF(){
        super.printBF();
    }

    // Pulls all child nodes into an array of breadth first ordering into an array. These new nodes only share data values, they are otherwise new nodes
    public static ArrayList<TNode> getAllChildren(TNode node) {
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

    // Checks the balance of a node by finding the heights of the subtrees and seeing if the difference is greater than 1
    // A return of true means a rotation in the AVL tree must be made
    public boolean checkBalance(TNode node){
        if(node == null)
            return false;

        int leftHeight = treeHeight(node.getLeft());
        int rightHeight = treeHeight(node.getRight());
        int balance = leftHeight - rightHeight;

        if(balance > 1 || balance < -1){
            return true;
        }

        return false;
    }


    //Recursively finds the height of a node
    public static int treeHeight(TNode node){
        if(node == null){
            return 0;
        }
        else{
            int leftHeight = treeHeight(node.getLeft());
            int rightHeight = treeHeight(node.getRight());
            return (Math.max(leftHeight,rightHeight) + 1);
        }
    }

    public static void main(String[] args){

        BST tree = new BST();
        tree.Insert(1000);
        tree.Insert(10);
        tree.Insert(15);
        tree.Insert(5);
        tree.Insert(1);
        tree.Insert(6);
          tree.Insert(4);
          tree.Insert(5);
          tree.Insert(6);
          tree.Insert(3);
          tree.Insert(2);








        //ArrayList<TNode> array = getAllChildren(tree.getRoot());
        AVL2 newTree = new AVL2(tree.getRoot());
        newTree.printBF();



//        for(int i = 0; i < array.size();i++){
//            System.out.println(String.format("Node index %d has data member %d, parent pointer %s, left pointer %s, and right pointer %s",i,array.get(i).getData(),array.get(i).getParent(),array.get(i).getLeft(),array.get(i).getRight()));
//        }

    }

}
