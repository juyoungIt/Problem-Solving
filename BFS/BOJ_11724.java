// BOJ - 11724
// Problem Sheet - https://www.acmicpc.net/problem/11724

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 갯수 (vertex)
        int m = Integer.parseInt(st.nextToken()); // 간선의 갯수 (edge)
        int[][] am = new int[n+1][n+1];     // adjacent matrix
        boolean[] visit = new boolean[n+1]; // 방문여부
        int answer = 0; // 연결요소의 수

        // adjacent matrix를 간선정보를 기반으로 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            am[idx1][idx2] = 1;
            am[idx2][idx1] = 1;
        }

        for(int i=1 ; i<n+1 ; i++) {
            if(!visit[i]) {
                bfs(am, visit, i);
                answer++;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void bfs(int[][] am, boolean[] visit, int start) {
        Queue<Integer> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
        visit[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            for(int i=1 ; i<am.length ; i++) {
                if(am[queue.peek()][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
            queue.poll();
        }
    }
}