// BOJ - 2644
// Problem Sheet - https://www.acmicpc.net/problem/2644

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 전체 사람의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()); // 탐색 시작점
        int end = Integer.parseInt(st.nextToken());   // 최종적으로 찾고자 하는 타겟
        int m = Integer.parseInt(bf.readLine()); // 부모자식 관계의 수
        int[][] am = new int[n+1][n+1]; // adjacency matrix
        int[] visit = new int[n+1]; // 각 node에 대한 방문여부

        Queue<Integer> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        boolean founded = false; // 목표한 node를 발견했는 가?

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            am[idx1][idx2] = 1;
            am[idx2][idx1] = 1;
        }

        // bfs를 수행하며 찾고자 하는 node를 찾음
        visit[start] = 0;
        queue.add(start);
        while(!queue.isEmpty()) {
            if(founded) break;
            for(int i=1 ; i<=n ; i++) {
                if(am[queue.peek()][i] == 1 && visit[i] == 0) {
                    if(i == end)
                        founded = true;
                    visit[i] = visit[queue.peek()]+1;
                    queue.add(i);
                }
            }
            queue.poll();
        }

        System.out.println((founded) ? visit[end] : -1);

        bf.close();
        System.exit(0);
    }
}