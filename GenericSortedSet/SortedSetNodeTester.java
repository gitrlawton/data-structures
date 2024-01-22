// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON
/**
 * Create functions that test the SortedSetNode's constructor and instance 
 * methods.
 */
public class SortedSetNodeTester
{
    public static void main(String[] args)
    {
        //Testing First node to make sure it works
        SortedSetNode<Integer> newNode = new SortedSetNode<Integer>(20,null,null);
        //Testing Second node to make sure it works
        SortedSetNode<Integer> secondNode = new SortedSetNode<Integer>(10,null,null);
        //Testing Third node to make sure it works
        SortedSetNode<Integer> thirdNode = new SortedSetNode<Integer>(55,null,null);
        //Test out the get element method
        System.out.println("testing get element method: " + newNode.getElement());
        //Testing out the set element method
        newNode.setElement(99);
        System.out.println("testing set element method: " + newNode.getElement());
        //Testing out the get element method for LessThanNode
        System.out.println("testing get LessThanNode method: " + newNode.getLessThanNode());
        //Testing out the set element method for LessThanNode
        newNode.setLessThanNode(secondNode);
        System.out.println("testing set LessThanNode method: " + newNode.getLessThanNode().getElement());
        //Testing out the get element method for GreaterThanNode
        System.out.println("testing get GreaterThanNode method: " + newNode.getGreaterThanNode());
        //Testing out the set element method for GreaterThanNode
        newNode.setGreaterThanNode(thirdNode);
        System.out.println("testing set GreaterThanNode method: " + newNode.getGreaterThanNode().getElement());
    }
}
