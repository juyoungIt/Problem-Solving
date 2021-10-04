import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String str = key.nextLine();
		int count = 0;
		
		str = str.trim(); // delete white space
		String[] word = str.split(" ");

		for(int i=0 ; i<word.length ; i++)
			if(!word[i].equals(""))
				count++;

		System.out.println(count);
	}
}
