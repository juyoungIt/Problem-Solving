import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String num1 = key.next();
		String num2 = key.next();
		String res = "";
		int num1Len = num1.length();
		int num2Len = num2.length();
		int diff = ((num1Len-num2Len) > 0) ? (num1Len-num2Len) : (num2Len - num1Len);
		int carry = 0;

		for(int i=0 ; i<diff ; i++) {
			if(num1Len >= num2Len) num2 = "0" + num2;
			else num1 = "0" + num1;
		}

		int len = num1.length();
		for(int i=len-1 ; i>=0 ; i--) {
			int a = Integer.parseInt(num1.charAt(i)+"");
			int b = Integer.parseInt(num2.charAt(i)+"");

			if(carry+a+b >= 10) {
				res = Integer.toString((carry+a+b)%10) + res;
				carry = 1;
			} else {
				res = Integer.toString(carry+a+b) + res;
				carry = 0;
			}
		}
		
		if(carry == 1)
			res = Integer.toString(carry) + res;

		System.out.println(res);
	}
}
