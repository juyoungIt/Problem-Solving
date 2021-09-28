import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int dan = key.nextInt();

		for(int i=0 ; i<9 ; i++)
			System.out.println(dan + " * " + (i+1) + " = " + dan*(i+1));
	}
}
