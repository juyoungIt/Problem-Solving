// BOJ - 6108
// Problem Sheet - https://www.acmicpc.net/problem/6108

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] cows;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cows = new int[n][n];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                cows[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static int solve() {
        int[] candidates = new int[n];
        for (int i=0 ; i<n ; i++) {
            Arrays.sort(cows[i]);
            candidates[i] = cows[i][n / 2];
        }
        Arrays.sort(candidates);
        return candidates[n / 2];
    }

}
