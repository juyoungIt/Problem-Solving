import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int str_size = key.nextInt();
		String[] str = new String[str_size];
		ArrayList<String> store = new ArrayList<>();
		boolean isGroup = true;

		int count = 0;
		
		key.nextLine(); // for buffer cleaning...
		for(int i=0 ; i<str_size ; i++)
			str[i] = key.nextLine();

		for(int i=0 ; i<str_size ; i++) {
			for(int j=0 ; j<str[i].length() ; j++) {
				if(j == 0) store.add(str[i].charAt(j) + "");
				else if(str[i].charAt(j-1) != str[i].charAt(j)) {
					if(store.contains(str[i].charAt(j) + "")) {
						isGroup = false;
						break;
					}
					else store.add(str[i].charAt(j) + "");
				}
				else continue;
			}
			if(isGroup) count++;
			isGroup = true;
			store.clear(); // clear arraylist
		}
		System.out.println(count);
	}
}
