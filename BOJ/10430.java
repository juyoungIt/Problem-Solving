import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int num1 = key.nextInt();
		int num2 = key.nextInt();
		int num3 = key.nextInt();
		System.out.println((num1 + num2) % num3);
		System.out.println(((num1 % num3) + (num2 % num3)) % num3);
		System.out.println((num1 * num2) % num3);
		System.out.println(((num1 % num3) * (num2 % num3)) % num3);
	}
}
