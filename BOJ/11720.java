import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int length = key.nextInt();
		key.nextLine(); // for buffer cleaning
		String arr = key.nextLine();
		int sum = 0;

		for(int i=0 ; i<length ; i++)
			sum += Character.getNumericValue(arr.charAt(i));

		System.out.println(sum);
	}
}
