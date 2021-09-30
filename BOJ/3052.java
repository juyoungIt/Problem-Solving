import java.util.Scanner;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] arr = new int[10];
		int[] tmp = new int[10];
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for(int i=0 ; i<10 ; i++)
			arr[i] = key.nextInt();

		for(int i=0 ; i<10 ; i++)
			map.put(arr[i]%42, arr[i]);

		System.out.println(map.size());
	}
}
