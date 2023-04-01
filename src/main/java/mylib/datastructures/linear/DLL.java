package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL extends SLL {
    private DNode head;
    private DNode tail;
    private int counter;

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

        if (this.counter == 0) {
            this.head = node;
            this.tail = node;
        } else {
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
        } else {
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
        midInsert(node, index);
    }

    // Deletions

    public void deleteHead() {
        super.deleteHead();
        this.head.setPrevious(null);
    }

    public void deleteTail() {
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
            deleteHead();
        } else if (index == this.counter - 1) {
            // If the index is the last element, just call tailDelete()
            deleteTail();
        } else {
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


    public void Clear() {
        super.Clear();
        this.tail = null;
    }
    public DNode Search(DNode node){
       DNode searchNode = super.Search(node);
        return searchNode;
    }

    public void Sort(){
        // If the list is empty or has only one node, it is already sorted
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        DNode current = this.head;

        while(current != null){

           DNode previous = current.getPrevious();

           // If the previous node is less than current node, then current node does not move
           if(previous.getData() < current.getData()){
               current = current.getNext();
               continue;
           }
            // Travel back down the list until we find a node that has a smaller value than current node
           while(previous.getPrevious() != null && current.getData() < previous.getData())
               previous = previous.getPrevious();

           // Saves the next node to work on as current node will be moved
           DNode temp = current.getNext();

            //Sets the nodes before and after current to point to each other
            current.getNext().setPrevious(current.getPrevious());
            current.getPrevious().setNext(current.getNext());

           // This means we are at the start of the list and make the current node the new head
           if(previous.getData() > current.getData()){
            current.setPrevious(null);      // null <-- current      previous
            current.setNext(previous);      // null <-- current  --> previous
            previous.setPrevious(current);  // null <-- current <--> previous
               this.head = current;
           }
           else{
               // Insert the node into its new location inside the list
               current.setNext(previous.getNext());     //previous      current  --> previous.next
               current.setPrevious(previous);           //previous <--  current  --> previous.next
               current.getNext().setPrevious(current);  //previous <--  current <--> previous.next
               previous.setNext(current);               //previous <--  current <--> previous.next
           }
           // Move to unsorted node in list
           current = temp;
        }



    }

    public void sortedInsert(DNode node) {
        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null || node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head = node;
            node.setPrevious(null);
        }
        else{
            DNode temp = this.head;
            while (temp.getNext() != null && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            // Insert the new node after the found node
            temp.getNext().setPrevious(node); // temp      node <--- temp.getNext
            node.setNext(temp.getNext());     // temp      node <--> temp.getNext
            temp.setNext(node);               // temp ---> node <--> temp.getNext
            node.setPrevious(temp);           // temp <--> node <--> temp.getNext

        }
        this.counter++;

    }

    public void Print(){
        super.Print();
    }


}



