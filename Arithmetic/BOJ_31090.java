// BOJ - 31090
// Problem Sheet - https://www.acmicpc.net/problem/31090

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            if ((n + 1) % (n % 100) == 0) {
                sb.append("Good").append("\n");
            } else {
                sb.append("Bye").append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}