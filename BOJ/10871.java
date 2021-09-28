import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();
		int num = key.nextInt();
		int[] arr = new int[size];

		for(int i=0 ; i<size ; i++)
			arr[i] = key.nextInt();

		for(int i=0 ; i<size ; i++) {
			if(arr[i] < num)
				System.out.print(arr[i] + " ");
		}
	}
}
