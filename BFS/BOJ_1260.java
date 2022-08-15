// BOJ - 1260
// Problem Sheet - https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int m = Integer.parseInt(st.nextToken()); // 간선의 갯수
        int v = Integer.parseInt(st.nextToken()); // 탐색을 시작하는 정점의 번호
        int[][] am = new int[n+1][n+1];   // 그래프에 대한 adjacent matrix
        boolean[] vr = new boolean[n+1];  // 각 vertex에 대한 방문여부저장
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            am[idx1][idx2] = 1;
            am[idx2][idx1] = 1;
        }

        // DFS
        dfs(am, vr, v);
        System.out.println();
        vr = new boolean[n+1]; // 재사용을 위해 초기화

        // BFS
        bfs(am, vr, v);
        System.out.println();

        bf.close();
        System.exit(0);
    }

    // dfs를 수행하며 해당 방문순서를 출력
    public static void dfs(int[][] am, boolean[] vr, int startIdx) {
        System.out.print(startIdx + " "); // 방문한 vertex 출력
        vr[startIdx] = true; // 방문정보 업데이트
        for(int i=1 ; i<am.length ; i++) {
            if(am[startIdx][i] == 1 && !vr[i])
                dfs(am, vr, i);
        }
    }

    // bfs를 수행하며 해당 방문순서를 출력
    public static void bfs(int[][] am, boolean[] vr, int startIdx) {
        Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
        System.out.print(startIdx + " "); // 방문한 vertex 출력
        queue.add(startIdx); // 방문한 vertex를 queue에 넣음
        vr[startIdx] = true; // 방문정보 업데이트

        // queue가 empty가 될 때까지 다음을 반복
        while(queue.size() > 0) {
            for(int i=1 ; i<am.length ; i++) {
                if(am[queue.peek()][i] == 1 && !vr[i]) {
                    System.out.print(i + " ");
                    queue.add(i);
                    vr[i] = true;
                }
            }
            queue.poll();
        }
    }
}