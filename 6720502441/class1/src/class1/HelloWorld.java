package class1;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter triangle sid:");
		double i = sc.nextDouble();
		System.out.printf("Enter prism length:");
		double j = sc.nextDouble();
		double ans = (2*(Math.sqrt(3)/4)*i*i)+(i*j)*3;
		System.out.printf("%.2f", ans);
	}

}
