// BOJ - 5938
// Problem Sheet - https://www.acmicpc.net/problem/5938

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 소의 수
        int m = Integer.parseInt(st.nextToken()); // 연결의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[n+1];

        // 입력내용을 바탕으로 graph를 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            al[n1].add(n2);
            al[n2].add(n1);
        }

        // 1에서 bfs를 시작하여 연결된 요소들을 식별함
        findConnections(al, visit);

        // 1과 연결되지 않은 요소들을 출력함
        for(int i=2 ; i<=n ; i++)
            if(!visit[i]) answer.add(i);

        if(answer.size() == 0) System.out.println(0);
        else {
            for(int node : answer)
                System.out.println(node);
        }

        bf.close();
        System.exit(0);
    }

    static void findConnections(ArrayList<Integer>[] al, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>(); // bfs에 사용하기 위한 queue

        visit[1] = true;
        queue.add(1);
        while(!queue.isEmpty()) {
            for(int node : al[queue.peek()]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(node);
                }
            }
            queue.poll();
        }
    }
}