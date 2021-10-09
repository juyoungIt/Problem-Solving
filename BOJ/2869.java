import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int a, b, v;
		int days;
		a = key.nextInt();
		b = key.nextInt();
		v = key.nextInt();

		days = (v-a) / (a-b);
		if((v-a) % (a-b) != 0) days++;
		days++;

		System.out.println(days);
	}
}
