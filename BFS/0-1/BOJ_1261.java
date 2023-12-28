// BOJ - 1261
// Problem Sheet - https://www.acmicpc.net/problem/1261

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static final int[] xi = {-1, 1, 0, 0};
    private static final int[] yi = {0, 0, -1, 1};
    private static int[][] map;

    static class Status implements Comparable<Status> {
        private final int x;
        private final int y;
        private final int cost;

        public Status(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public int getCost() { return this.cost; }

        @Override
        public int compareTo(Status s) {
            return this.cost - s.getCost();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for(int i=1 ; i<=n ; i++) {
            String[] row = br.readLine().split("");
            for(int j=1 ; j<=m ; j++) {
                map[i][j] = Integer.parseInt(row[j-1]);
            }
        }

        Deque<Status> deque = new LinkedList<>();
        deque.add(new Status(1, 1, 0));
        map[1][1] = 2;
        while(!deque.isEmpty()) {
            Status curStatus = deque.pollFirst();
            int curX = curStatus.getX();
            int curY = curStatus.getY();
            int curCost = curStatus.getCost();

            if(curX == m && curY == n) {
                System.out.println(curCost);
                break;
            }

            for(int i=0 ; i<4 ; i++) {
                int nextX = curX + xi[i];
                int nextY = curY + yi[i];
                if(isValid(nextX, nextY, m, n) && map[nextY][nextX] < 2) {
                    if(map[nextY][nextX] == 0) {
                        deque.addFirst(new Status(nextX, nextY, curCost));
                    } else {
                        deque.addLast(new Status(nextX, nextY, curCost + 1));
                    }
                    map[nextY][nextX] = 2;
                }
            }
        }

        br.close();
        System.exit(0);
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x>0 && y>0 && x<=m && y<=n;
    }
}