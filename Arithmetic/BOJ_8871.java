// BOJ - 8871
// Problem Sheet - https://www.acmicpc.net/problem/8871

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int minRounds = (n + 1) * 2;
        int maxRounds = (n + 1) * 3;

        System.out.printf("%d %d\n", minRounds, maxRounds);

        br.close();
        System.exit(0);
    }
}