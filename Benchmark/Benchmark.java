package Assignment3;

import java.util.function.Function;

public class Benchmark<T> {
	public Benchmark(Function<T, Integer> f) {
        this.f = f;
        this.list= new Integer[1000];
    }

    public double run(T t, int n) {
        double sum=0.0;
        while(n>0){
        		if(n<1001)
        			sum+=f.apply(t);
        		n--;
        }
        return sum/1000;
    }

    private final Function<T, Integer> f;
    private static Integer[] list;

    public static void main(String[] args) {
        int m = 1010; // This is the number of repetitions: sufficient to give a good mean value of timing
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) array[i] =1000-i; // TODO populate the array with real random data
        int n = 999;
        // TODO You need to apply doubling to n
        benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer,Integer> sortFunction = (x) -> {
        	for(int i = 0; i<xs.length;i++)
        		list[i] = xs[i];
        	long start = System.currentTimeMillis();
            sorter.sort(list, 0, x);
            long end = System.currentTimeMillis();
            int res = (int) (end-start);
            
            return res;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " millisecs for n=" + n);
    }
}
