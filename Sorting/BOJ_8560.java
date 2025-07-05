// BOJ - 8560
// Problem Sheet - https://www.acmicpc.net/problem/8560

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] pairs;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pairs = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            pairs[i][0] = Integer.parseInt(row[0]);
            pairs[i][1] = Integer.parseInt(row[1]);
        }
        br.close();
    }

    private static String solve() {
        Arrays.sort(pairs, (e1, e2) -> {
            double pairValue1 = getPairValue(e1[0], e1[1]);
            double pairValue2 = getPairValue(e2[0], e2[1]);
            if (pairValue1 == pairValue2) {
                return e1[0] - e2[0];
            }
            return Double.compare(pairValue1, pairValue2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<n ; i++) {
            sb.append(String.format("%d %d\n", pairs[i][0], pairs[i][1]));
        }
        return sb.toString();
    }

    private static double getPairValue(int l, int m) {
        return l / Math.pow(2, m);
    }

}