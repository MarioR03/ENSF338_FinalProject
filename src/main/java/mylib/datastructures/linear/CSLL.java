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
        if (this.counter == 0) {
            this.head = node;
            this.tail = node;
            this.tail.setNext(this.head);
            this.counter++;
            return;
        }
        if (!isSorted()) {
            Sort();
        }
        DNode current = this.head;
        DNode prev = this.tail;
        boolean inserted = false;
        do {
            if (node.getData() <= current.getData()) {
                node.setNext(current);
                prev.setNext(node);
                inserted = true;
                if (current == this.head) {
                    this.head = node;
                }
                break;
            }
            prev = current;
            current = current.getNext();
        } while (current != this.head);
        if (!inserted) {
            this.tail.setNext(node);
            node.setNext(this.head);
            this.tail = node;
        }
        this.counter++;
    }

    @Override
    protected boolean isSorted() {
        int count = this.counter;
        if (count == 0 || count == 1) {
            return true;
        }
        DNode current = this.head;
        do {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        } while (current.getNext() != this.head);
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
        if (this.isSorted()) {
            return;
        }
        DNode current = this.head.getNext();
        while (current != head) {
            DNode temp = this.head;
            while (temp != current) {
                if (temp.getData() > current.getData()) {
                    int tempData = current.getData();
                    current.setData(temp.getData());
                    temp.setData(tempData);
                }
                temp = temp.getNext();
            }
            current = current.getNext();
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

    // these are used for tests==
    public String printAll() {
        return "head: " + this.head.getData() + " head.getNext(): " + head.getNext().getData() + " tail: "
                + this.tail.getData() + " tail.getNext(): " + this.tail.getNext().getData();
    }

    public int getTail() {
        return this.tail.getData();
    }

}
