package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    /**
     * Default constructor that creates an empty CDLL
     */
    public CDLL() {
        super();
    }

    /**
     * Default constructor that creates a CDLL with one object
     * 
     * @param node a DNode object you wish to insert into the CDLL
     */
    public CDLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.head.setPrevious(node);
        this.tail.setNext(node);
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

    /**
     * InsertTail
     * 
     * @param node - DNode onject to be inserted at tail
     */
    @Override
    public void InsertTail(DNode node) {
        super.InsertTail(node);
        this.head.setPrevious(this.tail);
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

    /**
     * SortedInsert
     * 
     * @param node - DNode to be inserted in sorted linked list
     *             If linked list is not sorted, will sort the list and then insert
     *             the node into the sorted list
     */
    @Override
    public void SortedInsert(DNode node) {
        if (this.head == null) { // list is empty
            this.head = this.tail = node;
            node.setPrevious(node); // make it circular
            node.setNext(node);
            this.counter = 1;
            return;
        }

        if (isSorted()) { // list is sorted
            DNode current = this.head;
            if(node.getData() < this.head.getData()){ //Inserting at head
                node.setNext(this.head);
                node.setPrevious(this.tail);
                this.head.setPrevious(node);
                this.tail.setNext(node);
                this.head = node;
                this.counter++;
                return;
            }
            current = current.getNext();
            while(current.getData() < node.getData() && current != this.head){
                current = current.getNext();
            }
            if(current == this.head){ //Inserting at tail
                node.setNext(this.head);
                node.setPrevious(this.tail);
                this.head.setPrevious(node);
                this.tail.setNext(node);
                this.tail = node;
                this.counter++;
                return;
            }
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.setPrevious(node);
            node.getPrevious().setNext(node);
            this.counter++;

        } else { // list is not sorted
            Sort(); // sort the list first
            SortedInsert(node); // insert the node after sorting
        }
    }

    /**
     * isSorted
     * protected helper method used to check if the CDLL is sorted
     */
    protected boolean isSorted() {
        if (this.head == null || this.head.getNext() == null) {
            return true;
        }

        DNode current = this.head.getNext();
        DNode prev = this.head;
        while (current != this.head) {
            if (current.getData() < prev.getData()) {
                return false;
            }
            current = current.getNext();
            prev = prev.getNext();
        }
        return true;
    }

    // search will use super class

    /**
     * DeleteHead
     * Deletes DNode object at head
     */
    @Override
    public void DeleteHead() {
        if (this.counter == 0) {
            return;
        }
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.counter = 0;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
            this.counter--;
        }
    }

    /**
     * DeleteTail
     * Deletes node at tail
     */
    @Override
    public void DeleteTail() {
        if (this.counter == 0) {
            return;
        }
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.counter = 0;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
            this.counter--;
        }
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
                temp = temp.getNext();
            }
        }
    }

    /**
     * Sort
     * Uses insertion sort to sort the list
     */
    public void Sort() {
        if (this.counter == 0 || this.counter == 1) {
            // List is empty or has only one element, nothing to sort
            return;
        }

        DNode current = this.head.getNext(); // Start from second element

        while (current != this.head) {
            // Traverse the list from second element to last element

            DNode prev = current.getPrevious();
            DNode next = current.getNext();

            // Find the correct position to insert current element
            if (current.getData() < prev.getData()) {
                DNode temp = current;
                while (temp.getPrevious() != this.tail && current.getData() < temp.getPrevious().getData()) {
                    temp = temp.getPrevious();
                }
                // take the node out
                prev.setNext(next);
                next.setPrevious(prev);
                if (prev.getNext() == this.head) {
                    this.tail = prev;
                }
                // put it back into the most proper spot
                current.setNext(temp);
                current.setPrevious(temp.getPrevious());
                current.getPrevious().setNext(current);
                current.getNext().setPrevious(current);
                if (current.getPrevious() == this.tail) {
                    this.head = current;
                }

                current = next;
            } else {
                current = current.getNext();
            }
        }
    }

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
        if (current != null) {
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != this.head);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Create an instance of the class
        CDLL linkedList = new CDLL();

        // Testing out head an tail insertion
        linkedList.InsertHead(new DNode(0));
        linkedList.InsertHead(new DNode(1));
        linkedList.InsertTail(new DNode(4));
        System.out.println("\n-----Testing out head an tail insertion-----");
        linkedList.Print();

        // Testing out the other insertion
        linkedList.Insert(new DNode(3), 2);
        linkedList.Insert(new DNode(9), 4);
        System.out.println("\n-----Testing out the other insertion-----");
        linkedList.Print();

        // Testing out the delete methods
        linkedList.DeleteHead();
        linkedList.DeleteTail();
        System.out.println("\n-----Testing out the head and tail deletion-----");
        linkedList.Print();

        // Testing the other delete method
        linkedList.Delete(new DNode(3));
        System.out.println("\n-----Testing the other delete method-----");
        linkedList.Print();

        // Deleting until nothing left to delete
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        linkedList.DeleteHead();
        System.out.println("\n-----Deleting until nothing left in the LL-----");
        linkedList.Print();

        // Using the other constructor
        linkedList = new CDLL(new DNode(50));
        System.out.println("\n-----Testing the second constructor-----");
        linkedList.Print();

        // Testing the SortedInsert method
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
