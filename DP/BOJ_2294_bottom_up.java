// BOJ - 2294
// Problem Sheet - https://www.acmicpc.net/problem/2294

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static int[] coins;
    private static int[] counts;

    public static void main(String[] args) throws IOException {
        input();
        int count = solve();
        System.out.println(count == 100_001 ? -1 : count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        coins = new int[n];
        counts = new int[10_001];
        Arrays.fill(counts, 100_001);
        for (int i=0 ; i<n ; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k) counts[coins[i]] = 1;
        }
        br.close();
    }

    private static int solve() {
        for (int i=1 ; i<=k ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (i + coins[j] > k) continue;
                counts[i + coins[j]] = Math.min(counts[i + coins[j]], counts[i] + 1);
            }
        }
        return counts[k];
    }
}
