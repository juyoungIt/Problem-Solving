// BOJ - 12851
// Problem Sheet - https://www.acmicpc.net/problem/12851

import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static final int[] times = new int[100_001];
    private static final int[] counts = new int[100_001];

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(times[K]);
        System.out.println(counts[K]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        K = Integer.parseInt(row[1]);
        Arrays.fill(times, -1);
        br.close();
    }

    private static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        times[N] = 0;
        counts[N] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) break;
            int[] next = { cur-1, cur+1, cur*2 };
            for (int i=0 ; i<3 ; i++) {
                if (isNotValid(next[i])) continue;
                if (times[next[i]] == -1) {
                    times[next[i]] = times[cur] + 1;
                    counts[next[i]] = counts[cur];
                    queue.add(next[i]);
                } else if (times[next[i]] == times[cur] + 1) {
                    counts[next[i]] += counts[cur];
                }
            }
        }
    }

    private static boolean isNotValid(int v) {
        return !(v>=0 && v<=100_000);
    }
}