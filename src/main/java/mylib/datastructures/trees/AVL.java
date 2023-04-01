package main.java.mylib.datastructures.trees;
import main.java.mylib.datastructures.nodes.TNode;

import java.util.ArrayList;

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
        this.root = node;

        //read all nodes under root into array

        // for all nodes in array{

        // add one node into AVl

        // check and rebalance if needed

        //}
    }

    // Gets all nodes under a node, ordered by height
    private ArrayList<TNode> getALlChildren(TNode node){

        return new ArrayList<>();
    }

    // balances tree
    private void balance(){

    }

}
