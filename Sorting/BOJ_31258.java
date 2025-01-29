// BOJ - 31258
// Problem Sheet - https://www.acmicpc.net/problem/31258

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static int[] a, b;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        a = new int[n];
        b = new int[m];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            a[i] = Integer.parseInt(row[i]);
        }
        row = br.readLine().split(" ");
        for (int i=0 ; i<m ; i++) {
            b[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static String solve() {
        int count = Math.min(n, m);
        int price = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0 ; i<count ; i++) {
            price += a[n - 1 - i] * b[m - 1 - i];
        }
        return String.format("%d %d", count, price);
    }
}