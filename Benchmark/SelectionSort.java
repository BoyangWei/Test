package Assignment3;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    @Override
    public void sort(X[] xs, int from, int to) {
       while(from<to){
    	   int temp = from;
    	   for(int index = from+1;index<to;index++){
          	if(Helper.less(xs[index], xs[temp])){
          		temp = index;
          	}	
          }
    	   Helper.swap(xs, from, temp);
    	   from++;
       } 
    }
}
