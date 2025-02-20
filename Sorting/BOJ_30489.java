// BOJ - 30489
// Problem Sheet - https://www.acmicpc.net/problem/30489

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, k;
    private static int[] packages;
    private static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.printf("%.4f", solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        k = Integer.parseInt(row[2]);
        packages = new int[n];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            packages[i] = Integer.parseInt(row[i]);
            totalSize += packages[i];
        }
        br.close();
    }

    private static double solve() {
        Arrays.sort(packages);
        long completed = 0;
        for (int i=0 ; i<Math.min(m+k, n) ; i++) {
            completed += packages[n - 1 - i];
        }
        return (double) completed / totalSize * 100;
    }
}