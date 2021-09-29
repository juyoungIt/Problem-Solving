import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int origin = key.nextInt();
		int res1, res2;
		int tmp = origin;
		int count = 0;
		
		while(true) {
			res1 = tmp/10 + tmp%10;
			res2 = ((tmp%10)*10 + res1%10);
			tmp = res2;
			count++;
			if(origin == tmp) break;
		}

		System.out.println(count);
	}
}
