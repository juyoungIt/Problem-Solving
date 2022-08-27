// BOJ - 11725
// Problem Sheet - https://www.acmicpc.net/problem/11725

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine()); // 노드의 갯수
        LinkedList<Integer>[] al = new LinkedList[n+1]; // adjacency list
        for(int i=1 ; i<n+1 ; i++)
            al[i] = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
        boolean[] visit = new boolean[n+1]; // node에 대한 방문여부를 저장
        int[] answers = new int[n+1]; // 각 node의 부모 node를 저장

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }

        visit[1] = true;
        queue.add(1);
        while(!queue.isEmpty()) {
            for(int i=0 ; i<al[queue.peek()].size() ; i++) {
                if(!visit[al[queue.peek()].get(i)]) {
                    visit[al[queue.peek()].get(i)] = true;
                    queue.add(al[queue.peek()].get(i));
                    answers[al[queue.peek()].get(i)] = queue.peek();
                }
            }
            queue.poll();
        }

        for(int i=2 ; i<answers.length ; i++)
            System.out.println(answers[i]);

        bf.close();
        System.exit(0);
    }
}