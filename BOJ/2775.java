import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int tc_size = key.nextInt();
		int[][] tc_arr = new int[tc_size][2];

		for(int i=0 ; i<tc_size ; i++) {
			tc_arr[i][0] = key.nextInt();
			tc_arr[i][1] = key.nextInt();
		}

		for(int i=0 ; i<tc_size ; i++)
			System.out.println(numOfPeople(tc_arr[i][0], tc_arr[i][1]));
		key.close();
	}

	public static int numOfPeople(int floor, int num) {
		int sum = 0;

		if (floor == 0) return num;
		else {
			for (int i=0 ; i<num ; i++)
				sum += numOfPeople(floor-1, i+1);
			return sum;
		}
	}
}
