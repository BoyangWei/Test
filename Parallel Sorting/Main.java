package ParallelSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static int[] array = new int[2000];
	static Random random = new Random(0L);
	static int bestCutOff=0;
	static int bestThreadNum=0;
	static void testCutOff(){
		 	int cutoff=array.length;
	        long bestTime=Long.MAX_VALUE;
	        while(cutoff>=2){
	        	 long time = 0;
	        	for(int j = 0;j<100;j++){
	        		for (int i = 0; i < array.length; i++) array[i] = random.nextInt(array.length);
	        		long beginTime = System.nanoTime();
	        		ParSort.sort(array, 0, array.length-1);
	        		long endTime = System.nanoTime();
	        		 time += endTime-beginTime;
	        	}
	        	time = time/100;
	        	if(bestTime>time&&cutoff>=100){
	        		bestCutOff=cutoff;
	        		bestTime=time;
	        	}
	        	System.out.println("cutoff: "+cutoff+" time: "+time);
	        	cutoff=cutoff/2;
	        }
	        System.out.println("bestcutoff: "+bestCutOff+" besttime: "+bestTime);
	    }
	static void testDepth(){
		int threadNum=1;
		long bestTime=Long.MAX_VALUE;
		while(threadNum<=255){
			ParSortwithDepth.thread=threadNum;
			long time=0;
			for(int j=0;j<100;j++){
				for (int i = 0; i < array.length; i++) array[i] = random.nextInt(array.length);
				long beginTime = System.nanoTime();
        		ParSortwithDepth.sort(array, 0, array.length-1);
        		long endTime = System.nanoTime();
        		 time += endTime-beginTime;
			}
			time=time/100;
			if(bestTime>time){
				bestThreadNum=threadNum;
				bestTime=time;
			}
			System.out.println("threadNum: "+threadNum+" time: "+time);
			threadNum*=2;
		}
		System.out.println("besThreadNum:"+bestThreadNum+" bestTime: "+bestTime);
	}
	static void bestChoice(){
		System.out.println("Type in your cutoff:");
		Scanner input = new Scanner(System.in);
		double cutoff=input.nextDouble();
		System.out.println("Type in your threadNum");
		double threadNum= input.nextDouble();
		input.close();
		double d1=0;
		if(cutoff>bestCutOff){
			d1=cutoff/bestCutOff;
		}else{
			d1=bestCutOff/cutoff;
		}
		double d2=0;
		if(bestThreadNum>threadNum){
			d2=bestThreadNum/threadNum;
		}else{
			d2=threadNum/bestThreadNum;
		}
		if(d1<d2){
			ParSort.sort(array, 0, array.length-1);
			for(int i = 0;i<100;i++)
				System.out.print(array[i]+" ");
			System.out.println("");
			System.out.println("choose cutoff");
		}else{
			ParSortwithDepth.sort(array, 0, array.length-1);
			for(int i = 0;i<100;i++)
				System.out.print(array[i]+" ");
			System.out.println("");
			System.out.println("choose thread number");
		}
	}
	static void Compare(){
		int num = 1000000;
		long time1=0;
		long time2=0;
	
			int[] list= new int[num];
			for(int i =0;i<num;i++){
				list[i]= random.nextInt(num);
			}
			long begin = System.nanoTime();
			Arrays.sort(list);
			long end = System.nanoTime();
			 time1= end-begin;
			for(int i =0;i<num;i++){
				list[i]= random.nextInt(num);
			}
			
			begin= System.nanoTime();
			ParSort.sort(list, 0, list.length-1);
			end = System.nanoTime();
			time2= end-begin;
			num*=5;
			if(time1<time2)System.out.println("parsort is faster");
	
	}
	public static void main(String[] args) {
		int num=2000;
		for(int i =1;i<=1024;i*=2){
			
			Main.array= new int[num*i];
			Main.testCutOff();
			Main.testDepth();
			Main.bestChoice();
		}
		
		Main.Compare();
	}   
	
}
