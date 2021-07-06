import java.util.Scanner;

public class BOJ_2920 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] input = new int[8];

		for(int i=0 ; i<8 ; i++)
			input[i] = key.nextInt();
		key.close();	
		System.out.println(checker(input));
	}

	private static String checker(int[] arr) {
		boolean increase = false;
		boolean decrease = false;

		for(int i=0 ; i<7 ; i++) {
			if(arr[i] - arr[i+1] == 1)
				decrease = true;
			else if(arr[i+1] - arr[i] == 1) {
				decrease = false;
				increase = true;
			}
			else {
				decrease = false;
				increase = false;
				break;
			}
		}
		
		if(increase && !decrease) return "ascending";
		else if(!increase && decrease) return "descending";
		else return "mixed";
	}
}