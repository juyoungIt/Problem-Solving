import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int testSize = key.nextInt();
		int[] testCase = new int[testSize*2];

		for(int i=0 ; i<testSize ; i++) {
			testCase[i*2] = key.nextInt();
			testCase[i*2+1] = key.nextInt();
		}

		for(int i=0 ; i<testSize ; i++)
			System.out.println(testCase[i*2]+testCase[i*2+1]);
	}
}
