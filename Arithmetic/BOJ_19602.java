// BOJ - 19602
// Problem Sheet - https://www.acmicpc.net/problem/19602

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());

        System.out.println(s + 2 * m + 3 * l >= 10 ? "happy" : "sad");

        br.close();
        System.exit(0);
    }
}