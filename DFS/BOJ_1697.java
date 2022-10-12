// BOJ - 1967
// Problem Sheet - https://www.acmicpc.net/problem/1967

import java.util.*;
import java.io.*;

class Node {
    private final int number; // 노드번호
    private final int weight; // 가중치

    public Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() { return this.number; }
    public int getWeight() { return this.weight; }
}

public class Main {
    private static int n; // 노드의 수
    private static ArrayList<Node>[] al; // adjacency list
    private static boolean[] visit; // 각 정점에 대한 방문여부
    private static int maxDist = 0; // 가장 멀리 떨어진 노드와의 거리
    private static int farNode = 0; // 가장 멀리 떨어진 노드의 번호
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine()); // 노드의 수

        if(n > 1) {
            al = new ArrayList[n+1];
            for(int i=1 ; i<=n ; i++)
                al[i] = new ArrayList<>();
            visit = new boolean[n+1]; // 각 정점에 대한 방문여부

            // 입력 정보를 바탕으로 adjacent matrix 구성
            for(int i=0 ; i<n-1 ; i++) {
                st = new StringTokenizer(bf.readLine());
                int idx1 = Integer.parseInt(st.nextToken());
                int idx2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                al[idx1].add(new Node(idx2, weight));
                al[idx2].add(new Node(idx1, weight));
            }

            dfs(1, 0);  // 1. root 노드로부터 가장 멀리 떨어진 노드를 찾음
            Arrays.fill(visit, false); // 재사용을 위해 초기화
            dfs(farNode, 0); // 2. 해당 노드로부터 가장 멀리 떨어진 노드와의 거리를 구함
        }

        System.out.println(maxDist);

        bf.close();
        System.exit(0);
    }

    static void dfs(int start, int dist) {
        if(maxDist < dist) {
            farNode = start;
            maxDist = dist;
        }
        visit[start] = true;
        for(Node n : al[start]) {
            if(!visit[n.getNumber()])
                dfs(n.getNumber(), dist+n.getWeight());
        }
    }
}