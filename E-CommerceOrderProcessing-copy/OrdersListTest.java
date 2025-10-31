import static org.junit.Assert.*;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OrdersListTest {
    // 3 normal test cases

    @Test
    public void testAppend(){
        OrdersList list = new OrdersList();
        list.append(new Order("001", "Azarias", "Sneakers"));
        list.append(new Order("002", "Jasmine", "Heels"));

        String result = list.toListString();

        assertTrue(result.contains("001"));
        assertTrue(result.contains("002"));
    }

    @Test
    public void testReverse(){
        OrdersList list = new OrdersList();
        
        list.append(new Order("001", "Azarias", "Sneakers"));
        list.append(new Order("002", "Jasmine", "Heels"));    
        
        list.reverse();
        
        String result = list.toListString();
        assertTrue(result.startsWith("Order ID: 002"));
        assertTrue(result.contains("001"));
    }
    
    
    @Test
    public void testDisplayOrder(){
        OrdersList list = new OrdersList();
        
        list.append(new Order("001", "Bob", "Hammer"));
        list.append(new Order("005", "Hamlet", "Skull"));
        list.append(new Order("010", "Sherlock", "Magnifying Glass"));
        
        String result = list.toListString();
        assertTrue(result.startsWith("Order ID: 001"));
        
        list.reverse();
        String reverseResult = list.toListString();
        assertTrue(reverseResult.startsWith("Order ID: 010"));
    }
    
    // 3 edge test cases
    @Test
    public void testReverseEmpty(){
        
        OrdersList list = new OrdersList();
        list.reverse();
        assertEquals("", list.toListString());
    }
    
    @Test
    public void testReverseSingle(){
        OrdersList list = new OrdersList();
        list.append(new Order("001", "Bob", "Hammer"));
        list.reverse();
        String result = list.toListString();
        assertTrue(result.startsWith("Order ID: 001"));
    }
    
    @Test
    public void testAppendNothing(){
        OrdersList list = new OrdersList();
        list.append(new Order("","",""));
        String result = list.toListString();
        assertTrue(result.startsWith("Order ID: "));
        
    }
}