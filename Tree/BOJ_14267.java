// BOJ - 14267
// Problem Sheet - https://www.acmicpc.net/problem/14267

import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static List<Integer>[] al;
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        al = new ArrayList[n + 1];
        for (int i=1 ; i<=n ; i++) {
            al[i] = new ArrayList<>();
        }
        sum = new int[n + 1];

        row = br.readLine().split(" ");
        for (int i=1 ; i<n ; i++) {
            int boss = Integer.parseInt(row[i]);
            al[boss].add(i + 1);
        }

        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            int e = Integer.parseInt(row[0]);
            int c = Integer.parseInt(row[1]);
            sum[e] += c;
        }

        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        getComplimentSum(1);
        for (int i=1 ; i<=n ; i++) {
            sb.append(sum[i]).append(" ");
        }
        return sb.toString();
    }

    private static void getComplimentSum(int targetNode) {
        for (int child : al[targetNode]) {
            if (targetNode < child) {
                sum[child] += sum[targetNode];
                getComplimentSum(child);
            }
        }
    }
}