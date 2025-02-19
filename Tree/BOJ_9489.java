// BOJ - 9489
// Problem Sheet - https://www.acmicpc.net/problem/9489

import java.io.*;
import java.util.Arrays;

public class Main {

    private static int n, k;
    private static int[] seq;
    private static final int[] parents = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] row = br.readLine().split(" ");
            n = Integer.parseInt(row[0]);
            k = Integer.parseInt(row[1]);
            if (n == 0 && k == 0) break;
            seq = new int[n];
            row = br.readLine().split(" ");
            for (int i=0 ; i<n ; i++) {
                seq[i] = Integer.parseInt(row[i]);
            }
            Arrays.fill(parents, 0);
            sb.append(solve()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int solve() {
        int prev = seq[0];
        int leafIndex = -1;
        for (int i=1 ; i<n ; i++) {
            if (!isSequential(prev, seq[i])) {
                leafIndex++;
                if (leafIndex >= n) break;
            }
            parents[seq[i]] = seq[leafIndex];
            prev = seq[i];
        }

        int count = 0;
        for (int i=1 ; i<parents.length ; i++) {
            if (i != k
                    && parents[parents[i]] > 0
                    && parents[i] != parents[k]
                    && parents[parents[i]] == parents[parents[k]]) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSequential(int a, int b) {
        return a + 1 == b;
    }
}