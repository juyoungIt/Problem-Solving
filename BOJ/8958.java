import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int size = key.nextInt();
		String[] testCase = new String[size];
		int weight = 1, score = 0;

		key.nextLine(); // for buffer cleaning
		for(int i=0 ; i<size ; i++)
			testCase[i] = key.nextLine();

		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<testCase[i].length() ; j++) {
				if(testCase[i].charAt(j) == 'O') {
					score += weight;
					weight++;
				}
				else
					weight = 1;
			}
			System.out.println(score);
			score = 0;
			weight = 1;
		}
	}
}
