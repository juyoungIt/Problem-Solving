// BOJ - 1697
// Problem Sheet - https://www.acmicpc.net/problem/1697

import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static final int[] times = new int[100_001];

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(times[K]);
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
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) break;
            int[] next = { cur-1, cur+1, cur*2 };
            for (int i=0 ; i<3 ; i++) {
                if (isNotValid(next[i]) || times[next[i]] > 0) continue;
                times[next[i]] = times[cur] + 1;
                queue.add(next[i]);
            }
        }
    }

    private static boolean isNotValid(int v) {
        return !(v>=0 && v<=100_000);
    }
}