package class1;

import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Please input the number :");
		int value = scanner.nextInt();
		int y=value;
		int temp=value;
		int length =0;
		int i=0,j=0,sum=0;
		while(temp>0) {
			temp/=10;
			length++;
		}
	int[] num= new int[length];
	for(i=length-1;i>=0;i--) {
		num[i]=value%10;
		value/=10;
		sum+=num[i];
		
	}
	System.out.printf("%d = ",y);
	for(j=0;j<length;j++) {
		System.out.printf("%d",num[j]);
		if(j!=length-1) {
			System.out.printf(" + ");
		}
	}
	System.out.printf(" = %d",sum);
	}
	
}
