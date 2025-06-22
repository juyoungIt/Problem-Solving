// BOJ - 7449
// Problem Sheet - https://www.acmicpc.net/problem/7449

import java.util.*;
import java.io.*;

public class Main {

    static class Camarade {
        private final int number;
        private final int depth;

        public Camarade(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }

        public int getNumber() { return this.number; }
        public int getDepth() { return this.depth; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] al = new ArrayList[n + 1];
        for (int i=0 ; i<n ; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            int c = Integer.parseInt(row[0]);
            int nc = Integer.parseInt(row[1]);
            for (int j=0 ; j<nc ; j++) {
                int a = Integer.parseInt(row[j + 2]);
                al[c].add(a);
                al[a].add(c);
            }
        }
        String[] row = br.readLine().split(" ");
        int c1 = Integer.parseInt(row[0]);
        int c2 = Integer.parseInt(row[1]);

        Deque<Camarade> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new Camarade(c1, 0));
        visited[c1] = true;
        int minDist = -1;
        while (!queue.isEmpty()) {
            Camarade cur = queue.poll();
            if (cur.getNumber() == c2) minDist = cur.getDepth();
            for (int nc : al[cur.getNumber()]) {
                if (visited[nc]) continue;
                queue.add(new Camarade(nc, cur.getDepth() + 1));
                visited[nc] = true;
            }
        }

        System.out.printf("%d %d %d", c1, c2, minDist - 1);
        br.close();
    }
}
