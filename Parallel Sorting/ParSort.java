package ParallelSort;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class ParSort {
	


    public static int cutoff = 5000;

    public static void sort(int[] array, int from, int to) {
        int size = to - from;
        if (size <=cutoff) Arrays.sort(array, from, to+1);
        else {
        	int mid=(from+to)/2;
            CompletableFuture<int[]> parsort1 = parsort(array, from, mid-1); 
            CompletableFuture<int[]> parsort2 = parsort(array, mid, to); 
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (a1, a2) -> {
                        int[] result = new int[a1.length + a2.length];
                        int i = 0, j = 0;
                        int k = 0;
                        while (i < a1.length && j < a2.length)
                            if (a1[i] < a2[j]) {
                                result[k++] = a1[i++];

                            }
                            else
                            {
                                result[k++] = a2[j++];

                            }

                        while (i < a1.length) {
                            result[k++] = a1[i++];

                        }
                        while (j < a2.length) {
                            result[k++] = a2[j++];

                        }
                        return result;
                    });

            parsort.whenComplete((result, throwable) -> {
                for(int i=from;i<=to;i++)
                {
                    array[i]=result[i-from];
                }
            }); 
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to  - from+1];

                    sort(array, from, to);
                    for(int i=0;i<to-from+1;i++)
                    {
                        result[i]=array[i+from];
                    }

                    return result;
                }
        );
    }

}
