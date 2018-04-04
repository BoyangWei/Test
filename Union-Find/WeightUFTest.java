package Assignment2;

import java.util.Scanner;

public class WeightUFTest {

	public static void main(String[] args) {
		System.out.println("Please type in the number of sites:");
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			double avg=0;
			int num = input.nextInt();
			double sum=0;
			for(int c=0;c<1000;c++){
				sum+=WeightedUF.Count(num);
			}
			avg=sum/1000;
			System.out.println("The result of "+num+" is: "+avg+" and the excepted ans is: "+Math.log(num)*num/2);
		}
		input.close();
	}

}
