import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();

		for(int i=0 ; i<size ; i++) {
			for(int j=size-(i+1) ; j>0 ; j--)
				System.out.print(" ");
			for(int j=0 ; j<i+1 ; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
