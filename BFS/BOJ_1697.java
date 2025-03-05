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
            int left = queue.peek().getLocation() - 1;
            if (isValid(left) && !isUsed[left]) {
                queue.add(new Time(left, curTime + 1));
                isUsed[left] = true;
            }
            int right = queue.peek().getLocation() + 1;
            if (isValid(right) && !isUsed[right]) {
                queue.add(new Time(right, curTime + 1));
                isUsed[right] = true;
            }
            int teleport = queue.peek().getLocation() * 2;
            if (isValid(teleport) && !isUsed[teleport]) {
                queue.add(new Time(teleport, curTime + 1));
                isUsed[teleport] = true;
            }
            queue.poll();
        }
        return time;
    }

    private static boolean isValid(int v) {
        return v>=0 && v<=100_000;
    }
}