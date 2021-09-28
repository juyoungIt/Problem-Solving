import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int hour = key.nextInt();
		int minute = key.nextInt();

		if(minute-45>=0)
			System.out.println(hour + " " + (minute-45));
		else {
			if(hour-1>=0)
				System.out.println((hour-1) + " " + (60+(minute-45)));
			else
				System.out.println((24+(hour-1)) + " " + (60+(minute-45)));
		}
	}
}
