import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int idx = key.nextInt();
		int layerIdx = 1;
		int innerIdx;

		while(true) {
			if((layerIdx * (layerIdx+1))/2 >= idx)
				break;
			layerIdx++;
		}

		innerIdx = idx - ((layerIdx * (layerIdx-1)) / 2);
		if(layerIdx%2 == 0)
			System.out.println(innerIdx + "/" + ((layerIdx+1)-innerIdx));
		else
			System.out.println(((layerIdx+1)-innerIdx) + "/" + innerIdx);
	}
}
