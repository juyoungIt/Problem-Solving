// BOJ - 6118
// Problem Sheet - https://www.acmicpc.net/problem/6118

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 헛간의 수
        int m = Integer.parseInt(st.nextToken()); // 헛간들 사이의 관계의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        Queue<Integer> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
        int[] dist = new int[n+1]; // 각 헛간들은 1번 헛간으로의 거리
        boolean[] visit = new boolean[n+1]; // 각 헛간의 방문위치를 저장
        int[] answers = new int[3]; // 숨어야 하는 헛간의 번호, 그 헛간 까지의 거리, 같은 거리의 헛간 수

        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }
        for(int i=1 ; i<=n ; i++)
            Collections.sort(al[i]); // 각 요소들을 오름차순으로 정렬

        // 구성된 al을 기반으로 bfs를 수행함
        visit[1] = true;
        queue.add(1);
        while(!queue.isEmpty()) {
            for(int v : al[queue.peek()]) {
                if(!visit[v]) {
                    visit[v] = true;
                    dist[v] = dist[queue.peek()] + 1;
                    queue.add(v);
                }
            }
            queue.poll();
        }

        // 1로부터 가장 거리가 먼 node, 그리고 그 갯수를 카운트함
        for(int i=2 ; i<=n ; i++) {
            if(answers[1] < dist[i]) {
                answers[0] = i;
                answers[1] = dist[i];
                answers[2] = 1;
            }
            else if(answers[1] == dist[i])
                answers[2]++;
        }

        // 산출한 정답을 출력함
        for(int answer : answers)
            System.out.print(answer + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }
}