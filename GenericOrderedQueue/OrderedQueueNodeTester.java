// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON
/**
 * Functions that test the OrderedQueueNode's constructor and instance methods.
 */
public class OrderedQueueNodeTester
{
    public static void main(String[] args)
    {
        System.out.println("-----------------------------------------\n");  
        
        // Creating nodes with previous and next null pointers
        OrderedQueueNode<Integer> node1 = new OrderedQueueNode<Integer>(1, null, null); 
        OrderedQueueNode<Integer> node2 = new OrderedQueueNode<Integer>(2, null, null); 
        OrderedQueueNode<Integer> node3 = new OrderedQueueNode<Integer>(3, null, null); 
        
        // Testing initial value of each node
        System.out.println("Testing initial value of each node: \n"); 
        
        System.out.println("Initial value of node 1: " + node1.getElement()); 
        System.out.println("Expected: 1\n"); 
        
        System.out.println("Initial value of node 2: " + node2.getElement()); 
        System.out.println("Expected: 2\n"); 
        
        System.out.println("Initial value of node 3: " + node3.getElement()); 
        System.out.println("Expected: 3\n"); 
        
        // Setter previous and next nodes for all nodes
        node1.setNewerNode(node2); // previous node will still be null
        
        node2.setOlderNode(node1); 
        node2.setNewerNode(node3); 
        
        node3.setOlderNode(node2); // next node will still be null 
        
        // Testing that previous and next nodes are set correctly
        // By getting the elements of the previous and next node of 
        // each created node
        System.out.println("Testing setters and getters for old and new node methods: \n"); 
        
        System.out.println("Value of the next node of node 1: " + node1.getNewerNode().getElement());
        System.out.println("Expected: 2\n");
        
        System.out.println("Value of the previous node of node 2: " + node2.getOlderNode().getElement()); 
        System.out.println("Expected: 1\n"); 
        
        System.out.println("Value of the next node of node 2: " + node2.getNewerNode().getElement());
        System.out.println("Expected: 3\n"); 
        
        System.out.println("Value of the previous node of node 3: " + node3.getOlderNode().getElement()); 
        System.out.println("Expected: 2\n"); 
        
        // Testing setElement method for all nodes created
        node1.setElement(4); 
        node2.setElement(5); 
        node3.setElement(6); 
        
        System.out.println("Testing set element method for all nodes: \n"); 
        System.out.println("New value of node 1: " + node1.getElement()); 
        System.out.println("Expected: 4\n"); 
        
        System.out.println("New value of node 2: " + node2.getElement()); 
        System.out.println("Expected: 5\n"); 
        
        System.out.println("New value of node 3: " + node3.getElement()); 
        System.out.println("Expected: 6\n"); 
        
        System.out.println("-----------------------------------------");  
    }
}
