import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int a = key.nextInt();
		int b = key.nextInt();
		int c = key.nextInt();
		int x = 0;

		if(b >= c)
			System.out.println(-1);
		else {
			x = a/(c-b)+1;
			System.out.println(x);
		}
	}
}
