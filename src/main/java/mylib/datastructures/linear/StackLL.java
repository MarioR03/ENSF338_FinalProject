package main.java.mylib.datastructures.linear;

import javax.swing.text.Position;

import main.java.mylib.datastructures.nodes.DNode;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }
    public StackLL(DNode node){
        super(node);
    }

    public void push(DNode node) {
        super.InsertHead(node);
    }

    public DNode pop() {
        DNode popDNode = this.head;
        super.DeleteHead();
        return popDNode;

    }

    public DNode peek() {
        return this.head;
    }

    public int search(DNode node){
        DNode current = this.head;
        for(int i=0; i < this.counter; i++){
            if(current != null && node.getData() == current.getData()){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public boolean empty(){
        return this.head == null;
    }

    public void clear(){
        super.Clear();
    }
    @Override
    public void InsertHead(DNode node) {}
    @Override
    public void InsertTail(DNode node){}
    @Override
    public void Insert(DNode node, int position){}
    @Override
    public void SortedInsert(DNode node) {}
    @Override
    public void DeleteHead() {}
    @Override
    public void DeleteTail() {}
    @Override
    public void Delete(DNode node) {}
    @Override
    public void Sort() {}
}
