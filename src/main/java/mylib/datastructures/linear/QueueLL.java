package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class QueueLL extends SLL{
    public QueueLL(){
        super();
    }
    public QueueLL(DNode node){
        super(node);
    }

    public void enqueue(DNode node){
        super.InsertTail(node);
    }
    public DNode dequeue(){

        DNode node = this.head;
        super.DeleteHead();
        return node;
    }
    public DNode peek(){
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
    public void InsertTail(DNode node) {}
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