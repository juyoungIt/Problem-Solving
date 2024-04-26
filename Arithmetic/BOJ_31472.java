// BOJ - 31472
// Problem Sheet - https://www.acmicpc.net/problem/31472

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(br.readLine());
        System.out.println((int) Math.sqrt(w * 2) * 4);

        br.close();
        System.exit(0);
    }
}