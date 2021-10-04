import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] alpha = new int[26];
		String str = key.nextLine();
		int max_idx = 0;
		boolean duplicate = false;

		for(int i=0 ; i<str.length() ; i++) {
			int tmp = (int)str.charAt(i);
			if(tmp>=65 && tmp<97)
				alpha[tmp-65]++;
			else
				alpha[tmp-97]++;
		}

		for(int i=1 ; i<26 ; i++) {
			if(alpha[i] > alpha[max_idx]) {
				max_idx = i;
				duplicate = false;	
			}
			else if(alpha[i] == alpha[max_idx])
				duplicate = true;
		}

		if(duplicate)
			System.out.println("?");
		else
			System.out.println((char)(max_idx+65));
	}
}
