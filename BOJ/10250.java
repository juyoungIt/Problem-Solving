import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int tc_size = key.nextInt();
		int[][] tc_arr = new int[tc_size][3];
		int width, height;

		for (int i = 0; i < tc_size; i++)
			for (int j = 0; j < 3; j++)
				tc_arr[i][j] = key.nextInt();

		for (int i = 0; i < tc_size; i++) {
			height = (tc_arr[i][2] % tc_arr[i][0] == 0) ? tc_arr[i][0] : tc_arr[i][2] % tc_arr[i][0];
			width = (tc_arr[i][2] % tc_arr[i][0] != 0) ? ((tc_arr[i][2] / tc_arr[i][0]) + 1)
					: (tc_arr[i][2] / tc_arr[i][0]);
			System.out.println(height * 100 + width);
		}
		key.close();
	}
}
