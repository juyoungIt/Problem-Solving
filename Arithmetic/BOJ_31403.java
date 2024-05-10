// BOJ - 31403
// Problem Sheet - https://www.acmicpc.net/problem/31403

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        sb.append(a + b - c).append("\n");
        sb.append(Integer.parseInt(a + Integer.toString(b)) - c).append("\n");
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}