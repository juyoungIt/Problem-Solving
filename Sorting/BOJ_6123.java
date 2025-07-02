// BOJ - 6123
// Problem Sheet - https://www.acmicpc.net/problem/6123

import java.util.*;
import java.io.*;

public class Main {

    private static int n, l, k;
    private static int[] r;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        l = Integer.parseInt(row[1]);
        k = Integer.parseInt(row[2]);
        r = new int[n];
        for (int i=0 ; i<n ; i++) {
            r[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int solve() {
        Arrays.sort(r);
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            if (r[i] > l) break;
            l += k;
            count++;
        }
        return count;
    }

}
