// BOJ - 14182
// Problem Sheet - https://www.acmicpc.net/problem/14182

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int income = Integer.parseInt(br.readLine());
            if (income == 0) {
                break;
            }
            if (income <= 1_000_000) {
                sb.append(income);
            } else if (income <= 5_000_000) {
                sb.append((int)(income * 0.9));
            } else {
                sb.append((int)(income * 0.8));
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}