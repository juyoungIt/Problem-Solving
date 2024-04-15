// BOJ - 30468
// Problem Sheet - https://www.acmicpc.net/problem/30468

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalSum = 0;
        for (int i=0 ; i<4 ; i++) {
            totalSum += Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(st.nextToken());
        int diff = n * 4 - totalSum;

        System.out.println(Math.max(diff, 0));

        br.close();
        System.exit(0);
    }
}