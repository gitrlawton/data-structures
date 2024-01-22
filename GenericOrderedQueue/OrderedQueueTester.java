// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON

import java.io.IOException;
/**
 * Functions that test the OrderedQueue's default constructor, overloaded 
 * constructor and its instance methods.
 */
public class OrderedQueueTester
{
    public static void main(String[] args)
    {
        // Create an instance of OrderedQueue using default constructor
        OrderedQueue<Integer> myQueue = new OrderedQueue<>();
        // Create an instance of OrderedQueue using overloaded constructor
        OrderedQueue<Integer> otherQueue = new OrderedQueue<Integer>(myQueue);

        // Test getSize() on an empty queue
        System.out.println("Size of the queue: " + myQueue.getSize());

        // Test isEmpty() method
        System.out.println("Is the queue empty? " + myQueue.isEmpty());

        // Test add() method
        myQueue.add(10);
        myQueue.add(5);
        myQueue.add(8);
        otherQueue.add(5);
        otherQueue.add(8);
        System.out.println("Size after adding elements: " + myQueue.getSize());

        // Test contains() method
        System.out.println("Contains 5: " + myQueue.contains(5));
        System.out.println("Contains 15: " + myQueue.contains(15));

        // Test getOldestValue() and getNewestValue() methods
        System.out.println("Oldest value: " + myQueue.getOldestValue());
        System.out.println("Newest value: " + myQueue.getNewestValue());

        // Test containsAll() method
        System.out.println("Contains all elements from the other queue? " + myQueue.containsAll(otherQueue));

        // Test addAll(array) method
        Integer[] elementsToAdd = {15, 20, 25};
        myQueue.addAll(elementsToAdd);
        System.out.println("Size after adding all elements from the array: " + myQueue.getSize());

        // Test addAll(otherQueue)
        myQueue.addAll(otherQueue);
        System.out.println("Size after adding all elements from otherQueue: " + myQueue.getSize());
        
        // Test removeOldestValue() method
        Integer removedOldestValue = myQueue.removeOldestValue();
        System.out.println("Removed oldest value: " + removedOldestValue);
        System.out.println("Size after removing the oldest value: " + myQueue.getSize());

        // Test removeNewestValue() method
        Integer removedNewestValue = myQueue.removeNewestValue();
        System.out.println("Removed newest value: " + removedNewestValue);
        System.out.println("Size after removing the newest value: " + myQueue.getSize());

        // Test remove() method
        myQueue.remove(8);
        System.out.println("Size after removing a specific element: " + myQueue.getSize());

        // Test removeAll(array) method
        Integer[] elementsToRemove = {10, 15};
        myQueue.removeAll(elementsToRemove);
        System.out.println("Size after removing all elements in array from myQueue: " + myQueue.getSize());
        
        // Test removeAll(otherQueue) method
        myQueue.removeAll(otherQueue);
        System.out.println("Size after removing all otherQueue elements from myQueue: " + myQueue.getSize());

        // Test replace() method
        myQueue.replace(5, 50);
        System.out.println("Newest value after replacement: " + myQueue.getNewestValue());

        // Test clear() method
        myQueue.clear();
        System.out.println("Size after clearing the queue: " + myQueue.getSize());

        // Test saveToFile() method
        try {
            myQueue.saveTofile("output.txt");
            System.out.println("Saved to file successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
