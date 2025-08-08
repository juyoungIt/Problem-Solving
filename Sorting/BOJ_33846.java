// BOJ - 33846
// Problem Sheet - https://www.acmicpc.net/problem/33846

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int t = Integer.parseInt(row[1]);
        int[] a = new int[n];
        row = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(a, 0, t);
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e).append(" ");
        System.out.println(sb);
        br.close();
    }
}