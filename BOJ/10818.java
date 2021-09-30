import java.util.Scanner;

public class Main {
	public static final int maximum = 1000000;
	public static final int minimum = -1000000;

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();
		int[] arr = new int[size];
		int max = minimum;
		int min = maximum;

		for(int i=0 ; i<size ; i++)
			arr[i] = key.nextInt();

		for(int i=0 ; i<size ; i++) {
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		
		System.out.println(min + " " + max);
	}
}
