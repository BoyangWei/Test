package Assignment2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class test {
	

	

	    /**
	     */
	    @Test
	    public void testFind0() {
	        WeightedUF h = new WeightedUF(10);
	        assertEquals(0, h.find(0));
	    }

	    /**
	     */
	    @Test
	    public void testFind1() {
	    	WeightedUF h = new WeightedUF(10);
	        h.Union(0,1);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	    }

	    /**
	     */
	    @Test
	    public void testFind2() {
	    	WeightedUF h = new WeightedUF(10);
	        h.Union(0,1);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        h.Union(2,1);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        assertEquals(0, h.find(2));
	    }

	    /**
	     */
	    @Test
	    public void testFind3() {
	    	WeightedUF h = new WeightedUF(10);
	        h.Union(0,1);
	        h.Union(0,2);
	        h.Union(3,4);
	        h.Union(3,5);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        assertEquals(0, h.find(2));
	        assertEquals(3, h.find(3));
	        assertEquals(3, h.find(4));
	        assertEquals(3, h.find(5));
	        h.Union(0,3);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        assertEquals(0, h.find(2));
	        assertEquals(0, h.find(3));
	        assertEquals(0, h.find(4));
	        assertEquals(0, h.find(5));
	    }

	    /**
	     */
	    @Test
	    public void testFind4() {
	    	WeightedUF h = new WeightedUF(10);
	        h.Union(0,1);
	        h.Union(0,2);
	        h.Union(3,4);
	        h.Union(3,5);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        assertEquals(0, h.find(2));
	        assertEquals(3, h.find(3));
	        assertEquals(3, h.find(4));
	        assertEquals(3, h.find(5));
	        h.Union(0,3);
	        assertEquals(0, h.find(0));
	        assertEquals(0, h.find(1));
	        assertEquals(0, h.find(2));
	        assertEquals(0, h.find(3));
	        assertEquals(0, h.find(4));
	        assertEquals(0, h.find(5));
	    }

	    /**
	     */
	    @Test
	    public void testConnected01() {
	    	WeightedUF h = new WeightedUF(10);
	        assertFalse(h.Connected(0,1));
	    }
}
