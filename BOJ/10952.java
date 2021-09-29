import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();

		while(true) {
			int num1 = key.nextInt();
			int num2 = key.nextInt();
			if(num1 == 0 && num2 ==0) break;
			arr.add(num1);
			arr.add(num2);
		}

		for(int i=0 ; i<arr.size() ; i+=2)
			System.out.println(arr.get(i)+arr.get(i+1));
	}
}
