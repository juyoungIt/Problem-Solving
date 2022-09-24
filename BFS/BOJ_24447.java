// BOJ - 24447
// Problem Sheet - https://www.acmicpc.net/problem/24447

import java.util.*;
import java.io.*;

class Node {
    private final int number; // node의 번호
    private final int depth;  // bfs 탐색 시의 depth

    public Node(int number, int depth) {
        this.number = number;
        this.depth = depth;
    }

    public int getNumber() { return this.number; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작하는 노드
        boolean[] visit = new boolean[n+1]; // 각 node의 방문정보
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>(); // bfs를 위한 queue
        int[] depths = new int[n+1]; // 각 node의 depth 정보를 기록함
        int[] sequence = new int[n+1]; // bfs 수행 시 각 노드의 방문순서를 기록함
        Arrays.fill(depths, -1); // 미방문 node에 대한 처리를 위해 배열의 모든 값을 -1로 초기화 함
        int seq = 1; // 현재 탐색된 순서
        long answer = 0;

        // 입력된 정보를 바탕으로 adjacency list를 작성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }

        // adjacency list의 각 인접정점들을 오름차순으로 정렬함
        for(int i=1 ; i<=n ; i++)
            Collections.sort(al[i]);

        // bfs를 수행하며 각 node의 depth 정보를 기록함
        visit[r] = true;
        queue.add(new Node(r, 0));
        depths[r] = 0;
        sequence[r] = seq++;
        while(!queue.isEmpty()) {
            int curNode = queue.peek().getNumber();
            int curDepth = queue.peek().getDepth();
            for(int node : al[curNode]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(new Node(node, curDepth+1));
                    depths[node] = curDepth+1;
                    sequence[node] = seq++;
                }
            }
            queue.poll();
        }

        // 산출된 결과를 출력함
        for(int i=1 ; i<=n ; i++)
            answer += (long)sequence[i] * depths[i];

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}