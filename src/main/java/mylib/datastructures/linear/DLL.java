package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL extends SLL {
    DNode head;
    DNode tail;
    int counter;

    //Contructor
    public DLL() {
        this.head = null;
        this.tail = null;
        this.counter = 0;
    }

    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.counter = 1;
    }

    // Insertions
    public void tailInsert(DNode node) {

        if(this.counter == 0) {
            this.head = node;
            this.tail = node;
        }
        else {
            node.setPrevious(this.tail);        // set previous of new node to tail
            this.tail.setNext(node);            // set next of tail to new node
            this.tail = node;                   // set tail to new node
        }
        counter++;
    }
    public void tailInsert(int data) {
        DNode node = new DNode(data);
        tailInsert(node);
    }

    public void headInsert(DNode node) {
        if (this.counter == 0) {
            this.head = node;
            this.tail = node;
        }
        else {
            this.head.setPrevious(node); // set previous node of head to new node
            node.setNext(this.head);     // set next node to current head
            node.setPrevious(null);      // node is new head, should not have a previous
            this.head = node;
        }
        this.counter++;
    }

    public void headInsert(int data) {
        DNode node = new DNode(data);
        headInsert(node);
    }

    public void midInsert(DNode node, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.counter) { // Incase they try to put a node in a position further out than the last
            // position
            throw new IndexOutOfBoundsException();
        }

        DNode temp = this.head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());       // node <-> the one after temp
        temp.getNext().setPrevious(node);

        temp.setNext(node);                 // temp <-> node
        node.setPrevious(temp);
        this.counter++;                     // temp <-> node <-> the one after temp
    }
    public void midInsert(int data, int index) throws IndexOutOfBoundsException {
        DNode node = new DNode(data);
        midInsert(node,index);
    }

    // Deletions
    @Override
    public void headDelete() {
    super.headDelete();
    this.head.setPrevious(null);
    }

    public void tailDelete(){
        // If the list is empty, do nothing
        if (this.head == null) {
            return;
        }
        // If the list has only one element, set head and tail to null
        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
            this.counter = 0;
            return;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
            this.counter--;
        }
    }

    public void midDelete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.counter) {
            // The index is out of bounds, so throw an exception
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            // If the index is 0, call headDelete() to delete the head node
            headDelete();
        }
        else if (index == this.counter - 1){
            // If the index is the last element, just call tailDelete()
            tailDelete();
        }
        else {
            // Find the node immediately before the node to be deleted
            DNode prevNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.getNext();
            }

            // Find node immediately after node to delete
            DNode afterNode = prevNode.getNext().getNext();

            //Set previous node to point after
            prevNode.setNext(afterNode);
            //Set node after to point to previous node
            afterNode.setPrevious(prevNode);

            // Decrement the counter to reflect the removal of a node
            this.counter--;
        }
    }

    @Override
    public void clear() {
        super.clear();
        this.tail = null;
    }
    @Override
    public int getDataAtIndex(int index) throws IndexOutOfBoundsException {
        return super.getDataAtIndex(index);
    }

    public int getCounter(){
        return super.getLength();
    }
}




