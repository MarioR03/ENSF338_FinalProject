package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL extends SLL {

    // Contructor
    public DLL() {
        super();
    }

    public DLL(DNode node) {
        super(node);
    }

    @Override
    public void InsertHead(DNode node) {
        // If the list is empty
        if (this.counter == 0) {
            node.setNext(null);
            node.setPrevious(null);
            this.head = node;
            this.tail = node;
        } else {
            this.head.setPrevious(node); // set previous node of head to new node
            node.setNext(this.head); // set next node to current head
            node.setPrevious(null); // node is new head, should not have a previous
            this.head = node;
        }
        this.counter++;
    }

    // Insertions
    @Override
    public void InsertTail(DNode node) {
        if (this.counter == 0) {
            node.setNext(null);
            node.setPrevious(null);
            this.head = node;
            this.tail = node;
        } else {
            node.setPrevious(this.tail); // set previous of new node to tail
            this.tail.setNext(node); // set next of tail to new node
            this.tail = node; // set tail to new node
            node.setNext(null);
        }
        counter++;
    }

    @Override
    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > this.counter) { // Incase they try to put a node in a position further out than
                                                       // the last
            // position
            throw new IndexOutOfBoundsException();
        }

        node.setNext(null);
        node.setPrevious(null);
        if (position == 0) { // inserting at the beginning of the list
            node.setNext(this.head);
            this.head = node;
            if (this.counter == 0) {
                // the list was empty before, so update the tail pointer
                this.tail = node;
            } else {
                node.getNext().setPrevious(node);
            }
        } else if (position == this.counter) { // inserting at the end of the list
            if (this.counter == 0) {
                // the list was empty before, so set both head and tail to the new node
                this.head = node;
                this.tail = node;
            } else {
                // update the next pointer of the current tail node to point to the new node
                this.tail.setNext(node);
                node.setPrevious(this.tail);
                // update the tail pointer to the new node
                this.tail = node;
            }
        } else { // inserting in the middle of the list
            DNode temp = this.head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext()); // node <-> the one after temp
            temp.getNext().setPrevious(node);

            temp.setNext(node); // temp <-> node
            node.setPrevious(temp); // temp <-> node <-> the one after temp
        }
        this.counter++;
    }

    @Override
    public void SortedInsert(DNode node) {
        node.setNext(null);
        node.setPrevious(null);

        if (!isSorted()) {
            this.Sort();
        }

        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else if (node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.head = node;
        } else {
            // Find the node in the list after which the new node should be inserted
            DNode temp = this.head;
            while (temp.getNext() != null && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            // Insert the new node after the found node
            if (temp.getNext() != null) {
                node.setNext(temp.getNext());
                temp.getNext().setPrevious(node);
                temp.setNext(node);
                node.setPrevious(temp);
            } else {
                temp.setNext(node);
                node.setPrevious(temp);
                this.tail = node;
            }
        }
        this.counter++;
    }

    // Search will just use the superclass

    // Deletions
    @Override
    public void DeleteHead() {
        super.DeleteHead();
        if (this.head != null) {
            this.head.setPrevious(null);
        }
    }

    @Override
    public void DeleteTail() {
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

    @Override
    public void Delete(DNode node) {
        // Check if the node is the head
        if (this.head.getData() == node.getData()) {
            this.DeleteHead();
        } else if (this.tail.getData() == node.getData()) {
            // Check if the node is the tail
            this.DeleteTail();
        } else {
            // Check anywhere else in the list
            DNode temp = this.head;
            for (int i = 0; i < this.counter - 1; i++) {
                if (temp.getData() == node.getData()) {
                    DNode previousDNode = temp.getPrevious();
                    previousDNode.setNext(temp.getNext());
                    previousDNode.getNext().setPrevious(previousDNode);
                    this.counter--;
                    return;
                }
            }
        }
    }

    @Override
    public void Sort() {
        // If the list is empty or has only one node, it is already sorted
        if (this.head == null || this.head.getNext() == null || this.isSorted()) {
            return;
        }

        DNode current = this.head.getNext();
        DNode prev = this.head;
        while (current != null) {
            if (current.getData() < prev.getData()) {
                // Remove the current node from the list
                prev.setNext(current.getNext());
                if (current.getNext() != null){
                    current.getNext().setPrevious(prev);
                }
                // Insert the current node at the right position

                if (current.getData() < this.head.getData()) {
                    InsertHead(current);
                    this.counter--;
                } else {
                    // Find the node in the list after which the new node should be inserted
                    DNode temp = this.head;
                    while (temp.getNext() != null && temp.getNext().getData() <= current.getData()) {
                        temp = temp.getNext();
                    }
                    // Insert the new node after the found node
                    // If only place to insert is tail
                    if (temp.getNext() == null) {
                        InsertTail(current);
                    } else {
                        current.setNext(temp.getNext());
                        current.setPrevious(temp);
                        temp.getNext().setPrevious(current);
                        temp.setNext(current);
                    }
                }

                // Update the tail pointer if necessary
                if (prev.getNext() == null) {
                    this.tail = prev;
                }

                // Update the current node to the next node
                current = prev.getNext();
            } else {
                // Move to the next node
                prev = current;
                current = current.getNext();
            }
        }
    }

    // Print uses the super class
}
