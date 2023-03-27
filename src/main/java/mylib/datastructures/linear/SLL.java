package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class SLL {
    DNode head;
    int counter;

    // Contructors
    public SLL() {
        this.head = null;
        this.counter = 0;
    }

    public SLL(DNode node) {
        this.head = node;
        this.counter = 1;
    }

    // Insertions
    public void InsertTail(DNode node) {
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

    public void InsertTail(int data) {
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

    public void InsertHead(DNode node) {
        if (this.counter == 0) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.counter++;
    }

    public void InsertHead(int data) {
        DNode node = new DNode(data);
        if (this.counter == 0) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.counter++;
    }

    public void Insert(DNode node, int index) throws IndexOutOfBoundsException { // Can they put something at position
                                                                                   // zero?
        if (index < 0 || index > this.counter) { // Incase they try to put a node in a position further out than the
                                                 // last
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

    public void Insert(int data, int index) throws IndexOutOfBoundsException {
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
    public void DeleteHead() {
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

    public void DeleteTail() {
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
        // Otherwisem iterate thriugh the list to find the second-to-last node
        DNode temp = this.head;
        for (int i = 0; i < this.counter - 2; i++) {
            temp = temp.getNext();
        }
        // Set the next pointer of the second-to-last node to null
        temp.setNext(null);
        // Decrement the counter
        this.counter--;
    }

    public void Delete(DNode node) {
        // Check if the node is the head
        if (this.head.getData() == node.getData()) {
            this.head = this.head.getNext();
            this.counter--;
            return;
        } else {// check anywhere else
            DNode prevNode = this.head;
            for (int i = 0; i < this.counter; i++) {
                DNode current = prevNode.getNext();
                if (current.getData() == node.getData()) {
                    prevNode.setNext(current.getNext());
                    this.counter--;
                    return;
                }
                prevNode = prevNode.getNext();
            }
            return;
        }
    }

    // THIS IS TO CLEAR THE WHOLE LL
    public void Clear() {
        // Set the head pointer to null, effectively removing all nodes from the list
        this.head = null;
        // Reset the counter to zero to indicate an empty list
        this.counter = 0;
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

    public void Sort() {
        // If the list is empty or has only one node, it is already sorted
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        DNode current = this.head.getNext();
        DNode prev = this.head;
        while (current != null) {
            if (current.getData() < prev.getData()) {
                // Remove the current node from the list
                prev.setNext(current.getNext());
                // Insert the current node at the right position
                this.SortedInsert(current);
                // Update the current node to the next node
                current = prev.getNext();
            } else {
                // Move to the next node
                prev = current;
                current = current.getNext();
            }
        }

        // Set the head of the list to the first node
        DNode newHead = this.head.getNext();
        this.head.setNext(null);
        this.head = newHead;
    }

    public void SortedInsert(DNode node) {
        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null || node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head = node;
        } else {
            // Find the node in the list after which the new node should be inserted
            DNode temp = this.head;
            while (temp.getNext() != null && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
            }
            // Insert the new node after the found node
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        this.counter++;
    }
    public void Print() {
        // Print the list length
        System.out.println("List length: " + this.counter);
    
        // Determine the sorted status of the list
        boolean sorted = true;
        DNode current = this.head;
        while (current != null && current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                sorted = false;
                break;
            }
            current = current.getNext();
        }
    
        // Print the sorted status
        System.out.println("Sorted: " + (sorted ? "Yes" : "No"));
    
        // Print the list content
        System.out.print("List content: ");
        current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    

}
