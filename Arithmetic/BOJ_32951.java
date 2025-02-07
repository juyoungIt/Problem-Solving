// BOJ - 32951
// Problem Sheet - https://www.acmicpc.net/problem/32951

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N - 2024);
        br.close();
    }
}