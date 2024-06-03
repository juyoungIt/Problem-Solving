// BOJ - 30328
// Problem Sheet - https://www.acmicpc.net/problem/30328

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(n * 4000);

        br.close();
        System.exit(0);
    }
}