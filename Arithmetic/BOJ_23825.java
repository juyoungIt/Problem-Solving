// BOJ - 23825
// Problem Sheet - https://www.acmicpc.net/problem/23825

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(N / 2, M / 2));

        bf.close();
        System.exit(0);
    }
}