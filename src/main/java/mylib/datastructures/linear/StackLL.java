package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class StackLL extends SLL {

    /**
     * Default constructor that creates an empty StackLL
     */
    public StackLL() {
        super();
    }
    /**
     * Default constructor that creates a StackLL with one object
     * @param node a DNode object you wish to insert into the SLL
     */
    public StackLL(DNode node){
        super(node);
    }

    /**
     * push
     * @param node - DNode object you wish to push to the top of the stack
     * pushes an object to the top of stack
     */
    public void push(DNode node) {
        super.InsertHead(node);
    }

    /**
     * pop
     * @return - DNode object previously at the top of the stack
     * deletes the the object at the top of the stack and returns it
     */
    public DNode pop() {
        DNode popDNode = this.head;
        super.DeleteHead();
        return popDNode;

    }

    /**
     * peek
     * @return - Object at the top of the stack
     * returns the object at the top of the stack without deletion
     */
    public DNode peek() {
        return this.head;
    }

    /**
     * search
     * @param node - DNode object you wish to find
     * @return - The position at which the object is located on the stack, if the object is not on the stack, returns -1
     * Searches through the StackLL and returns the location of the DNode wanted
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
     * @return - Boolean value representing if the StackLL is empty or not
     * Checks if Stack is empty
     */
    public boolean empty(){
        return this.head == null;
    }

    /**
     * clear
     * Deletes every element in the StackLL and now it leaves you with an empty stack
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
    public void InsertTail(DNode node){}
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
