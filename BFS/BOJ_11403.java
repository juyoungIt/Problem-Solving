// BOJ - 11403
// Problem Sheet - https://www.acmicpc.net/problem/11403

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 정점의 수
        int[][] answer = new int[n+1][n+1]; // 각 node에 대한 방문가능여부 저장
        List<Integer>[] al = new LinkedList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1 ; j<=n ; j++) {
                int node = Integer.parseInt(st.nextToken());
                if(node == 1) {
                    al[i].add(j);
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            bfs(al, answer, i);
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }

    static void bfs(List<Integer>[] al, int[][] answer, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            for(int node : al[queue.peek()]) {
                if(answer[start][node] == 0) {
                    answer[start][node] = 1;
                    queue.add(node);
                }
            }
            queue.poll();
        }
    }
}