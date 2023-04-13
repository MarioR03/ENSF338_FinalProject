package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * Represents a Linked List based Queue
 */
public class QueueLL extends SLL {
    /**
     * Default constructor that creates an empty QueueLL
     */
    public QueueLL() {
        super();
    }

    /**
     * Default constructor that creates a QueueLL with one object
     * 
     * @param node a DNode object you wish to insert into the QueueLL
     */
    public QueueLL(DNode node) {
        super(node);
    }

    /**
     * Inserts the given node at the tail of the queue.
     * 
     * @param node the node to enqueue
     */
    public void enqueue(DNode node) {
        super.InsertTail(node);
    }

    /**
     * dequeue
     * 
     * @return - node that was dequeued
     */
    public DNode dequeue() {

        DNode node = this.head;
        super.DeleteHead();
        return node;
    }

    /**
     * peek
     * 
     * @return - head of the queue
     */
    public DNode peek() {
        return this.head;
    }

    /**
     * search
     * 
     * @param node - DNode object you are looking for
     * @return - value that is to be searched for in queue, -1 if not found
     */
    public int search(DNode node) {
        DNode current = this.head;
        for (int i = 0; i < this.counter; i++) {
            if (current != null && node.getData() == current.getData()) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    /**
     * empty
     * 
     * @return - boolean value that tells you if the list is empty or not
     */
    public boolean empty() {
        return this.head == null;
    }

    /**
     * Deletes every element in the QueueLL and leaves you with an empty QueueLL
     */
    public void clear() {
        super.Clear();
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void InsertHead(DNode node) {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void InsertTail(DNode node) {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Insert(DNode node, int position) {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void SortedInsert(DNode node) {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void DeleteHead() {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void DeleteTail() {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Delete(DNode node) {
    }

    /**
     * Does nothing as this is not a proper method for a QueueLL
     */
    @Override
    public void Sort() {
    }

    public static void main(String[] args) {
        // Create an instance of the class
        QueueLL queue = new QueueLL();

        // Testing out enqueue
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(0));
        System.out.println("\n-----Testing out enqueue method insertion-----");
        queue.Print();

        // Testing out the dequeue return value
        DNode node = queue.dequeue();
        System.out.println("\n-----Testing out dequeue method return-----");
        queue.Print();
        System.out.println("Dequeued data: " + node.getData());

        // Dequeue until the Queue is empty
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("\n-----Testing the dequeue method to clear the queue");
        queue.Print();

        // Testing out the second constructor
        queue = new QueueLL(new DNode(10));
        System.out.println("\n-----Testing the second constructor for the queue-----");
        queue.Print();

        // Testing the peek method after a few enqueues
        queue.enqueue(new DNode(5));
        queue.enqueue(new DNode(100));
        System.out.println("\n-----Testing the peek method for the queue-----");
        queue.Print();
        System.out.println("Peeked data: " + queue.peek().getData());

        // Searching for a node that exists
        int position = queue.search(new DNode(5));
        System.out.println("\n-----Searching for the position of the node with 5 as data (exists)-----");
        System.out.println("position: " + position);

        // Searching for a node that does not exit
        position = queue.search(new DNode(9));
        System.out.println("\n-----Searching for the position of the node with 9 as data (does not exist)-----");
        System.out.println("position: " + position);

        // Testing the clear method
        queue.clear();
        System.out.println("\n-----Testing the clear method for the queue-----");
        queue.Print();

        // Test the empty method with an empty queue
        System.out.println("\n-----Testing the empty method for the empty queue-----");
        System.out.println("empty? " + (queue.empty() ? "yes" : "no"));

        // Test the empty method with an non empty queue
        queue.enqueue(new DNode(50));
        System.out.println("\n-----Testing the empty method for the non empty queue-----");
        System.out.println("empty? " + (queue.empty() ? "yes" : "no"));
    }
}
