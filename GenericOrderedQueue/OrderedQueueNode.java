// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON

/**
 * 
 */
public class OrderedQueueNode<E>
{
    // INSTANCE VARIABLES
    private E element;
    private OrderedQueueNode<E> olderNode;
    private OrderedQueueNode<E> newerNode;
    
    // CONSTRUCTORS
    public OrderedQueueNode(E element, OrderedQueueNode<E> olderNode, 
    OrderedQueueNode<E> newerNode) 
    {
        this.element = element; 
        this.olderNode = olderNode; 
        this.newerNode = newerNode; 
    }
    
    // INSTANCE METHODS
    public E getElement()
    {
        return this.element; 
    }
    
    public void setElement(E element)
    {
        this.element = element; 
    }
    
    public OrderedQueueNode<E> getOlderNode()
    {
        return this.olderNode; 
    }
    
    public void setOlderNode(OrderedQueueNode<E> olderNode)
    {
        this.olderNode = olderNode; 
    }
    
    public OrderedQueueNode<E> getNewerNode()
    {
        return this.newerNode; 
    }
    
    public void setNewerNode(OrderedQueueNode<E> newerNode)
    {
        this.newerNode = newerNode; 
    }
}
