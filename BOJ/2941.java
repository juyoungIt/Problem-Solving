import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String str = key.nextLine();
		int count = 0;

		for(int i=0 ; i<str.length() ; i++) {
			if(i == str.length()-1)
				count++;
			else if(i == str.length()-2 && str.charAt(i) == 'd' && str.charAt(i+1) == 'z') {
				count += 2;
				i++;
			}
			else {
				if(str.charAt(i) == 'c' && str.charAt(i+1) == '=') {
					count++;
					i++;
				} else if(str.charAt(i) == 'c' && str.charAt(i+1) == '-') {
					count++;
					i++;
				} else if(str.charAt(i) == 'd' && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					count++;
					i += 2;
				} else if(str.charAt(i) == 'd' && str.charAt(i+1) == '-') {
					count++;
					i++;
				} else if(str.charAt(i) == 'l' && str.charAt(i+1) == 'j') {
					count++;
					i++;
				} else if(str.charAt(i) == 'n' && str.charAt(i+1) == 'j') {
					count++;
					i++;
				} else if(str.charAt(i) == 's' && str.charAt(i+1) == '=') {
					count++;
					i++;
				} else if(str.charAt(i) == 'z' && str.charAt(i+1) == '=') {
					count++;
					i++;
				} else
					count++;
			}
		}
		System.out.println(count);
	}
}
