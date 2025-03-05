// BOJ - 1697
// Problem Sheet - https://www.acmicpc.net/problem/1697

import java.util.*;
import java.io.*;

public class Main {

    static class Time {
        private final int location;
        private final int time;

        public Time(int location, int time) {
            this.location = location;
            this.time = time;
        }

        public int getLocation() { return this.location; }
        public int getTime() { return this.time; }
    }

    private static int N, K;
    private static final boolean[] isUsed = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        K = Integer.parseInt(row[1]);
        br.close();
    }

    private static int solve() {
        int time = 0;
        Queue<Time> queue = new ArrayDeque<>();
        queue.add(new Time(N, 0));
        isUsed[N] = true;
        while (!queue.isEmpty()) {
            int curLocation = queue.peek().getLocation();
            int curTime = queue.peek().getTime();
            if (curLocation == K) {
                time = queue.peek().getTime();
                break;
            }
            int[] next = { curLocation - 1, curLocation + 1, curLocation * 2 };
            for (int i=0 ; i<3 ; i++) {
                if (isNotValid(next[i]) || isUsed[next[i]]) continue;
                queue.add(new Time(next[i], curTime + 1));
                isUsed[next[i]] = true;
            }
            queue.poll();
        }
        return time;
    }

    private static boolean isNotValid(int v) {
        return !(v>=0 && v<=100_000);
    }
}