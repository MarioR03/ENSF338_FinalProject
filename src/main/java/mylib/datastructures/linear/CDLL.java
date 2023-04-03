package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
        super();
        node.setNext(node);
        node.setPrevious(node);
    }

    @Override
    public void InsertHead(DNode node) {
        super.InsertHead(node);
        // find tail
        DNode temp = this.head;
        for (int i = 0; i < this.counter - 1; i++) {
            temp = temp.getNext();
        }
        this.tail = temp;

        // connect the ends together
        this.head.setPrevious(this.tail);
        this.tail.setNext(this.head);
    }

    @Override
    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.head.setPrevious(this.tail);
        this.tail.setNext(this.head);
    }

    @Override
    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > this.counter) { // Incase they try to put a node in a position further out than
                                                       // the last
            throw new IndexOutOfBoundsException();
        }
        // check if they want to insert at head
        if (position == 0) {
            this.InsertHead(node);

            // now check if htey want to insert at tail
        } else if (position == this.counter) {
            this.InsertTail(node);

            // last case is inserting inbetween
        } else {
            super.Insert(node, position);
        }
    }

    @Override
    public void SortedInsert(DNode node) {
        node.setNext(null);
        node.setPrevious(null);

        // if (!isSorted()) {
        // this.Sort();
        // }

        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.setNext(node);
            node.setPrevious(node);
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);

        } else if (node.getData() < this.head.getData()) {
            node.setNext(this.head);
            node.setPrevious(this.tail);
            this.head.setPrevious(node);
            this.tail.setNext(node);
            this.head = node;
        } else {
            // Find the node in the list after which the new node should be inserted
            DNode temp = this.head;
            while (temp.getNext() != this.head && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            // Insert the new node after the found node

            node.setNext(temp.getNext());
            temp.getNext().setPrevious(node);
            if(temp.getNext() == this.head){
                this.tail = node;
            }
            temp.setNext(node);
            node.setPrevious(temp);
        }
        this.counter++;
    }

    //search will use super class

    @Override
    public void DeleteHead(){
        super.DeleteHead();
        this.head.setPrevious(this.tail);
        this.tail.setNext(this.head);
    }

    @Override
    public void DeleteTail(){
        super.DeleteTail();
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
    }

    @Override
    public void Delete(DNode node){
        // Check if the node is the head
        if (this.head.getData() == node.getData()) {
            this.DeleteHead();
        } else if (this.tail.getData() == node.getData()) {
            // Check if the node is the tail
            this.DeleteTail();
        } else {
            // Check anywhere else in the list
            DNode temp = this.head;
            for (int i = 0; i < this.counter-1; i++) {
                if (temp.getData() == node.getData()) {
                    DNode previousDNode = temp.getPrevious();
                    previousDNode.setNext(temp.getNext());
                    previousDNode.getNext().setPrevious(previousDNode);
                    this.counter--;
                    return;
                }
                temp = temp.getNext();
            }
        }
    }

    public void Sort() {
        super.Sort();
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
    }

    @Override
    public void Print() {
        // Print the list length
        System.out.println("List length: " + this.counter);

        // // Determine the sorted status of the list
        // boolean sorted = this.isSorted();

        // // Print the sorted status
        // System.out.println("Sorted: " + (sorted ? "Yes" : "No"));

        // Print the list content
        System.out.print("List content: ");
        DNode current = this.head;
        if (current != null) {
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != this.head);
        }
        System.out.println();
    }
}
