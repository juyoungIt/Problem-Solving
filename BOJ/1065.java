import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int n = key.nextInt();
		int count = 0;

		for(int i=1 ; i<=n ; i++)
			if(isHan(i)) count++;

		System.out.println(count);
	}

	public static boolean isHan(int num) {
		int num1, num2, diff=0;
		boolean init = true;

		while(true) {
			num1 = num%10;
			num2 = (num/10)%10;
			if(init) {
				diff = num1 - num2;
				init = false;
			} else {
				if(diff != num1 - num2)
					return false;
			}
			num /= 10;
			if(num/10 == 0) return true;
		}
	}
}
