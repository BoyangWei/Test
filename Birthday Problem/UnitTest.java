package Assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest {
	
	@Test
	public void testHash() {
		Main<Double> main = new Main<>(10);
		Double d = 10.00;
		assertEquals(main.hash(d),main.hash(d));
		assertEquals(main.hash(d),main.hash(10.00));
	}
	
	@Test
	public void testEmpty() {
		Main<Double> main = new Main<>(10);
		for(int i =0;i<9;i++) {
			assertFalse(main.isNoEmpty(i));
		}
		assertTrue(main.isNoEmpty(9));
		for(int i =0;i<10;i++)
			assertTrue(main.isNoEmpty(i));	
	}
	
	@Test
	public void testCollision() {
		Main<Double> main = new Main<>(10);
		Double d1 = new Double(10.0);
		Double d2 = new Double(10.0);
		assertFalse(main.isCollision(main.hash(d1)));
		main.isNoEmpty(main.hash(d1));
		assertTrue(main.isCollision(main.hash(d2)));
	}
	
	@Test
	public void testCount() {
		Main<Double> main = new Main<>(10);
		for(int i=0;i<10;i++)
			assertEquals(main.flag[i],0);
		Double d = new Double(10);
		int hash = main.hash(d);
		main.isNoEmpty(hash);
		assertEquals(main.flag[hash],1);
		main.isNoEmpty(hash);
		assertEquals(main.flag[hash],2);
	}
}
