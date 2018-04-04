package Assignment3;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestClass {
	@Test
    public void sort1() throws Exception {

        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        new InsertionSort().sort(xs);
        assertEquals(Integer.valueOf(1), xs[0]);
        assertEquals(Integer.valueOf(2), xs[1]);
        assertEquals(Integer.valueOf(3), xs[2]);
        assertEquals(Integer.valueOf(4), xs[3]);
    }
	@Test
    public void sort2() throws Exception {

        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        new InsertionSort().sort(xs);
        assertEquals(Integer.valueOf(1), xs[0]);
        assertEquals(Integer.valueOf(2), xs[1]);
        assertEquals(Integer.valueOf(3), xs[2]);
        assertEquals(Integer.valueOf(4), xs[3]);
    }
}