// BOJ - 21633
// Problem Sheet - https://www.acmicpc.net/problem/21633

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        double commission = k * 0.01 + 25;
        if (commission < 100) {
            System.out.printf("%.2f\n", 100.0);
        } else if (commission > 2_000) {
            System.out.printf("%.2f\n", 2_000.0);
        } else {
            System.out.printf("%.2f\n", commission);
        }

        br.close();
        System.exit(0);
    }
}