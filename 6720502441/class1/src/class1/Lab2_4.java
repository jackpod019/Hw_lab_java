package class1;

import java.util.Scanner;

public class Lab2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner num = new Scanner(System.in);
		System.out.printf("Enter sentence:");
		String sen = num.nextLine();
		String new1 = sen.replace("happy","happy :)");
		String new2 = new1.replace("sad","sad :(");
		System.out.printf(new2);
	}

}
