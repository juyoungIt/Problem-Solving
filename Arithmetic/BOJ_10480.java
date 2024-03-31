// BOJ - 10480
// Problem Sheet - https://www.acmicpc.net/problem/10480

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0 ; i<n ; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x % 2 == 0) {
                sb.append(x).append(" is even").append("\n");
            } else {
                sb.append(x).append(" is odd").append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}