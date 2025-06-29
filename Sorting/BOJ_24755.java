// BOJ - 24755
// Problem Sheet - https://www.acmicpc.net/problem/24755

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] p;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            p[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static int solve() {
        Arrays.sort(p);
        int sum = 0;
        for (int i=0 ; i<n ; i++) {
            if (i <= n / 2) sum += p[i] / 2;
            else sum += p[i];
        }
        return sum;
    }

}