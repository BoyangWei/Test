

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        while(from<to){
        	int temp = from+1;
        	for(int i = temp; i>0&&Helper.less(xs[i],xs[i-1]);i--){
        		Helper.swap(xs, i, i-1);
        	}
        	from++;
        }
    }
    
}
