import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int tc_size = key.nextInt();
		int[] tcs_arr = new int[tc_size];
		String[] tc_arr = new String[tc_size];
		String[] res_arr = new String[tc_size];

		for(int i=0 ; i<tc_size ; i++) {
			tcs_arr[i] = key.nextInt();
			tc_arr[i] = key.nextLine();
			res_arr[i] = "";
			tc_arr[i] = tc_arr[i].trim(); // delete white space
		}

		for(int i=0 ; i<tc_size ; i++)
			for(int j=0 ; j<tc_arr[i].length() ; j++)
				for(int k=0 ; k<tcs_arr[i] ; k++)
					res_arr[i] += String.valueOf(tc_arr[i].charAt(j));

		for(int i=0 ; i<tc_size ; i++)
			System.out.println(res_arr[i]);
	}
}
