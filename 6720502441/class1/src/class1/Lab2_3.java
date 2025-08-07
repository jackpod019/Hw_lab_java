package class1;

import java.util.Scanner;

public class Lab2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 6;
		
		int[][]grid = new int [SIZE][SIZE];
		for (int i=0; i<SIZE ; i++) {
			for(int j=0;j<SIZE;j++) {
				grid[i][j]=i*SIZE+j+1;
				if(grid[i][j]==31)
					break;
			}
		}
		System.out.printf("Enter started day:");
		Scanner num = new Scanner(System.in);
		int day = num.nextInt();
		int line = 0;
		System.out.printf("Su Mo Tu We Th Fr Sa\n");
		for(int i=1;i<day;i++) {
			System.out.printf("  ");
			line++;
		}
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
					System.out.printf("%2d ",grid[i][j]);
					if(grid[i][j]==31)
						break;
					line++;
					if(line==7) {
						System.out.printf("\n");
						line=0;
					}
				}
				
		}
	}

}
