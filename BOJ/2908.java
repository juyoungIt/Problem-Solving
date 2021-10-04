import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String num1 = key.next();
		String num2 = key.next();
		int conv1=0, conv2=0;

		for(int i=0 ; i<3 ; i++) {
			conv1 += Integer.parseInt(num1.charAt(i)+"") * (int)Math.pow(10, i);
			conv2 += Integer.parseInt(num2.charAt(i)+"") * (int)Math.pow(10, i);
		}

		if(conv1 > conv2)
			System.out.println(conv1);
		else
			System.out.println(conv2);
	}
}
