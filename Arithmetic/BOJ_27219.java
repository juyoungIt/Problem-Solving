// BOJ - 27219
// Problem Sheet - https://www.acmicpc.net/problem/27219

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append("V".repeat(Math.max(0, n / 5)));
        sb.append("I".repeat(Math.max(0, n % 5)));
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}