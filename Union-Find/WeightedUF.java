package Assignment2;

import java.util.Random;

public class WeightedUF {
	int[] id;
	int[] size;
	int coms;
	public WeightedUF(int n){
		id = new int[n];
		size= new int[n];
		coms=n;
		for(int i = 0;i<n;i++){
			id[i]=i;
			size[i]=1;
		}
	}
	public int getComs(){
		return this.coms;
	}
	public boolean Connected(int i,int k){
		return find(i)==find(k);
	}
	public int find(int i){
		while(i!=id[i]){
			i=id[i];
		}
		return i;
	}
	public void Union(int p,int q ){
		int i = find(p);
		int k = find(q);
		if(size[i]<size[k]){
			id[i]=k;
			size[k]+=size[i];
		}
		else{
			id[k]=i;
			size[i]+=size[k];
		}
		coms--;
	}
	public static int Count(int n){
		WeightedUF test = new WeightedUF(n);
		int connections=0;
		while(test.getComs()>1){
			Random r = new Random();
			int i= r.nextInt(n);
			int j = r.nextInt(n);
			if(!test.Connected(i, j)){
				test.Union(i, j);
			}
			connections++;
		}
		return connections;
	}
}
