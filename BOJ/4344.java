import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int tc = key.nextInt();
		int[] sn_arr = new int[tc];
		int[][] tc_arr = new int[tc][1000];
		int sum = 0, count = 0;
		double ave;

		for(int i=0 ; i<tc ; i++) {
			sn_arr[i] = key.nextInt();
			for(int j=0 ; j<sn_arr[i] ; j++)
				tc_arr[i][j] = key.nextInt();
		}

		for(int i=0 ; i<tc ; i++) {
			for(int j=0 ; j<sn_arr[i] ; j++)
				sum += tc_arr[i][j];
			ave = (double)sum / sn_arr[i];
			count = 0;
			sum = 0;
			for(int j=0 ; j<sn_arr[i] ; j++)
				if(tc_arr[i][j] > ave)
					count++;
			System.out.println(String.format("%.3f%%", (double)count/sn_arr[i]*100));
		}
	}
}
