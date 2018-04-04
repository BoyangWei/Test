package Assignment5;

public class Main<T> {
	int m;
	int[] flag;
	int count=0;
	int runtimes=0;
	int hash(T key) {
		return (key.hashCode()  & 0x7fffffff)% m;
	}
	boolean isNoEmpty(int index) {
		if(flag[index]==0) {
			count++;
		}
		flag[index]++;
			return count==flag.length;
	}
	boolean isCollision(int index) {
		if(flag[index]>0)
			return true;
		return false;
	}
	public Main(int m) {
		this.m=m;
		this.flag= new int[m];
	}
}
