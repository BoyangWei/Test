package Assignment5;

import java.util.Random;

public class Run {

	public static void main(String[] args) {
		int m = 100;
		double sumcountC=0;
		double sumcountB=0;
		while(m<=1000) {
			Main<Double> main = new Main<>(m);
			Random ran = new Random(m);
			double countB=0;
			double countC=0;
			boolean isNoEmpty=false;
			boolean isCollision=false;
			for(int i =0;i<30;i++) {
				do {
					Double d = ran.nextDouble();
					int hash = main.hash(d);
					if(!isCollision) {
						isCollision = main.isCollision(hash);
						countC++;	
					}
					isNoEmpty=main.isNoEmpty(hash);
					if(!isNoEmpty)
						countB++;
					 
				}while(!(isNoEmpty&&isCollision));
				if(i>9) {
					sumcountB+=countB;
					sumcountC+=countC;
				}
				countC=countB=0;
				isNoEmpty=isCollision=false;
				main= new Main<Double>(m);
			}
			System.out.println("m = "+m+" at "+sumcountB/20+" no empty; "+"at "+sumcountC/20+" collision.");
			m+=100;
			sumcountB=sumcountC=0;
		}

	}

}
