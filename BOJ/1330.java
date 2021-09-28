import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int num1 = key.nextInt();
		int num2 = key.nextInt();
		
		if(num1 > num2)
			System.out.println(">");
		else if(num1 < num2)
			System.out.println("<");
		else
			System.out.println("==");
	}
}
