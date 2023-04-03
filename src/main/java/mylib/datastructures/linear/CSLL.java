package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CSLL extends SLL {
    // Does not use a tail pointer, only head

    public CSLL() {
        super();
    }

    public CSLL(DNode node) {
        this.head = node;
        this.tail = node;
        node.setNext(node);
        this.counter = 1;
    }

    @Override
    public void InsertHead(DNode node) {
        super.InsertHead(node);
        this.tail.setNext(this.head);
    }

    @Override
    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.tail.setNext(this.head);
    }

    @Override
    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        super.Insert(node, position);
        this.tail.setNext(this.head);
    }

    @Override
    public void SortedInsert(DNode node) {
        DNode current = this.head;
        this.counter++;

        // case 1, if the list is empty
        if (current == null) {
            node.setNext(node);
            this.head = node;
            this.tail = node;

        } else if (current.getData() >= node.getData()) {
            // the case when the value is smaller than head
            current = this.tail;

            current.setNext(node);
            node.setNext(this.head);
            this.head = node;
        } else {
            // Case 3
            while (current.getNext() != this.head && current.getNext().getData() < node.getData())
                current = current.getNext();
            node.setNext(current.getNext());
            current.setNext(node);
        }

        // Making sure the last element is connected to the tail pointer
        DNode temp = this.head;
        for (int i = 0; i < this.counter - 1; i++) {
            temp = temp.getNext();
        }
        this.tail = temp;

    }

    @Override
    protected boolean isSorted() {
        if (this.head == null || this.head.getNext() == null) {
            return true;
        }
        DNode current = this.head;
        for (int i = 0; i < this.counter - 1; i++) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    // Search will use the parent method

    @Override
    public void DeleteHead() {
        super.DeleteHead();
        this.tail.setNext(this.head);
    }

    @Override
    public void DeleteTail() {
        super.DeleteTail();
        this.tail.setNext(this.head);
        ;
    }

    @Override
    public void Delete(DNode node) {
        super.Delete(node);
        this.tail.setNext(this.head);
    }

    @Override
    public void Sort() {
        if (this.head == null || this.head.getNext() == null || isSorted()) {
            return;
        }

        // check if the tail is connected properly
        if (this.tail.getNext() != this.head) {
            this.tail.setNext(head);
        }

        DNode previous = this.head;
        DNode current = this.head.getNext();
        for (int i = 0; i < this.counter - 1; i++) {
            if (current.getData() < previous.getData()) {
                // take the object out
                if (current == this.tail) {
                    this.tail = previous;
                }
                previous.setNext(current.getNext());
                this.counter--;
                SortedInsert(current);
                current = previous.getNext();
            }else{
                current = current.getNext();
                previous = previous.getNext();
            }
        }
    }

    // Clear will use the parent method

    @Override
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
        for (int i = 0; i < this.counter; i++) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
