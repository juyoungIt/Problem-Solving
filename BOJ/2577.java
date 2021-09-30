import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int a, b, c, tmp;
		int[] arr = new int[10];

		a = key.nextInt();
		b = key.nextInt();
		c = key.nextInt();

		tmp = a * b * c;
		while(true) {
			arr[tmp%10]++;
			tmp /= 10;
			if(tmp == 0) break;
		}

		for(int i=0 ; i<10 ; i++)
			System.out.println(arr[i]);
	}
}
