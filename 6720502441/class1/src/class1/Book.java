package class1;

import java.util.Scanner;

public class Book {
public String name;
public int price;
public int year;
public String author;
	public static void main(String[] args) {
		Book book1 = new Book();
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter Book name:");
		book1.name = sc.nextLine();
		Scanner gt = new Scanner(System.in);
		System.out.printf("Enter Book price:");
		book1.price = gt.nextInt();
		book1.author ="J.K Rowling";
		book1.year =2542;
		System.out.println("Book: "+book1.name+" Written by "+book1.author+" in "+ book1.year+"\n"+"Price is "+book1.price+" Bath");
		
		Book book2 = new Book();
		System.out.println(book2.name);
	}

}
