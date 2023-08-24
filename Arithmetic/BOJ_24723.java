// BOJ - 24723
// Problem Sheet - https://www.acmicpc.net/problem/24723

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        System.out.println(1 << N);

        bf.close();
        System.exit(0);
    }
}