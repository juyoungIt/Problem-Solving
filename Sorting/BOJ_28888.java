// BOJ - 28888
// Problem Sheet - https://www.acmicpc.net/problem/28888

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Integer[] a;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new Integer[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            a[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(a, (e1, e2) -> e2 - e1);
        br.close();
    }

    static int solve() {
        int max = 0;
        for (int i=0 ; i<n ; i++) {
            max = Math.max(max, a[i] + i);
        }
        return max;
    }

}