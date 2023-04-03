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
        node.setNext(null);
        node.setPrevious(null);

        if (!isSorted()){
            this.Sort();
        }
        
        // Check if the list is empty or the new node's data is less than the head
        if (this.head == null || node.getData() < this.head.getData()) {
            node.setNext(this.head);
            this.head = node;
            if (this.tail == null) {
                this.tail = node;
            }
            //connecting the tail to the new head
            this.tail.setNext(this.head);

        } else {
            // Find the node in the list after which the new node should be inserted
            DNode temp = this.head;
            while (temp.getNext() != this.tail.getNext() && temp.getNext().getData() <= node.getData()) {
                temp = temp.getNext();
                temp.getNext().getData();
            }
            // Insert the new node after the found node
            node.setNext(temp.getNext());
            temp.setNext(node);
            if (node.getNext() == this.head) {
                this.tail = node;
            }
        }
        this.counter++;
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
                if(previous.getNext() == this.head){
                    this.tail = previous;
                }
                //something wrong here
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

    //these are used for tests==
    public int getHead(){
        return this.head.getData();
    }
    public int getTail(){
        return this.tail.getData();
    }
}

