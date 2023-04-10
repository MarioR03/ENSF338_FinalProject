package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * Represents a Linked List based Queue
 */
public class QueueLL extends SLL{
    /**
     * Default constructor that creates an empty QueueLL
     */
    public QueueLL(){
        super();
    }
    /**
     * Default constructor that creates a QueueLL with one object
     * @param node a DNode object you wish to insert into the QueueLL
     */
    public QueueLL(DNode node){
        super(node);
    }
    /**
     * Inserts the given node at the tail of the queue.
     * 
     * @param node the node to enqueue
     */
    public void enqueue(DNode node){
        super.InsertTail(node);
    }
    /**
     * dequeue
     * @return - node that was dequeued
     */
    public DNode dequeue(){

        DNode node = this.head;
        super.DeleteHead();
        return node;
    }
    /**
     * peek
     * @return - head of the queue
     */
    public DNode peek(){
        return this.head;
    }
    /**
     * search
     * @param node - DNode object you are looking for
     * @return - value that is to be searched for in queue, -1 if not found
     */
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
    /**
     * empty
     * @return - boolean value that tells you if the list is empty or not
     */
    public boolean empty(){
        return this.head == null;
    }
    /**
     * Deletes every element in the QueueLL and leaves you with an empty QueueLL
     */
    public void clear(){
        super.Clear();
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void InsertHead(DNode node) {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void InsertTail(DNode node) {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Insert(DNode node, int position){}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void SortedInsert(DNode node) {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void DeleteHead() {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void DeleteTail() {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Delete(DNode node) {}
    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Sort() {}
}
