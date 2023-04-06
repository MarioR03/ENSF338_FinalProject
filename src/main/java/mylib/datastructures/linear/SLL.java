package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class SLL {
    protected DNode head;
    protected DNode tail;
    protected int counter;

    // Contructors
    public SLL() {
        this.head = null;
        this.tail = null;
        this.counter = 0;
    }

    public SLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.counter = 1;
    }

    // Insertions
    public void InsertHead(DNode node) {
        // If the list is empty
        if (this.counter == 0) {
            node.setNext(null);
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.counter++;
    }

    public void InsertTail(DNode node) {
        // If the list is empty
        if (this.counter == 0) {
            this.head = node;
            this.tail = node;
            // else the list is not empty
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.counter++;
    }

    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > this.counter) {
            throw new IndexOutOfBoundsException();
        }

        if (position == 0) { // inserting at the beginning of the list
            node.setNext(this.head);
            this.head = node;
            if (this.counter == 0) {
                // the list was empty before, so update the tail pointer
                this.tail = node;
            }
        } else if (position == this.counter) { // inserting at the end of the list
            if (this.counter == 0) {
                // the list was empty before, so set both head and tail to the new node
                this.head = node;
                this.tail = node;
            } else {
                // update the next pointer of the current tail node to point to the new node
                this.tail.setNext(node);
                // update the tail pointer to the new node
                this.tail = node;
            }
        } else { // inserting in the middle of the list
            DNode temp = this.head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        this.counter++;
    }

    public void SortedInsert(DNode node) {
        node.setNext(null);
        node.setPrevious(null);

        if (!isSorted()) {
            this.Sort();
        }

        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null || node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head = node;
            if (this.tail == null) {
                this.tail = node;
            }
        } else {
            // Find the node in the list after which the new node should be inserted
            DNode temp = this.head;
            while (temp.getNext() != this.tail.getNext() && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            // Insert the new node after the found node
            node.setNext(temp.getNext());
            temp.setNext(node);
            if (node.getNext() == null) {
                this.tail = node;
            }
        }
        this.counter++;
    }

    // helper function
    protected boolean isSorted() {
        if (this.head == null || this.head.getNext() == null) {
            return true;
        }
        DNode current = this.head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public DNode Search(DNode node) {
        DNode current = this.head;
        for (int i = 0; i < this.counter; i++) {
            if (node.getData() == current.getData()) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    // Deletions
    public void DeleteHead() {
        // If the list is empty, do nothing
        if (this.head == null) {
            return;
        }
        // If the list has only one element, set head to null
        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
            this.counter = 0;
            return;
        } else {
            this.head = this.head.getNext();
            this.counter--;
        }
    }

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
        }
        // Otherwise, iterate through the list to find the second-to-last node
        DNode temp = this.head;
        while (temp.getNext() != this.tail) {
            temp = temp.getNext();
        }
        // Set the tail pointer to the second-to-last node
        this.tail = temp;
        // Set the next pointer of the second-to-last node to null
        this.tail.setNext(null);
        // Decrement the counter
        this.counter--;
    }

    public void Delete(DNode node) {
        // Check if the node is the head
        if (this.head.getData() == node.getData()) {
            this.head = this.head.getNext();
            this.counter--;
            // If the list has only one element, update tail to null
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }

        // Check if the node is the tail
        if (this.tail.getData() == node.getData()) {
            // Find the second-to-last node
            DNode temp = this.head;
            for (int i = 0; i < this.counter - 2; i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            this.tail = temp;
            this.counter--;
            return;
        }

        // Check anywhere else in the list
        DNode prevNode = this.head;
        for (int i = 0; i < this.counter - 1; i++) {
            DNode current = prevNode.getNext();
            if (current.getData() == node.getData()) {
                prevNode.setNext(current.getNext());
                this.counter--;
                return;
            }
            prevNode = prevNode.getNext();
        }
    }

    public void Sort() {
        // If the list is empty or has only one node, it is already sorted
        if (this.head == null || this.head.getNext() == null || this.isSorted()) {
            return;
        }

        DNode current = this.head.getNext();
        DNode prev = this.head;
        while (current != this.tail.getNext()) {
            if (current.getData() < prev.getData()) {
                // Remove the current node from the list
                prev.setNext(current.getNext());
                this.counter--;
                // Insert the current node at the right position

                SortedInsert(current);

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

    // THIS IS TO CLEAR THE WHOLE LL
    public void Clear() {
        // Set the head pointer to null, effectively removing all nodes from the list
        this.head = null;
        this.tail = null;
        // Reset the counter to zero to indicate an empty list
        this.counter = 0;
    }

    public void Print() {
        // Print the list length
        System.out.println("List length: " + this.counter);

        // Determine the sorted status of the list
        boolean sorted = this.isSorted();

        // Print the sorted status
        System.out.println("Sorted: " + (sorted ? "Yes" : "No"));

        // Print the list content
        System.out.print("List content: ");
        DNode current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
