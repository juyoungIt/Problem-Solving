// BOJ - 24444
// Problem Sheet - https://www.acmicpc.net/problem/24444

import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(bf.readLine());
       int n = Integer.parseInt(st.nextToken()); // 정점의 수
       int m = Integer.parseInt(st.nextToken()); // 간선의 수
       int r = Integer.parseInt(st.nextToken()); // 시작 정점
       ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency matrix
       for(int i=1 ; i<=n ; i++)
           al[i] = new ArrayList<>();
       boolean[] visit = new boolean[n+1]; // 각 정점에 대한 방문여부
       Queue<Integer> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue
       int[] answers = new int[n+1]; // 방문 순서를 저장
       int sequence = 1; // 방문순서

       // 입력 정보를 기반으로 adjacency matrix를 구성함
       for(int i=0 ; i<m ; i++) {
           st = new StringTokenizer(bf.readLine());
           int idx1 = Integer.parseInt(st.nextToken());
           int idx2 = Integer.parseInt(st.nextToken());
           al[idx1].add(idx2);
           al[idx2].add(idx1);
       }

       // ArrayList의 각 요소들을 오름차순 정렬함
       for(int i=1 ; i<al.length ; i++)
           Collections.sort(al[i]);

       // bfs를 수행하며 정점을 방문 순서대로 출력함
       visit[r] = true;
       queue.add(r);
       answers[r] = sequence++;
       while(!queue.isEmpty()) {
           for(int v : al[queue.peek()]) {
               if(!visit[v]) {
                   visit[v] = true;
                   answers[v] = sequence++;
                   queue.add(v);
               }
           }
           queue.poll();
       }

       for(int i=1 ; i<=n ; i++)
           System.out.println(answers[i]);

       bf.close();
       System.exit(0);
   }
}