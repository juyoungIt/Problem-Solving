// BOJ - 2721
// Problem Sheet - https://www.acmicpc.net/problem/2721

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] acc = new int[302];
        for (int i=1 ; i<=301 ; i++) {
            acc[i] = acc[i - 1] + i;
        }
        long[] answer = new long[301];
        for (int i=1 ; i<=300 ; i++) {
            answer[i] = answer[i - 1] + (long) i * acc[i + 1];
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
