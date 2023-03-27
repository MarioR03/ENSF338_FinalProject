package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class SLL {
    DNode head;
    int counter;

    //Contructors
    public SLL() {
        this.head = null;
        this.counter = 0;
    }

    public SLL(DNode node) {
        this.head = node;
        this.counter = 1;
    }

    // Insertions
    public void tailInsert(DNode node) {
        if (this.counter == 0) {
            this.head = node;
        } else {
            DNode last = this.head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
        this.counter++;
    }

    public void tailInsert(int data) {
        DNode node = new DNode(data);
        if (this.counter == 0) {
            this.head = node;
        } else {
            DNode last = this.head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
        this.counter++;
    }

    public void headInsert(DNode node) {
        if (this.counter == 0) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.counter++;
    }

    public void headInsert(int data) {
        DNode node = new DNode(data);
        if (this.counter == 0) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.counter++;
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
        node.setNext(temp.getNext());
        temp.setNext(node);
        this.counter++;
    }

    public void midInsert(int data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.counter) { // Incase they try to put a node in a position further out than the
                                                 // last
            // position
            throw new IndexOutOfBoundsException();
        }

        DNode node = new DNode(data);
        DNode temp = this.head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        this.counter++;
    }

    // Deletions
    public void headDelete() {
        // If the list is empty, do nothing
        if (this.head == null) {
            return;
        }
        // If the list has only one element, set head to null
        if (this.head.getNext() == null) {
            this.head = null;
            this.counter = 0;
            return;
        } else {
            this.head = this.head.getNext();
            this.counter--;
        }
    }

    public void tailDelete() {
        // If the list is empty, do nothing
        if (this.head == null) {
            return;
        }
        // If the list has only one element, set head to null
        if (this.head.getNext() == null) {
            this.head = null;
            this.counter = 0;
            return;
        }
        // Otherwise iterate through the list to find the second-to-last node
        DNode temp = this.head;
        for (int i = 0; i < this.counter - 2; i++) {
            temp = temp.getNext();
        }
        // Set the next pointer of the second-to-last node to null
        temp.setNext(null);
        // Decrement the counter
        this.counter--;
    }

    public void midDelete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.counter) {
            // The index is out of bounds, so throw an exception
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            // If the index is 0, call headDelete() to delete the head node
            headDelete();
        } else {
            // Find the node immediately before the node to be deleted
            DNode prevNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.getNext();
            }
            // Set the next pointer of the previous node to skip over the node to be deleted
            prevNode.setNext(prevNode.getNext().getNext());
            // Decrement the counter to reflect the removal of a node
            this.counter--;
        }
    }

    // THIS IS TO CLEAT TO WHOLE LL
    public void clear() {
        // Set the head pointer to null, effectively removing all nodes from the list
        this.head = null;
        // Reset the counter to zero to indicate an empty list
        this.counter = 0;
    }

    //THIS IS TO RETRIEVE DATA
    public int getDataAtIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.counter) {
            // The index is out of bounds, so throw an exception
            throw new IndexOutOfBoundsException();
        } else {
            // Find the node at the given index
            DNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            // Return the data stored in the node
            return node.getData();
        }
    }
    public int getLength(){
        return this.counter;
    }



}