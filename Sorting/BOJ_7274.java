// BOJ - 7274
// Problem Sheet - https://www.acmicpc.net/problem/7274

import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        stairs = new int[n];
        for (int i=0 ; i<n ; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    static int solve() {
        Arrays.sort(stairs);
        int sum = 0;
        for (int i=0 ; i<n-k ; i++) {
            sum += stairs[i];
        }
        return sum;
    }

}