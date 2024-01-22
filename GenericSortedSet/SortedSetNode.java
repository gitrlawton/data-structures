// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON
/**
 * The SortedSetNode class.
 */
public class SortedSetNode<E>
{
    // INSTANCE VARIABLES
    private E element;
    private SortedSetNode<E> lessThanNode;
    private SortedSetNode<E> greaterThanNode;
    
    // CONSTRUCTOR
    public SortedSetNode(E element, SortedSetNode<E> lessThanNode, 
    SortedSetNode<E> greaterThanNode)
    {
        this.element = element;
        this.lessThanNode = lessThanNode;
        this.greaterThanNode = greaterThanNode;
    }
    
    // INSTANCE METHODS
    public E getElement()
    {
        return element;
    }
    
    public void setElement(E element)
    {
        this.element = element;
    }
    
    public SortedSetNode<E> getLessThanNode()
    {
        return lessThanNode;
    }
    
    public void setLessThanNode(SortedSetNode<E> lessThanNode)
    {
        this.lessThanNode = lessThanNode;
    }
    
    public SortedSetNode<E> getGreaterThanNode()
    {
        return greaterThanNode;
    }
    
    public void setGreaterThanNode(SortedSetNode<E> greaterThanNode)
    {
        this.greaterThanNode = greaterThanNode;
    }
}
