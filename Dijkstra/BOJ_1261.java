// BOJ - 1261
// Problem Sheet - https://www.acmicpc.net/problem/1261

import java.util.*;
import java.io.*;

public class Main {

    static class Status {
        final int x;
        final int y;
        final int cost;

        public Status(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static final int[] xi = { -1, 1, 0, 0 };
    static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[][] maze = new int[n][m];
        int[][] cost = new int[n][m];
        for (int i=0 ; i<n ; i++) {
            String row = br.readLine();
            for (int j=0 ; j<m ; j++) {
                if (row.charAt(j) == '1') {
                    maze[i][j] = 1;
                }
                cost[i][j] = n + m;
            }
        }

        PriorityQueue<Status> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        pq.add(new Status(0, 0, 0));
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            Status cur = pq.poll();
            for (int i=0 ; i<4 ; i++) {
                int newX = cur.x + xi[i];
                int newY = cur.y + yi[i];
                if (!isValid(newX, newY, m, n) || cost[newY][newX] <= cost[cur.y][cur.x] + maze[newY][newX]) continue;
                cost[newY][newX] = cost[cur.y][cur.x] + maze[newY][newX];
                pq.add(new Status(newX, newY, cost[newY][newX]));
            }
        }

        System.out.println(cost[n - 1][m - 1]);
        br.close();
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x>=0 && y>=0 && x<m && y<n;
    }

}