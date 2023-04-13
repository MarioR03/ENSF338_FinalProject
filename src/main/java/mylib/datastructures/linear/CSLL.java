package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CSLL extends SLL {

    /**
     * Default constructor that creates an empty CSLL
     */
    public CSLL() {
        super();
    }

    /**
     * Default constructor that creates a CSLL with one object
     * 
     * @param node a DNode object you wish to insert into the CSLL
     */
    public CSLL(DNode node) {
        this.head = node;
        this.tail = node;
        node.setNext(node);
        this.counter = 1;
    }

    /**
     * InsertHead
     * 
     * @param node - DNode onject to be inserted at head
     */
    @Override
    public void InsertHead(DNode node) {
        super.InsertHead(node);
        this.tail.setNext(this.head);
    }

    /**
     * InsertTail
     * 
     * @param node - DNode onject to be inserted at tail
     */
    @Override
    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.tail.setNext(this.head);
    }

    /**
     * Insert
     * 
     * @param node     - DNode object to be inserted
     * @param position - index of insertion position
     */
    @Override
    public void Insert(DNode node, int position) throws IndexOutOfBoundsException {
        super.Insert(node, position);
        this.tail.setNext(this.head);
    }

    /**
     * SortedInsert
     * 
     * @param node - DNode to be inserted in sorted linked list
     *             If linked list is not soarted, will sort the list and then insert
     *             the node into the sorted list
     */
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

    /**
     * isSorted
     * 
     * @return - true or false depending on if list is sorted
     *         private helper function
     */
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

    /**
     * DeleteHead
     * Deletes DNode object at head
     */
    @Override
    public void DeleteHead() {
        super.DeleteHead();
        this.tail.setNext(this.head);
    }

    /**
     * DeleteTail
     * Deletes node at tail
     */
    @Override
    public void DeleteTail() {
        super.DeleteTail();
        this.tail.setNext(this.head);
        ;
    }

    /**
     * Delete
     * 
     * @param node - Deletes DNode object from linked list
     *             Searches through the list to find the node with the same data and
     *             deletes it
     *             If the node is not found then nothing happens
     */
    @Override
    public void Delete(DNode node) {
        super.Delete(node);
        this.tail.setNext(this.head);
    }

    /**
     * Sort
     * Uses insertion sort to sort the list
     */
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

    /**
     * Print
     * Prints linked list to terminal
     * Prints if the linked list is sorted or not
     */
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
    public static void main(String[] args){
        //Create an instance of the class
        CSLL linkedList = new CSLL();

        //Testing out head an tail insertion
        linkedList.InsertHead(new DNode(0));
        linkedList.InsertHead(new DNode(1));
        linkedList.InsertTail(new DNode(4));
        System.out.println("\n-----Testing out head an tail insertion-----");
        linkedList.Print();

        //Testing out the other insertion
        linkedList.Insert(new DNode(3), 2);
        linkedList.Insert(new DNode(9), 4);
        System.out.println("\n-----Testing out the other insertion-----");
        linkedList.Print();

        //Testing out the delete methods
        linkedList.DeleteHead();
        linkedList.DeleteTail();
        System.out.println("\n-----Testing out the head and tail deletion-----");
        linkedList.Print();

        //Testing the other delete method
        linkedList.Delete(new DNode(3));
        System.out.println("\n-----Testing the other delete method-----");
        linkedList.Print();

        //Deleting until nothing left to delete
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        System.out.println("\n-----Deleting until nothing left in the LL-----");
        linkedList.Print();


        //Using the other constructor
        linkedList = new CSLL(new DNode(50));
        System.out.println("\n-----Testing the second constructor-----");
        linkedList.Print();

        //Testing the SortedInsert method
        linkedList.SortedInsert(new DNode(34));
        linkedList.SortedInsert(new DNode(2));
        linkedList.SortedInsert(new DNode(53));
        linkedList.SortedInsert(new DNode(12));
        System.out.println("\n-----Testing the SortedInsert method-----");
        linkedList.Print();

        //Testing the clear method
        linkedList.Clear();
        System.out.println("\n-----Testing the Clear method-----");
        linkedList.Print();

        //Testing the Sort method
        linkedList.InsertHead(new DNode(10));
        linkedList.InsertHead(new DNode(5));
        linkedList.InsertHead(new DNode(15));
        linkedList.InsertHead(new DNode(1));
        linkedList.InsertHead(new DNode(20));
        linkedList.Sort();
        System.out.println("\n-----Testing the Sort method-----");
        linkedList.Print();

        //CLEARING and then testing out InsertionSort on an unsorted list
        linkedList.Clear();
        linkedList.InsertHead(new DNode(0));
        linkedList.InsertHead(new DNode(1));
        linkedList.InsertHead(new DNode(2));
        linkedList.InsertHead(new DNode(4));
        linkedList.InsertHead(new DNode(5));
        linkedList.SortedInsert(new DNode(3));
        System.out.println("\n-----Testing InsertionSort on an unsorted list-----");
        linkedList.Print();
    }
}
