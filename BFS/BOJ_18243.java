// BOJ - 18243
// Problem Sheet - https://www.acmicpc.net/problem/18243

import java.util.*;
import java.io.*;

class Node {
    private final int nodeNum; // node의 번호
    private final int depth;   // 해당 node의 탐색 시 depth

    public Node(int nodeNum, int depth) {
        this.nodeNum = nodeNum;
        this.depth = depth;
    }

    public int getNodeNum() { return this.nodeNum; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean isSmallNetwork = true; // 해당 네트워크가 작은 세상 네트워크 인가?

        int n = Integer.parseInt(st.nextToken()); // 지구에 있는 사람의 수
        int k = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        boolean[] visit = new boolean[n+1]; // 각 node에 대한 방문정보
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();

        // 입력된 정보를 바탕으로 adjacency list를 구성함
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            al[n1].add(n2);
            al[n2].add(n1);
        }

        // 모든 node에 대하여 bfs를 수행하며 네트워크 상태를 점검함
        for(int i=1 ; i<=n ; i++) {
            int depth = bfs(al, visit, i);
            // 최대 depth가 6을 넘어가는 가?
            if(depth > 6) {
                isSmallNetwork = false;
                break;
            }
            // 모든 node를 방문하였는 가?
            for(int j=1 ; j<=n ; j++) {
                if(!visit[j])  {
                    isSmallNetwork = false;
                    break;
                }
            }
            Arrays.fill(visit, false); // 재사용을 위해 배열을 초기화함
        }

        // 결과를 출력
        System.out.println((isSmallNetwork) ? "Small World!" : "Big World!");

        bf.close();
        System.exit(0);
    }

    public static int bfs(ArrayList<Integer>[] al, boolean[] visit, int start) {
        Queue<Node> queue = new LinkedList<>(); // bfs를 수행하기 위한 queue
        int maxDepth = 0; // 해당 bfs에서 최대로 진행된 depth 값

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curNode = queue.peek().getNodeNum();
            int curDepth = queue.peek().getDepth();
            if(curDepth > maxDepth)
                maxDepth = curDepth;
            for(int node : al[curNode]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(new Node(node, curDepth+1));
                }
            }
            queue.poll();
        }
        return maxDepth;
    }
}