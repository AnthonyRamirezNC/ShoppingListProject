package Shopping;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import Shopping.EmptyCollectionException;
import Shopping.ElementNotFoundException;
/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArrayListTest {
    Grocery item1, item2;
    ShoppingListArrayList instance;
    /**
     * Initialize instance and entries
     */
    @Before
    public void setupTestCases() {
        item1 = new Grocery("Harry Potter", "book", 3, 
                15.5f, 2);
        item2 = new Grocery("Hunger Game", "book", 3, 
                35.5f, 1);
        
        //Create aa shopping list instance
        instance = new ShoppingListArrayList();

    }

    /**
     * TODO Test of add method, of class ShoppingArray for 
     * a case that the given argument object is null.
     * Test whether the add method works well when the 
     * given argument object is null
     */
    @Test
    public void testAdd1() {
        // Test adding a null entry reference to the shpping list
        instance.add(null);
        // TODO to test whether the size of shopping cart is correct after inserting a null object.


        
        instance.add(item1);
        assertEquals("An item is added incorrectly",
                1, instance.size());
        
        // Test adding a null entry reference to the shpping list
        instance.add(null);
        // TODO to test whether the size of shopping cart is correct after inserting a null object.
        

    }

    /**
     * Test of add method, of class ShoppingArray for adding
     * different grocery objects.
     * If two grocery objects have the same grocery name and category,
     * these two grocery objects will be treated as the same and only 
     * one grocery object will be added with recalculated quantities.
     * In this test method, we check the add methods for adding different 
     * grocery objects.
     */
    @Test
    public void testAdd2() {
        instance.add(item1);
        int oldQuantity = item1.getQuantity();
        // TODO test the add method for the case of adding a new item (item1) into list instance 
        // Be sure that 1) size is increased by 1 and 
        //              2) the first item in the list 
        // is the same as in the reference variable, item1 
        assertEquals(1, instance.size());
        try{
            assertEquals(0, item1.compareTo(instance.find(0)));
            assertEquals(oldQuantity, item1.getQuantity());
            assertEquals(oldQuantity, instance.find(0).getQuantity());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        oldQuantity = item2.getQuantity();
        instance.add(item2);
        // Test creating and adding a new grocery object to the list
        // Be sure that 1) the shopping list has a proper number of items
        //              2)the list item in the list 
        // is the same as in the newly created grocery object
        assertEquals(2, instance.size());
        try{
            assertEquals(0, item2.compareTo(instance.find(1)));
            assertEquals(oldQuantity, item2.getQuantity());
            assertEquals(oldQuantity, instance.find(1).getQuantity());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * Test of add method, of class ShoppingArray for adding
     * duplicate grocery objects.
     * If two grocery objects have the same grocery name and category,
     * these two grocery objects will be treated as the same and only 
     * one grocery object will be added with recalculated quantities.
     * In this test method, we check the add methods for adding 
     * duplicated grocery objects.
     */
    @Test
    public void testAdd3() {
        //Create grocery objects and a shopping list instance
        Grocery item3 = new Grocery(item1);
        Grocery item4 = new Grocery(item1);
        item4.setQuantity(3);
        int expQuantity = item3.getQuantity() + item4.getQuantity();
 
        instance.add(item3);
        instance.add(item4);
        // Test the "combine" feature of the add method
        // for the case of adding an existing entry, the item3
        // into the shopping list instance created in previous 
        // code block. The item2 has the same entry name as the item1.
        // Be sure that 1) size is not changed and 2) quantities are
        // properly changed in the first item in the list.
        assertEquals(1, instance.size());
        try{
            assertEquals(0, item3.compareTo(instance.find(0)));
            assertEquals(0, item4.compareTo(instance.find(0)));
            assertEquals(expQuantity, item3.getQuantity());
            assertEquals(expQuantity, instance.find(0).getQuantity());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * TODO Test of remove method, of class ShoppingArrayList
     * in the case of removing an existing element.
     */
    @Test
    public void testRemove1() {
        instance.add(item1);
        instance.add(item2);
        assertEquals(2, instance.size());

        boolean isRemoved = instance.remove(item1);
        // TODO test the remove method for an existing entry
        // Be sure that 
        // 1) the returned value from the remove method is true
        //    if the to-be-removed item exists in the array list
        // 2) the shopping list is decreased by 1
        // 3) the item being removed can not be found in the shopping list




    }
    
    /**
     * Test of remove method, of class ShoppingArrayList
     * in the case of removing an existing element.
     */
    @Test
    public void testRemove2() {
        instance.add(item1);
        instance.add(item2);
        assertEquals(2, instance.size());  
        boolean isRemoved = instance.remove(item1);        
        assertEquals(true, isRemoved);
        assertEquals(1, instance.size());
        isRemoved = instance.remove(item2);
        assertEquals(true, isRemoved);
        assertEquals(0, instance.size());
    }

    /**
     * TODO Test of remove method, of class ShoppingArrayList
     * in the case of removing a non-existing element.
     */
    @Test
    public void testRemove3() {
        instance.add(item1);
        instance.add(item2);
        int oriSize = instance.size();
        
        Grocery item3 = new Grocery("King of Ring", "book", 3, 
                35.5f, 1);
        boolean isRemoved = instance.remove(item3);
        // TODO test the remove method for a non-existing entry 
        // Be sure that 
        // 1) the returned value from the remove method is false
        // 2) the size of the shopping list is not changed





    }
    
    /**
     * Test of find method, of class ShoppingArrayList
     * in the case that the given index is out of bounds.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testFind1()  throws Exception {
        // Add item1 into the shopping list
        instance.add(item1);
        instance.add(item2);
        assertEquals(2, instance.size());
        
        instance.find(5);
    }

    /**
     * Test of find method, of class ShoppingArrayList
     * in the case that the given index is out of bounds.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testFind2()  throws Exception {
        // Add item1 into the shopping list
        instance.add(item1);
        instance.add(item2);
        assertEquals(2, instance.size());
        
        instance.find(-5);
    }
    /**
     * Test of find method, of class ShoppingArrayList
     * in the case of trying to find an item at a given
     * index of an empty list.
     */
    @Test(expected=EmptyCollectionException.class)
    public void testFind3() throws Exception {
        // Test the case of finding a grocery object when the shopping list is empty
        // Be sure that
        // An EmptyCollectionException instance is thrown in the case
        instance.find(0);
    }
    
    /**
     * Test of find method, of class ShoppingArrayList.
     */
    @Test
    public void testFind4() throws Exception{
        // Add item1 into the shopping list
        instance.add(item1);
        instance.add(item2);
        assertTrue(2 == instance.size());
        
        // Test the case of finding a grocery object which index is negative
        Grocery item = instance.find(0);
        assertEquals(0, item1.compareTo(item));
    }
    
    /**
     * Test of indexOf method, of class ShoppingArrayList
     * in the case that the search target item does not exist.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testIndexOf1() throws Exception  {
        // Check the indexOf method when the shopping list is empty
        int index = instance.indexOf(item1);
    }

    /**
     * Test of indexOf method, of class ShoppingArrayList.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testIndexOf2() throws Exception {
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);

        // Check the indexOf method when the grocery item does not appear in the list
        Grocery item3 = new Grocery("Aladin", "book", 3, 
            15.5f, 2);
        instance.indexOf(item3);
    }
    
    /**
     * Test of indexOf method, of class ShoppingArrayList
     * in the case of getting an index of existing item in
     * the list.
     */
    @Test
    public void testIndexOf3() throws Exception {
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the indexOf method when the grocery item appears in the list
        int index = instance.indexOf(item2);
        assertEquals(1, index);
        index = instance.indexOf(item1);
        assertEquals(0, index);
    }

    /**
     * Test of indexOf method, of class ShoppingArrayList
     * in the case of getting the index of a null object.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testIndexOf4() throws Exception {
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the indexOf method when the grocery item is null
        Grocery obj = null;
        instance.indexOf(obj);
    }
    
    /**
     * Test of contains method, of class ShoppingArrayList
     * in the case of evaluating whether an item is contained
     * in an empty list.
     */
    @Test
    public void testContains1() {        
        // Check the contains method when the shopping list is empty
        boolean isTrue = instance.contains(item1);
        assertEquals(false, isTrue);
    }

     /**
     * Test of contains method, of class ShoppingArrayList
     * in the case of evaluating the contains() for an
     * existing item in the list.
     */
    @Test
    public void testContains2() {        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the contains method when the grocery item appears in the list
        boolean isTrue = instance.contains(item2);
        assertEquals(true, isTrue);
    }
    
    /**
     * Test of contains method, of class ShoppingArrayList
     * in the case of evaluating the contains() for a
     * non-existing item in the list.
     */
    @Test
    public void testContains3() {        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the contains method when the grocery item does not appear in the list
        Grocery item3 = new Grocery("Aladin", "book", 3, 
                15.5f, 2);
        boolean isTrue = instance.contains(item3);
        assertEquals(false, isTrue);
    }

    /**
     * Test of contains method, of class ShoppingArrayList
     * in the case of evaluating the contains() for a
     * null object.
     */
    @Test
    public void testContains4() {        
        // Add grocery items into the shopping list
        instance.add(item1);
        instance.add(item2);
        
        // Check the contains method when the grocery item is null
        Grocery obj = null;
        boolean isTrue = instance.contains(obj);
        assertEquals(false, isTrue);
    }
    
    /**
     * Test of size method, of class ShoppingArrayList.
     */
    @Test
    public void testSize() {
        assertEquals(0, instance.size());

        instance.add(item1);
        // Test increment
        assertEquals(1, instance.size());

        assertTrue(instance.remove(item1));
        // Test decrement
        assertEquals(0, instance.size());
    }

    /**
     * Test of isEmpty method, of class ShoppingArrayList.
     */
    @Test
    public void testIsEmpty() {
        // Test empty
        assertEquals(true, instance.isEmpty());
        instance.add(item1);

        // Test not empty
        assertEquals(false, instance.isEmpty());
    }
}
