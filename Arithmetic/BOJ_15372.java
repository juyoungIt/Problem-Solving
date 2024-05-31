// BOJ - 15372
// Problem Sheet - https://www.acmicpc.net/problem/15372

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((long) Math.pow(n, 2)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}