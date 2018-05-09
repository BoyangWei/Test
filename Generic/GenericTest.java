package Final;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenericTest {
	
	@Test
	public void testGenericMove() {
		Generic generic = new Generic();
		int x=0;
		int y =0;
		for(int i = 0;i<100;i++) {
			int temp= (int)Math.random()*4;
			switch(temp) {
			case 0:y++;break;
			case 1:x--;break;
			case 2:y--;break;
			case 3:x++; break;
			}
			generic.getGenearr()[i]= new Gene(temp);
		}
		generic.Move();
//		assertEquals(generic.getDx(),x);
//		assertEquals(generic.getDy(),y);
	}

}
