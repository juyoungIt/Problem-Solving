import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int dest = key.nextInt();
		int solution = 1;
		int tmp = 0;

		while(true) {
			tmp += getLayerSize(solution);
			if(tmp >= dest) break;
			else solution++;
		}

		System.out.println(solution);
	}

	public static int getLayerSize(int layer) {
		if(layer == 1) return 1;
		else return 6 * (layer-1);
	}
}
