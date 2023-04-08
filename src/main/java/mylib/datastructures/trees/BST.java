package main.java.mylib.datastructures.trees;
import main.java.mylib.datastructures.nodes.TNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
    private TNode root;

    public BST(){
        this.root = null;
    }
    public BST(int val){
        TNode constructorNode = new TNode();
        constructorNode.setData(val);
        this.root = constructorNode;
    }
    public BST(TNode node){
        this.root = node;
    }

    public void Insert(int val){
        // Initialize new Node
        TNode newNode = new TNode();
        newNode.setData(val);

        TNode current = this.root;
        TNode previous = null;

        //Find the bottom of the tree where the node should be added
        while(current != null) {
            if (val <= current.getData()){
                previous = current;
                current = current.getLeft();}
            else {
                previous = current;
                current = current.getRight();
            }
        }
        // Add new node

            if(this.root == null){
                this.root = newNode;}

            else if(val <= previous.getData()){
                previous.setLeft(newNode);
                newNode.setParent(previous);
            }
            else{
                previous.setRight(newNode);
                newNode.setParent(previous);
            }
            }


        public void Insert(TNode node){

            // Initialize new Node
            TNode newNode = node;
            int val = newNode.getData();

            TNode current = this.root;
            TNode previous = null;

            //Find the bottom of the tree where the node should be added
            while(current != null) {
                if (val <= current.getData()){
                    previous = current;
                    current = current.getLeft();}
                else {
                    previous = current;
                    current = current.getRight();
                }
            }
            // Add new node

            if(this.root == null){
                this.root = newNode;}

            else if(val <= previous.getData()){
                previous.setLeft(newNode);
                newNode.setParent(previous);
            }
            else{
                previous.setRight(newNode);
                newNode.setParent(previous);
            }
        }
        public void Delete(int val){

        TNode nodeToDelete = Search(val);
        if(nodeToDelete == null){
            System.out.println(String.format("Node with value %d could not be found to delete.", val));
            return;
        }
        TNode parentOfDeleted = nodeToDelete.getParent();



        // If deleting a leaf node,set parent to child pointer to null
        if(nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            if (parentOfDeleted.getLeft() == nodeToDelete) {
                parentOfDeleted.setLeft(null);
            } else {
                parentOfDeleted.setRight(null);
            }
            }
        // If deleting node with one child, set parent nodes pointer to deleted nodes child

        //If child is on the left
        else if(nodeToDelete.getLeft() != null && nodeToDelete.getRight() == null){
            // If deleted node is a left child
            if (parentOfDeleted.getLeft() == nodeToDelete) {
                nodeToDelete.getLeft().setParent(parentOfDeleted);
                parentOfDeleted.setLeft(nodeToDelete.getLeft());
            // If deleted node is a right child
            }
            else {
                nodeToDelete.getLeft().setParent(parentOfDeleted);
                parentOfDeleted.setRight(nodeToDelete.getLeft());
            }

        }
        // if child is on the right
        else if(nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null){

            if (parentOfDeleted.getLeft() == nodeToDelete) {
                nodeToDelete.getRight().setParent(parentOfDeleted);
                parentOfDeleted.setLeft(nodeToDelete.getRight());
            }
            else {
                nodeToDelete.getRight().setParent(parentOfDeleted);
                parentOfDeleted.setRight(nodeToDelete.getRight());
            }
        }

        // Node to delete has two child nodes, swap the deleted node for the smallest node underneath it
        else{
            // Find smallest node in right subtree
            TNode current = nodeToDelete.getRight();


            while(current.getLeft() != null){
                current = current.getLeft();
            }

            //disconnect smallest node from tree

            //If current is the closest right node
            if(current.getParent() == nodeToDelete){
                current.setLeft(nodeToDelete.getLeft());
                current.getLeft().setParent(current);

            }
            // set children of new node to node that will be deleted
            else {
                current.getParent().setLeft(null);
                current.setRight(nodeToDelete.getRight());
                current.getRight().setParent(current);

                current.setLeft(nodeToDelete.getLeft());
                current.getLeft().setParent(current);

                }


            //check if deleted node was a left or right node



            if(parentOfDeleted.getLeft() == nodeToDelete){
                parentOfDeleted.setLeft(current);
                current.setParent(parentOfDeleted);
            }
            else{
                parentOfDeleted.setRight(current);
                current.setParent(parentOfDeleted);
            }


        }


    }

        public TNode Search(int val){

        TNode current = this.root;
        if(current == null){
            System.out.println("Cannot delete, tree is empty");
            return null;
        }
        while(current != null){

            if(current.getData() == val){

                return current;
            }
            else if(val < current.getData()){
                current = current.getLeft();

            }
            else{
                current = current.getRight();
            }
        }
        return null;
        }

        // Checks if the root is null, and calls method that prints all values in ascending order
        public void printInOrder(){
        if(this.root == null){
            System.out.println("Tree has no nodes to print");
        }
        else{
            System.out.println("Nodes in ascending order:");
            inOrderRecursion(this.root);
        }

        }

        // A recursive depth first search method provided in the notes
        public void inOrderRecursion(TNode node){
        if(node != null){
            inOrderRecursion(node.getLeft());
            System.out.println(node.getData());
            inOrderRecursion(node.getRight());
        }

        }

        // A breadth first implementation provided in the notes. Prints each line of the tree
        public void printBF(){
            if(this.root == null){
                System.out.println("Tree has no nodes to print");
            }
            // For printing each level of tree on a new line


            LinkedList<TNode> queue = new LinkedList<>();
            int currentHeight = 0;
            System.out.println("Root Node");
            queue.add(this.root);
            while(queue.size() > 0){

                TNode current = queue.removeFirst();

                int nodeHeight = getNodeHeight(current);
                //System.out.println(String.format("Node Height is %d",nodeHeight));
                //System.out.println(String.format("Current Height is %d",currentHeight));
                if(nodeHeight > currentHeight) {
                    System.out.print("\n");
                    System.out.println(String.format("Level %d", currentHeight+1));

                    currentHeight++;

                }



                System.out.print(current.getData());
                System.out.print("\t");

                if(current.getLeft() != null){

                    queue.add(current.getLeft());
                }
                if (current.getRight() != null){

                    queue.add(current.getRight());
                }

            }
        }

        public int getNodeHeight(TNode node){
            int nodeHeight = 0;
            while(node.getParent() != null){
                nodeHeight++;
                node = node.getParent();
            }
            return nodeHeight;

        }
        public TNode getRoot(){
        return this.root;
        }
        public void setRoot(TNode node){
        this.root = node;
        }

        public static void main(String[] args){

        BST tree = new BST();
        TNode five  = new TNode();
        five.setData(5);
            TNode one  = new TNode();
            one.setData(1);
            TNode three  = new TNode();
            three.setData(3);
            TNode seven  = new TNode();
            seven.setData(7);

            tree.Insert(five);
            tree.Insert(three);
            tree.Insert(one);
            tree.Insert(seven);

        //tree.printBF();
            // System.out.println(three.getLeft().getData());







        }


}


    

