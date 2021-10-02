import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String str = key.nextLine();
		int[] alpha = new int[26];

		// initialization
		for(int i=0 ; i<26 ; i++)
			alpha[i] = -1;

		for(int i=0 ; i<str.length() ; i++) {
			int tmp = (int)str.charAt(i)-97;
			if(alpha[tmp] == -1)
				alpha[tmp] = i;
		}

		for(int i=0 ; i<26 ; i++)
			System.out.print(alpha[i] + " ");
	}
}
