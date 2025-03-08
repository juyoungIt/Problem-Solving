// BOJ - 5014
// Problem Sheet - https://www.acmicpc.net/problem/5014

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        private final int floor;
        private final int clickCount;

        public Status(int floor, int clickCount) {
            this.floor = floor;
            this.clickCount = clickCount;
        }

        public int getFloor() { return this.floor; }
        public int getClickCount() { return this.clickCount; }
    }

    private static int F, S, G, U, D;
    private static boolean[] visited;

    private static final String FAILED = "use the stairs";

    public static void main(String[] args) throws IOException {
        input();
        int clickCount = bfs();
        System.out.println(clickCount >= 0 ? clickCount : FAILED);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        F = Integer.parseInt(row[0]);
        S = Integer.parseInt(row[1]);
        G = Integer.parseInt(row[2]);
        U = Integer.parseInt(row[3]);
        D = Integer.parseInt(row[4]);
        br.close();
    }

    private static int bfs() {
        int clickCount = -1;
        Queue<Status> queue = new ArrayDeque<>();
        visited = new boolean[F + 1];
        queue.add(new Status(S, 0));
        visited[S] = true;
        while (!queue.isEmpty()) {
            Status cur = queue.poll();
            if (cur.getFloor() == G) {
                clickCount = cur.getClickCount();
                break;
            }
            int[] nextFloor = { cur.getFloor() + U, cur.getFloor() - D };
            for (int i=0 ; i<2 ; i++) {
                if (isOutOfRange(nextFloor[i]) || visited[nextFloor[i]]) continue;
                queue.add(new Status(nextFloor[i], cur.getClickCount() + 1));
                visited[nextFloor[i]] = true;
            }
        }
        return clickCount;
    }

    private static boolean isOutOfRange(int floor) {
        return !(floor > 0 && floor <= F);
    }
}