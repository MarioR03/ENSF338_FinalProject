package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class StackLL extends SLL {

    /**
     * Default constructor that creates an empty StackLL
     */
    public StackLL() {
        super();
    }

    /**
     * Default constructor that creates a StackLL with one object
     * 
     * @param node a DNode object you wish to insert into the SLL
     */
    public StackLL(DNode node) {
        super(node);
    }

    /**
     * push
     * 
     * @param node - DNode object you wish to push to the top of the stack
     *             pushes an object to the top of stack
     */
    public void push(DNode node) {
        super.InsertHead(node);
    }

    /**
     * pop
     * 
     * @return - DNode object previously at the top of the stack
     *         deletes the the object at the top of the stack and returns it
     */
    public DNode pop() {
        DNode popDNode = this.head;
        super.DeleteHead();
        return popDNode;

    }

    /**
     * peek
     * 
     * @return - Object at the top of the stack
     *         returns the object at the top of the stack without deletion
     */
    public DNode peek() {
        return this.head;
    }

    /**
     * search
     * 
     * @param node - DNode object you wish to find
     * @return - The position at which the object is located on the stack, if the
     *         object is not on the stack, returns -1
     *         Searches through the StackLL and returns the location of the DNode
     *         wanted
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
     * @return - Boolean value representing if the StackLL is empty or not
     *         Checks if Stack is empty
     */
    public boolean empty() {
        return this.head == null;
    }

    /**
     * clear
     * Deletes every element in the StackLL and now it leaves you with an empty
     * stack
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
        StackLL stack = new StackLL();

        // Testing push method
        stack.push(new DNode(1));
        stack.push(new DNode(2));
        stack.push(new DNode(0));
        System.out.println("\n-----Testing out push method insertion-----");
        stack.Print();

        // Testing out the pop method
        DNode num = stack.pop();;
        System.out.println("\n-----Testing out pop method-----");
        stack.Print();
        System.out.println("Popped data: " + num.getData());

        // Pop until the stack is empty
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("\n-----Testing out pop method to clear the stack-----");
        stack.Print();

        // Testing out the second constructor
        stack = new StackLL(new DNode(10));
        System.out.println("\n-----Testing the second constructor for the stack-----");
        stack.Print();

        // Testing the peek method after a few pushes
        stack.push(new DNode(5));
        stack.push(new DNode(100));
        System.out.println("\n-----Testing the peek method for the stack-----");
        stack.Print();
        System.out.println("Peeked data: " + stack.peek().getData());

        // Searching for a node that exists
        int position = stack.search(new DNode(10));
        System.out.println("\n-----Searching for the position of the node with 10 as data (exists)-----");
        System.out.println("position: " + position);

        // Searching for a node that does not exit
        position = stack.search(new DNode(9));
        System.out.println("\n-----Searching for the position of the node with 9 as data (does not exist)-----");
        System.out.println("position: " + position);

        // Testing the clear method
        stack.clear();
        System.out.println("\n-----Testing the clear method for the stack-----");
        stack.Print();

        // Test the empty method with an empty stack
        System.out.println("\n-----Testing the empty method for the empty stack-----");
        System.out.println("empty? " + (stack.empty() ? "yes":"no"));

        // Test the empty method with an non empty stack
        stack.push(new DNode(50));
        System.out.println("\n-----Testing the empty method for the non empty stack-----");
        System.out.println("empty? " + (stack.empty() ? "yes":"no"));
    }
}
