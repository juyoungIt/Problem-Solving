// BOJ - 7572
// Problem Sheet - https://www.acmicpc.net/problem/7572

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.printf("%c%d\n", ((n +8) % 12) + 65, (n+6) % 10);

        br.close();
        System.exit(0);
    }
}