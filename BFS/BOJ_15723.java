// BOJ - 15723
// Problem Sheet - https://www.acmicpc.net/problem/15723

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] al = new ArrayList[26]; // adjacency list
        for(int i=0 ; i<26 ; i++)
            al[i] = new ArrayList<>();

        int n = Integer.parseInt(bf.readLine()); // 전제의 수
        for(int i=0 ; i<n ; i++) {
            String[] nodes = bf.readLine().split(" is ");
            al[getIndex(nodes[0].charAt(0))].add(getIndex(nodes[1].charAt(0)));
        }

        int m = Integer.parseInt(bf.readLine()); // 확인할 문제의 수
        boolean[] answers = new boolean[m]; // 각 질문에 대한 정답 저장
        for(int i=0 ; i<m ; i++) {
            String[] nodes = bf.readLine().split(" is ");
            answers[i] = search(al, getIndex(nodes[0].charAt(0)), getIndex(nodes[1].charAt(0)));
        }

        // 종합된 결과를 출력
        for(boolean answer : answers)
            System.out.println((answer) ? 'T' : 'F');

        bf.close();
        System.exit(0);
    }

    static boolean search(ArrayList<Integer>[] al, int start, int target) {
        Queue<Integer> queue = new LinkedList<>(); // bfs에 사용할 queue
        boolean[] visit = new boolean[26]; // 방문정보
        boolean result = false;

        visit[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            if(queue.peek() == target) {
                result = true;
                break;
            }
            for(int node : al[queue.peek()]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(node);
                }
            }
            queue.poll();
        }
        return result;
    }

    static int getIndex(char c) { return (int)(c)-97; }
}