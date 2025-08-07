package class1;

import java.util.Scanner;

public class lab1_4 {

	public static void main(String[] args) {
		Scanner gt = new Scanner(System.in);
		System.out.printf("x:");
		double i = gt.nextDouble();
		System.out.printf("y:");
		double j = gt.nextDouble();
		if (i==0&&j==0) {
			System.out.printf("coordinates %.0f,%.0f=origin",i,j);
		}
		else if (i==0&&j!=0) {
			System.out.printf("coordinates %.0f,%.0f=y-intercept",i,j);
		}
		else if (i!=0&&j==0) {
			System.out.printf("coordinates %.0f,%.0f=x-intercept",i,j);
		}
		else if (i>0&&j>0) {
			System.out.printf("coordinates %.0f,%.0f=Q1",i,j);
		}
		else if (i<0&&j>0) {
			System.out.printf("coordinates %.0f,%.0f=Q2",i,j);
		}
		else if (i<0&&j<0) {
			System.out.printf("coordinates %.0f,%.0f=Q3",i,j);
		}
		else if (i>0&&j<0) {
			System.out.printf("coordinates %.0f,%.0f=Q4",i,j);
		}
	}

}
