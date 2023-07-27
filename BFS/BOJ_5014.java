// BOJ - 5014
// Problem Sheet - https://www.acmicpc.net/problem/5014

import java.util.*;
import java.io.*;

public class Main {

    private static final String FAILURE_MESSAGE = "use the stairs";

    static class Floor {
        private final int value;
        private final int depth;

        public Floor(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public int getValue() { return this.value; }
        public int getDepth() { return this.depth; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int F = Integer.parseInt(st.nextToken()); // 건물의 총 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 층 수
        int G = Integer.parseInt(st.nextToken()); // 가고싶은 층
        int[] M = new int[2];
        M[0] = Integer.parseInt(st.nextToken()); // 위로 가는 층 단위
        M[1] = -Integer.parseInt(st.nextToken()); // 아래로 가는 층 단위

        Queue<Floor> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        queue.add(new Floor(S, 0));
        visited[S] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            Floor floor = queue.poll();
            if(floor.getValue() == G) {
                count = floor.getDepth();
                break;
            }
            for(int i=0 ; i<2 ; i++) {
                if(M[i] != 0
                        && floor.getValue() + M[i] >= 1
                        && floor.getValue() + M[i] <= F
                        && !visited[floor.getValue() + M[i]]) {
                    queue.add(new Floor(floor.getValue() + M[i], floor.getDepth() + 1));
                    visited[floor.getValue() + M[i]] = true;
                }
            }
        }

        System.out.println((visited[G]) ? count : FAILURE_MESSAGE);

        bf.close();
        System.exit(0);
    }
}