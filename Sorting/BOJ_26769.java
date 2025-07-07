// BOJ - 26769
// Problem Sheet - https://www.acmicpc.net/problem/26769

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] l;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            l[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    static long solve() {
        if (n < 4) return 0;
        Arrays.sort(l);
        return (long) l[n - 4] * l[n - 4];
    }

}