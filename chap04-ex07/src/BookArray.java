import java.awt.print.Book;
import java.util.Scanner;

public class BookArray {
	String title, author;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book [] book = new Scoanner(System.in);
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0;i<book.length;i++){
			System.out.print("Title :");
			String title = scanner.nextLine();
			System.out.print("Author :");
			String author = scanner.nextLine();
			book[i] = new Book(title,author);hh
		}
		

	}

}
