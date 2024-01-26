// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON

import java.util.NoSuchElementException; 
import java.io.IOException; 
import java.io.PrintWriter; 

/**
 * Create a doubly linked queue data structure that stores elements in 
 * the order that they were inserted.
 */
public class OrderedQueue<E>
{
    // INSTANCE VARIABLES
    private int size;
    private OrderedQueueNode<E> oldestNode;
    private OrderedQueueNode<E> newestNode;
    
    // CONSTRUCTORS
    public OrderedQueue()
    {
        this.size = 0; 
        this.oldestNode = null; 
        this.newestNode = null; 
    }
    
    public OrderedQueue(OrderedQueue<E> orderedQueue)
    {
        this.size = orderedQueue.size; 
        this.oldestNode = orderedQueue.oldestNode; 
        this.newestNode = orderedQueue.newestNode; 
    }
    
    // INSTANCE METHODS
    public int getSize()
    {
        return this.size; 
    }
    
    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return (true); 
        }
        return (false); 
    }
    
    public OrderedQueueNode<E> getOldestNode()
    {
        if (size == 0)
        {
            return (null); 
        }
        
        return oldestNode; 
    }
    
    public E getOldestValue()
    {
        if (size == 0)
        {
            return (null); 
        }
        return oldestNode.getElement(); 
    }
    
    public E getNewestValue()
    {
        if (size == 0)
        {
            return (null); 
        }
        return newestNode.getElement(); 
    }
    
    public boolean contains(E element)
    {
        if (size > 0)
        {
            OrderedQueueNode<E> currentNode = oldestNode; 
            while(currentNode != null)
            {
                if (currentNode.getElement() == element)
                {
                    return (true); 
                }
                currentNode = currentNode.getNewerNode(); 
            }
        }
        return (false); 
    }
    
    public boolean containsAll(OrderedQueue<E> orderedQueue)
    {
        OrderedQueueNode<E> currentNode = orderedQueue.oldestNode;
        
        while (currentNode != null)
        {
            if (!contains(currentNode.getElement()))
            {
                return false;
            }
            currentNode = currentNode.getNewerNode();
        }
        
        return true;
    }
    
    public void add(E element)
    {
        OrderedQueueNode<E> newNode = new OrderedQueueNode<E>(element, null, null);
        
        if (size == 0)
        {
            newestNode = newNode;
            oldestNode = newNode;
            size++;
        }
        else
        {
            OrderedQueueNode<E> previouslyNewestNode = newestNode; 
            newestNode = newNode;
            newestNode.setOlderNode(previouslyNewestNode);
            previouslyNewestNode.setNewerNode(newestNode);
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
    
    public void addAll(OrderedQueue<E> orderedQueue)
    {
        OrderedQueueNode<E> currentNode = orderedQueue.oldestNode; 
        while(currentNode != null)
        {
            add(currentNode.getElement()); 
            currentNode = currentNode.getNewerNode(); 
        }
    }
    
    public E removeOldestValue() throws NoSuchElementException
    {
        if (this.size == 0)
        {
            throw new NoSuchElementException("Can not remove from an empty queue"); 
        }
        else 
        {
            E oldestValue = getOldestValue(); 
            if (this.size == 1)
            {
                this.oldestNode = null; 
                this.newestNode = null; 
            }
            else
            {
                this.oldestNode = this.oldestNode.getNewerNode(); 
                this.oldestNode.setOlderNode(null); 
            }
            this.size--; 
            return (oldestValue); 
        }
    }
    
    public E removeNewestValue() throws NoSuchElementException
    {
        if (this.size == 0)
        {
            throw new NoSuchElementException("Can not remove from an empty queue"); 
        }
        else if (this.size == 1)
        {
            return (removeOldestValue()); 
        }
        else
        {
            E newestValue = getNewestValue(); 
            
            OrderedQueueNode<E> currentNode = this.newestNode.getOlderNode(); 
            currentNode.setNewerNode(null); 
            
            this.newestNode.setOlderNode(null); 
            this.newestNode = currentNode; 
            
            this.size--; 
            return (newestValue); 
        }
    }
    
    public void remove(E element) throws NoSuchElementException
    {
        if (this.size == 0)
        {
            throw new NoSuchElementException("Can not remove from an empty queue"); 
        }
        else if (getOldestValue() == element)
        {
            removeOldestValue(); 
        }
        else if (getNewestValue() == element)
        {
            removeNewestValue(); 
        }
        else
        {
            OrderedQueueNode<E> currentNode = this.oldestNode.getNewerNode(); 
            
            while (currentNode != null) 
            {
                if (currentNode.getElement() == element)
                {
                    currentNode.getNewerNode().setOlderNode(currentNode.getOlderNode());
                    currentNode.getOlderNode().setNewerNode(currentNode.getNewerNode());
                    
                    this.size--; 
                }
                currentNode = currentNode.getNewerNode();
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
    
    public void removeAll(OrderedQueue<E> orderedQueue)
    {
        OrderedQueueNode<E> currentNode = orderedQueue.oldestNode; 
        while(currentNode != null)
        {
            remove(currentNode.getElement()); 
            currentNode = currentNode.getNewerNode(); 
        }
    }
    
    public void replace (E originalValue, E newValue) throws NoSuchElementException
    {
        if (this.size == 0)
        {
            throw new NoSuchElementException("Cannot replace value in an empty queue"); 
        }
        else
        {
            OrderedQueueNode<E> currentNode = this.oldestNode; 
            while(currentNode != null)
            {
                if (currentNode.getElement() == originalValue)
                {
                    currentNode.setElement(newValue); 
                }
                currentNode = currentNode.getNewerNode(); 
            }
        }
    }
    
    public void clear()
    {
        this.size = 0; 
        oldestNode = null; 
        newestNode = null; 
    }
    
    public void saveTofile(String filename) throws IOException, IllegalArgumentException
    {
        if (!filename.endsWith("txt"))
        {
            throw new IllegalArgumentException("Filename must end with .txt");
        }

        PrintWriter output = new PrintWriter(filename);
        OrderedQueueNode<E> currentNode = oldestNode;

        while (currentNode != null)
        {
            output.println(currentNode.getElement());
            currentNode = currentNode.getNewerNode();
        }

        output.close();
    }
}
