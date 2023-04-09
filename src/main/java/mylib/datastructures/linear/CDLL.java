package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;


public class CDLL extends DLL {

    public CDLL() {
        super();
    }

    public CDLL(DNode node) {
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
        if (this.head == null) { // list is empty
            this.head = this.tail = node;
            node.setPrevious(node); // make it circular
            node.setNext(node);
            return;
        }

        if (isSorted()) { // list is sorted
            DNode current = this.head;
            while (current.getData() < node.getData() && current != this.tail) {
                current = current.getNext();
            }

            if (current == this.head) { // insert at head
                this.head = node;
            }

            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.getPrevious().setNext(node);
            current.setPrevious(node);

            if (node.getNext() == this.head) { // insert at tail
                this.tail = node;
            }
        } else { // list is not sorted
            Sort(); // sort the list first
            SortedInsert(node); // insert the node after sorting
        }
    }

    protected boolean isSorted() {
        if (this.head == null || this.head.getNext() == null) {
            return true;
        }
    
        DNode current = this.head.getNext();
        DNode prev = this.head;
        while(current != this.head){
            if(current.getData() < prev.getData()){
                return false;
            }
            current = current.getNext();
            prev = prev.getNext();
        }
        return true;
    }


    // search will use super class

    @Override
    public void DeleteHead() {
        super.DeleteHead();
        this.head.setPrevious(this.tail);
        this.tail.setNext(this.head);
    }

    @Override
    public void DeleteTail() {
        super.DeleteTail();
        this.tail.setNext(this.head);
        this.head.setPrevious(this.tail);
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
                temp = temp.getNext();
            }
        }
    }

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
                //take the node out
                prev.setNext(next);
                next.setPrevious(prev);
                if(prev.getNext() == this.head){
                    this.tail = prev;
                }
                //put it back into the most proper spot
                current.setNext(temp);
                current.setPrevious(temp.getPrevious());
                current.getPrevious().setNext(current);
                current.getNext().setPrevious(current);
                if(current.getPrevious() == this.tail){
                    this.head = current;
                }

                current = next;
            } else{
                current = current.getNext();
            }
        }
    }

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
    public String printAll() {
        return "head: " + this.head.getData() + " head.getNext(): " + head.getNext().getData() + " tail: "
                + this.tail.getData() + " tail.getNext(): " + this.tail.getNext().getData();
    }
}
