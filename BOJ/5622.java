import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String str = key.nextLine();
		int basic = 2;
		int time = 0;

		for(int i=0 ; i<str.length() ; i++) {
			int tmp = (int)str.charAt(i);
			if(tmp>=65 && tmp<=67) time += basic+1;
			else if(tmp>=68 && tmp<=70) time += basic+2;
			else if(tmp>=71 && tmp<=73) time += basic+3;
			else if(tmp>=74 && tmp<=76) time += basic+4;
			else if(tmp>=77 && tmp<=79) time += basic+5;
			else if(tmp>=80 && tmp<=83) time += basic+6;
			else if(tmp>=84 && tmp<=86) time += basic+7;
			else if(tmp>=87 && tmp<=90) time += basic+8;
		}

		System.out.println(time);
	}
}
