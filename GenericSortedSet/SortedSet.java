// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Create a doubly linked data structure that stores elements in a sorted set.
 */
public class SortedSet<E extends Comparable<E>>
{
    // INSTANCE VARIABLES
    private int size;
    private SortedSetNode<E> smallestValueNode;
    private SortedSetNode<E> largestValueNode;

    // CONSTRUCTORS
    public SortedSet()
    {
        size = 0;
        smallestValueNode = null;
        largestValueNode = null;
    }

    public SortedSet(E[] elementArray)
    {
        for (E element: elementArray)
        {
            add(element);
        }
    }

    public SortedSet(SortedSet<E> sortedSet)
    {
        SortedSetNode<E> currentNode = new SortedSetNode<E>(sortedSet.smallestValueNode.getElement(), null, sortedSet.smallestValueNode.getGreaterThanNode());

        while (currentNode != null)
        {
            add(currentNode.getElement());
            currentNode = currentNode.getGreaterThanNode();
        }
    }

    // INSTANCE METHODS
    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public E getSmallestValue()
    {
        if (size == 0)
        {
            return null;
        }

        return smallestValueNode.getElement();
    }

    public E getLargestValue()
    {
        if (size == 0)
        {
            return null;
        }

        return largestValueNode.getElement();
    }

    public boolean contains(E element)
    {
        if (size > 0)
        {
            SortedSetNode<E> currentNode = new SortedSetNode<E>(smallestValueNode.getElement(), null, smallestValueNode.getGreaterThanNode());
    
            while (currentNode != null)
            {
                if (currentNode.getElement() == element)
                {
                    return true;
                }
    
                currentNode = currentNode.getGreaterThanNode();
            }
        }
        
        return false;
    }

    public boolean containsAll(E[] elementArray)
    {
        for (E element: elementArray)
        {
            if (!contains(element))
            {
                return false;
            }
        }

        return true;
    }

    public boolean containsAll(SortedSet<E> sortedSet)
    {
        return containsAll(sortedSet.toArray());
    }

    public E[] toArray()
    {
        E[] sortedSetAsArray = (E[]) new Comparable[size];
        
        if (size > 0)
        {
            SortedSetNode<E> currentNode = new SortedSetNode<E>(smallestValueNode.getElement(), null, smallestValueNode.getGreaterThanNode());
    
            int currentIndexOfArray = 0;
            while (currentNode != null)
            {
                sortedSetAsArray[currentIndexOfArray] = currentNode.getElement();
    
                currentNode = currentNode.getGreaterThanNode();
                currentIndexOfArray++;
            }
        }
        
        return sortedSetAsArray;
    }

    public void add(E element)
    {
        if (!contains(element))
        {
            SortedSetNode<E> newNode = new SortedSetNode<E>(element, null, null);
    
            SortedSetNode<E> currentNode;
    
            // If list is empty
            if (smallestValueNode == null)
            {
                smallestValueNode = newNode;
                largestValueNode = newNode;
            }
    
            // Or if the node needs to be placed at the beginning
            else if (element.compareTo(smallestValueNode.getElement()) < 0)
            {   
                newNode.setGreaterThanNode(smallestValueNode);
                smallestValueNode.setLessThanNode(newNode);
    
                smallestValueNode = newNode;
            }
            else
            {
                currentNode = smallestValueNode;
    
                // Locate the node to the right of the position you want to place the new node in.
                while (currentNode.getGreaterThanNode() != null &&
                currentNode.getGreaterThanNode().getElement().compareTo(element) < 0)
                {
                    currentNode = currentNode.getGreaterThanNode();
                }
    
                // Link the nodes
                newNode.setGreaterThanNode(currentNode.getGreaterThanNode());
    
                if (newNode.getGreaterThanNode() != null)
                {
                    newNode.getGreaterThanNode().setLessThanNode(newNode);             
                }
    
                if (currentNode.getGreaterThanNode() == null)
                {
                    largestValueNode = newNode;
                }
    
                currentNode.setGreaterThanNode(newNode);
                newNode.setLessThanNode(currentNode);
            }
    
            size++;
        }
    }

