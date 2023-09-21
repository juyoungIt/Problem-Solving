// BOJ - 16204
// Problem Sheet - https://www.acmicpc.net/problem/16204

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(M, K) + Math.min(N - M, N - K));

        bf.close();
        System.exit(0);
    }
}