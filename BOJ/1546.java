import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();
		double[] arr = new double[size];
		double max;
		double sum = 0.0;

		for(int i=0 ; i<size ; i++)
			arr[i] = key.nextInt();

		max = arr[0];
		for(int i=1 ; i<size ; i++)
			if(arr[i] > max) max = arr[i];

		for(int i=0 ; i<size ; i++)
			arr[i] = arr[i] / max * 100;

		for(int i=0 ; i<size ; i++)
			sum += arr[i];

		System.out.println(sum / size);
	}
}
