// PROGRAMMERS: NATHAN JORDAN, TIFFANY TRUONG, RYAN LAWTON
/**
 * Create functions that test the SortedSet default constructor, overloaded 
 * constructor, and all of its instance methods.
 */
public class SortedSetTester
{
    public static void main(String[] args)
    {
        // OBJECT CREATION
        System.out.println("Creating defaultSortedSet using the default constructor.");
        SortedSet<Integer> defaultSortedSet = new SortedSet<Integer>();
        
        System.out.println("Creating sortedSetFromArray using first overloaded constructor and passing it an Integer array with the values 3, 2, and 1.");
        SortedSet<Integer> sortedSetFromArray = new SortedSet<Integer>(new Integer[]{3, 2, 1});
        
        System.out.println("Creating sortedSetFromSortedSet using second overloaded constructor and passing it a sorted set containing the values 3, 2, and 1.");
        SortedSet<Integer> sortedSetFromSortedSet = new SortedSet<Integer>(sortedSetFromArray);
        
        // SOLUTION (TESTS)
        System.out.println("Starting tests...");
        System.out.println();
        System.out.println("Testing getSize() on defaultSortedSet.  Expected: 0 Returned: " + defaultSortedSet.getSize());
        System.out.println("Testing getSize() on sortedSetFromArray.  Expected: 3 Returned: " + sortedSetFromArray.getSize());
        System.out.println("Testing getSize() on sortedSetFromSortedSet.  Expected: 3 Returned: " + sortedSetFromSortedSet.getSize());
        System.out.println();
        System.out.println("Testing isEmpty() on defaultSortedSet.  Expected: true Returned: " + defaultSortedSet.isEmpty());
        System.out.println("Testing isEmpty() on sortedSetFromArray.  Expected: false Returned: " + sortedSetFromArray.isEmpty());
        System.out.println("Testing isEmpty() on sortedSetFromSortedSet.  Expected: false Returned: " + sortedSetFromSortedSet.isEmpty());
        System.out.println();
        System.out.println("Testing getSmallestValue() on defaultSortedSet.  Expected: null Returned: " + defaultSortedSet.getSmallestValue());
        System.out.println("Testing getSmallestValue() on sortedSetFromArray.  Expected: 1 Returned: " + sortedSetFromArray.getSmallestValue());
        System.out.println("Testing getSmallestValue() on sortedSetFromSortedSet.  Expected: 1 Returned: " + sortedSetFromSortedSet.getSmallestValue());
        System.out.println();
        System.out.println("Testing getLargestValue() on defaultSortedSet.  Expected: null Returned: " + defaultSortedSet.getLargestValue());
        System.out.println("Testing getLargestValue() on sortedSetFromArray.  Expected: 3 Returned: " + sortedSetFromArray.getLargestValue());
        System.out.println("Testing getLargestValue() on sortedSetFromSortedSet.  Expected: 3 Returned: " + sortedSetFromSortedSet.getLargestValue());
        System.out.println();
        System.out.println("Testing contains(2) on defaultSortedSet.  Expected: false Returned: " + defaultSortedSet.contains(2));
        System.out.println("Testing contains(2) on sortedSetFromArray.  Expected: true Returned: " + sortedSetFromArray.contains(2));
        System.out.println("Testing contains(2) on sortedSetFromSortedSet.  Expected: true Returned: " + sortedSetFromSortedSet.contains(2));
        System.out.println();
        System.out.println("Testing containsAll(new Integer[]{3, 2, 1}) on defaultSortedSet.  Expected: false Returned: " + defaultSortedSet.containsAll(new Integer[]{3, 2, 1}));
        System.out.println("Testing containsAll(new Integer[]{3, 2, 1}) on sortedSetFromArray.  Expected: true Returned: " + sortedSetFromArray.containsAll(new Integer[]{3, 2, 1}));
        System.out.println("Testing containsAll(new Integer[]{3, 2, 1}) on sortedSetFromSortedSet.  Expected: true Returned: " + sortedSetFromSortedSet.containsAll(new Integer[]{3, 2, 1}));
        System.out.println();
        System.out.println("Testing containsAll(sortedSetFromSortedSet) on defaultSortedSet.  Expected: false Returned: " + defaultSortedSet.containsAll(new Integer[]{3, 2, 1}));
        System.out.println("Testing containsAll(sortedSetFromSortedSet) on sortedSetFromArray.  Expected: true Returned: " + sortedSetFromArray.containsAll(sortedSetFromSortedSet));
        System.out.println("Testing containsAll(sortedSetFromArray) on sortedSetFromSortedSet.  Expected: true Returned: " + sortedSetFromSortedSet.containsAll(sortedSetFromArray));
        System.out.println();
        System.out.println("Testing toArray() on defaultSortedSet.  Expected: java.lang.Comparable Returned: " + defaultSortedSet.toArray());
        System.out.println("Testing toArray() on sortedSetFromArray.  Expected: java.lang.Comparable Returned: " + sortedSetFromArray.toArray());
        System.out.println("Testing toArray() on sortedSetFromSortedSet.  Expected: java.lang.Comparable Returned: " + sortedSetFromSortedSet.toArray());
        System.out.println();
        System.out.println("Beginning add function testing...");
        System.out.println();
        System.out.println("Testing add(4) on defaultSortedSet...");
        defaultSortedSet.add(4);
        System.out.println("Testing add(4) on sortedSetFromArray... "); 
        sortedSetFromArray.add(4);
        System.out.println("Testing add(4) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.add(4);
        System.out.println();
        System.out.println("Testing addAll(new Integer[]{7, 6, 5}) on defaultSortedSet...");
        defaultSortedSet.addAll(new Integer[]{7, 6, 5});
        System.out.println("Testing addAll(new Integer[]{7, 6, 5}) on sortedSetFromArray... "); 
        sortedSetFromArray.addAll(new Integer[]{7, 6, 5});
        System.out.println("Testing addAll(new Integer[]{7, 6, 5}) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.addAll(new Integer[]{7, 6, 5});
        System.out.println();
        System.out.println("Testing addAll(sortedSetFromSortedSet) on defaultSortedSet...");
        defaultSortedSet.addAll(sortedSetFromSortedSet);
        System.out.println("Testing addAll(sortedSetFromSortedSet) on sortedSetFromArray... "); 
        sortedSetFromArray.addAll(sortedSetFromSortedSet);
        System.out.println("Testing addAll(defaultSortedSet) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.addAll(defaultSortedSet);
        System.out.println();
        System.out.println("Results of add methods...");
        System.out.println("defaultSortedSet Expected size: 7 Returned: " + defaultSortedSet.getSize() + " Contains: [1, 2, 3, 4, 5, 6, 7] ? " + defaultSortedSet.containsAll(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println("sortedSetFromArray Expected size: 7 Returned: " + defaultSortedSet.getSize() + " Contains: [1, 2, 3, 4, 5, 6, 7] ? " + defaultSortedSet.containsAll(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println("sortedSetFromSortedSet Expected size: 7 Returned: " + defaultSortedSet.getSize() + " Contains: [1, 2, 3, 4, 5, 6, 7] ? " + defaultSortedSet.containsAll(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println();
        System.out.println("Testing removeSmallestValue() on defaultSortedSet.  Expected: 1 Returned: " + defaultSortedSet.removeSmallestValue());
        System.out.println("Testing removeSmallestValue() on sortedSetFromArray.  Expected: 1 Returned: " + sortedSetFromArray.removeSmallestValue());
        System.out.println("Testing removeSmallestValue() on sortedSetFromSortedSet.  Expected: 1 Returned: " + sortedSetFromSortedSet.removeSmallestValue());
        System.out.println();
        System.out.println("Testing removeLargestValue() on defaultSortedSet.  Expected: 7 Returned: " + defaultSortedSet.removeLargestValue());
        System.out.println("Testing removeLargestValue() on sortedSetFromArray.  Expected: 7 Returned: " + sortedSetFromArray.removeLargestValue());
        System.out.println("Testing removeLargestValue() on sortedSetFromSortedSet.  Expected: 7 Returned: " + sortedSetFromSortedSet.removeLargestValue());
        System.out.println();
        System.out.println("Testing remove(5) on defaultSortedSet...");
        defaultSortedSet.remove(5);
        System.out.println("Testing remove(5) on sortedSetFromArray...");
        sortedSetFromArray.remove(5);
        System.out.println("Testing remove(5) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.remove(5);
        System.out.println();
        System.out.println("Checking if defaultSortedSet contains 5.  Expected: false Returned: " + defaultSortedSet.contains(5));
        System.out.println("Checking if sortedSetFromArray contains 5.  Expected: false Returned: " + sortedSetFromArray.contains(5));
        System.out.println("Checking if sortedSetFromSortedSet contains 5.  Expected: false Returned: " + sortedSetFromSortedSet.contains(5));
        System.out.println();
        System.out.println("Testing removeAll(new Integer[]{3, 2, 1}) on defaultSortedSet...");
        defaultSortedSet.removeAll(new Integer[]{3, 2, 1});
        System.out.println("Testing removeAll(new Integer[]{3, 2, 1}) on sortedSetFromArray...");
        sortedSetFromArray.removeAll(new Integer[]{3, 2, 1});
        System.out.println("Testing removeAll(new Integer[]{3, 2, 1}) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.removeAll(new Integer[]{3, 2, 1});
        System.out.println();
        System.out.println("Checking if defaultSortedSet contains Integers 1, 2, and 3.  Expected: false Returned: " + defaultSortedSet.containsAll(new Integer[]{3, 2, 1}));
        System.out.println("Checking if sortedSetFromArray contains Integers 1, 2, and 3.  Expected: false Returned: " + sortedSetFromArray.containsAll(new Integer[]{3, 2, 1}));
        System.out.println("Checking if sortedSetFromSortedSet contains Integers 1, 2, and 3.  Expected: false Returned: " + sortedSetFromSortedSet.containsAll(new Integer[]{3, 2, 1}));
        System.out.println();        
        System.out.println("Testing removeAll(new SortedSet<Integer>(new Integer[]{4, 6})) on defaultSortedSet...");
        defaultSortedSet.removeAll(new SortedSet<Integer>(new Integer[]{4, 6}));
        System.out.println("Testing removeAll(new SortedSet<Integer>(new Integer[]{4, 6})) on sortedSetFromArray...");
        sortedSetFromArray.removeAll(new SortedSet<Integer>(new Integer[]{4, 6}));
        System.out.println("Testing removeAll(new SortedSet<Integer>(new Integer[]{4, 6})) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.removeAll(new SortedSet<Integer>(new Integer[]{4, 6}));
        System.out.println();
        System.out.println("Testing if defaultSortedSet contains Integers 4 and 6.  Expected: false Returned: " + defaultSortedSet.containsAll(new SortedSet<Integer>(new Integer[]{4, 6})));
        System.out.println("Testing if sortedSetFromArray contains Integers 4 and 6.  Expected: false Returned: " + sortedSetFromArray.containsAll(new SortedSet<Integer>(new Integer[]{4, 6})));
        System.out.println("Testing if sortedSetFromSortedSet contains Integers 4 and 6.  Expected: false Returned: " + sortedSetFromSortedSet.containsAll(new SortedSet<Integer>(new Integer[]{4, 6})));
        System.out.println();
        System.out.println("Adding 8 to all three sets...");
        defaultSortedSet.add(8);
        sortedSetFromArray.add(8);
        sortedSetFromSortedSet.add(8);
        System.out.println();
        System.out.println("Testing replace(8, 1) on defaultSortedSet...");
        defaultSortedSet.replace(8, 1);
        System.out.println("Testing replace(8, 1) on sortedSetFromArray...");
        sortedSetFromArray.replace(8, 1);
        System.out.println("Testing replace(8, 1) on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.replace(8, 1);
        System.out.println();
        System.out.println("Checking if defaultSortedSet contains 8.  Expected: false Returned: " + defaultSortedSet.contains(8));
        System.out.println("Checking if defaultSortedSet contains 1.  Expected: true Returned: " + defaultSortedSet.contains(1));
        System.out.println("Checking if sortedSetFromArray contains 8.  Expected: false Returned: " + sortedSetFromArray.contains(8));
        System.out.println("Checking if sortedSetFromArray contains 1.  Expected: true Returned: " + sortedSetFromArray.contains(1));
        System.out.println("Checking if sortedSetFromSortedSet contains 8.  Expected: false Returned: " + sortedSetFromSortedSet.contains(8));
        System.out.println("Checking if sortedSetFromSortedSet contains 1.  Expected: true Returned: " + sortedSetFromSortedSet.contains(1));
        System.out.println();
        System.out.println("Testing clear() on defaultSortedSet...");
        defaultSortedSet.clear();
        System.out.println("Testing clear() on sortedSetFromArray...");
        sortedSetFromArray.clear();
        System.out.println("Testing clear() on sortedSetFromSortedSet...");
        sortedSetFromSortedSet.clear();
        System.out.println();
        System.out.println("Checking defaultSortedSet's size.  Expected: 0 Returned: " + defaultSortedSet.getSize());
        System.out.println("Checking sortedSetFromArray's size.  Expected: 0 Returned: " + sortedSetFromArray.getSize());
        System.out.println("Checking sortedSetFromSortedSet's size.  Expected: 0 Returned: " + sortedSetFromSortedSet.getSize());
        System.out.println();
        System.out.println("Adding values 8, 2, 6, and 4 back to defaultSortedSet...");
        defaultSortedSet.addAll(new Integer[]{8, 2, 6, 4});
        System.out.println("Adding values 7, 3, 5, and 1 back to sortedSetFromArray...");
        sortedSetFromArray.addAll(new Integer[]{7, 3, 5, 1});
        System.out.println("Adding values 12, 11, 10, and 9 back to sortedSetFromSortedSet...");
        sortedSetFromSortedSet.addAll(new Integer[]{12, 11, 10, 9});
        System.out.println();
        System.out.println("Testing saveToFile('defaultSortedSetOutput.txt') on defaultSortedSet...");
        System.out.println("Testing saveToFile('sortedSetFromArrayOutput.txt') on sortedSetFromArray...");
        System.out.println("Testing saveToFile('sortedSetFromSortedSetOutput.txt') on sortedSetFromSortedSet...");
        
        try{
            defaultSortedSet.saveToFile("defaultSortedSetOutput.txt");
            sortedSetFromArray.saveToFile("sortedSetFromArrayOutput.txt");
            sortedSetFromSortedSet.saveToFile("sortedSetFromSortedSetOutput.txt");
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        
        System.out.println("...Check the project directory for the three output files.");
    }
}
