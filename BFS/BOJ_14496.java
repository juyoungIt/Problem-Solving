// BOJ - 14496
// Problem Sheet - https://www.acmicpc.net/problem/14496

import java.util.*;
import java.io.*;

class Node {
    private final int value;
    private final int depth;

    public Node(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    public int getValue() { return this.value; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());  // 시작하는 문자
        int target = Integer.parseInt(st.nextToken()); // 목표하는 문자

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 전체 문자의 수
        int m = Integer.parseInt(st.nextToken()); // 치환 가능한 문자의 수

        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            al[n1].add(n2);
            al[n2].add(n1);
        }
        boolean[] visit = new boolean[n+1]; // 방문정보 저장
        Queue<Node> queue = new LinkedList<>(); // bfs를 수행하기 위하여 필요한 queue
        boolean isReached = false;
        int answer = 0;

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curValue = queue.peek().getValue();
            int curDepth = queue.peek().getDepth();
            if(curValue == target) {
                isReached = true;
                answer = curDepth;
                break;
            }
            for(int v : al[curValue]) {
                if(!visit[v]) {
                    visit[v] = true;
                    queue.add(new Node(v, curDepth+1));
                }
            }
            queue.poll();
        }

        System.out.println((isReached) ? answer : -1);

        bf.close();
        System.exit(0);
    }
}