    public void addAll(E[] elementArray)
    {
        for (E element: elementArray)
        {
            add(element);
        }
    }

    public void addAll(SortedSet<E> sortedSet)
    {
        addAll(sortedSet.toArray());
    }

    public E removeSmallestValue() throws NoSuchElementException
    {
        E smallestValue = smallestValueNode.getElement();

        if (size == 0)
        {
            throw new NoSuchElementException("Cannot remove the smallest value from an empty set.");
        }

        if (size == 1) {
            smallestValueNode = null;
            largestValueNode = null;
        }
        else
        {
            smallestValueNode = smallestValueNode.getGreaterThanNode();
            smallestValueNode.setLessThanNode(null);
        }

        size--;
        return smallestValue;
    }

    public E removeLargestValue() throws NoSuchElementException
    {
        E largestValue = largestValueNode.getElement();

        if (size == 0)
        {
            throw new NoSuchElementException("Cannot remove the smallest value from an empty set.");
        }

        if (size == 1) {
            smallestValueNode = null;
            largestValueNode = null;
        }
        else
        {
            largestValueNode = largestValueNode.getLessThanNode();
            largestValueNode.setGreaterThanNode(null);
        }

        size--;
        return largestValue;
    }

    public void remove(E element) throws NoSuchElementException
    {
        boolean removed = false;

        if (smallestValueNode == null)
        {
            throw new NoSuchElementException("Cannot remove an element from an empty set.");
        }

        SortedSetNode<E> currentNode = new SortedSetNode<E>(smallestValueNode.getElement(), null, smallestValueNode.getGreaterThanNode());

        // Traverse the set
        while (currentNode != null && !removed)
        {
            // Compare currentNode to element
            if (currentNode.getElement() == element)
            {
                // Delete node by making the node less than current node point to currentNode's greater node.     
                if (currentNode.getLessThanNode() == null)
                {
                    removeSmallestValue();
                }
                else if (currentNode.getGreaterThanNode() == null)
                {
                    removeLargestValue();
                }
                else
                {
                    currentNode.getGreaterThanNode().setLessThanNode(currentNode.getLessThanNode());
                    currentNode.getLessThanNode().setGreaterThanNode(currentNode.getGreaterThanNode());
                }

                removed = true;
                size--;
            }
            else
            {
                currentNode = currentNode.getGreaterThanNode();
            }
        }
    }

    public void removeAll(E[] elementArray)
    {
        for (E element: elementArray) 
        {
            remove(element);
        }
    }

    public void removeAll(SortedSet<E> sortedSet)
    {
        removeAll(sortedSet.toArray());
    }

    public void replace(E originalValue, E newValue) throws NoSuchElementException
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Cannot replace a value in an empty set.");
        }

        SortedSetNode<E> currentNode = new SortedSetNode<E>(smallestValueNode.getElement(), null, smallestValueNode.getGreaterThanNode());

        boolean replaced = false;
        while (currentNode != null && !replaced)
        {
            if (currentNode.getElement() == originalValue)
            {
                currentNode.setElement(newValue);
                replaced = true;
            }

            currentNode = currentNode.getGreaterThanNode();
        }
    }

    public void clear()
    {
        size = 0;
        smallestValueNode = null;
        largestValueNode = null;
    }

    public void saveToFile(String filename) throws IOException, IllegalArgumentException
    {
        if (!filename.endsWith(".txt"))
        {
            throw new IllegalArgumentException("Filename must end with .txt");
        }
        
        PrintWriter output = new PrintWriter(filename);
        SortedSetNode<E> currentNode = new SortedSetNode<E>(smallestValueNode.getElement(), null, smallestValueNode.getGreaterThanNode());

        while (currentNode != null)
        {
            output.println(currentNode.getElement());
            currentNode = currentNode.getGreaterThanNode();
        }

        output.close();
    }
}
