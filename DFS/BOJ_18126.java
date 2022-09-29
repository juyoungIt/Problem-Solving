// BOJ - 18126
// Problem Sheet - https://www.acmicpc.net/problem/18126

import java.util.*;
import java.io.*;

class Node {
    private final int number; // 방의 번호
    private final long dist; // 해당 방에 도달하기 위한 거리

    public Node(int number, long dist) {
        this.number = number;
        this.dist = dist;
    }

    public int getNumber() { return this.number; }
    public long getDist() { return this.dist; }
}

public class Main {
    private static long distSum = 0; // 이동한 거리의 합
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 방의 수
        ArrayList<Node>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[n+1]; // 각 Node에 대한 방문정보

        StringTokenizer st;
        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken()); // a와 b 사이를 연결하는 가중치
            al[a].add(new Node(b, c));
            al[b].add(new Node(a, c));
        }

        // dfs를 통해 방문할 수 있는 거리의 최댓값을 구함
        dfs(al, visit, 1, 0);
        System.out.println(distSum);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Node>[] al, boolean[] visit, int start, long dist) {
        visit[start] = true;
        if(dist > distSum) distSum = dist;
        for(Node node : al[start])
            if(!visit[node.getNumber()])
                dfs(al, visit, node.getNumber(), dist+node.getDist());
    }
}