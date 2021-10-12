import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();
		int count = 0;

		while(true) {
			if((n != 0) && (n < 3)) {
				count = -1;
				break;
			} else if(n%5 == 0) {
				count += n/5;
				break;
			} else if(n%5 != 0) {
				n -= 3;
				count++;
			}
		}
		key.close();
		System.out.println(count);
	}
}
