// BOJ - 10204
// Problem Sheet - https://www.acmicpc.net/problem/10204

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int number; // 노드번호
        private final int depth; // 해당 탐색 Node의 depth

        public Node(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }

        public int getNumber() { return this.number; }
        public int getDepth() { return this.depth; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcSize = Integer.parseInt(bf.readLine().trim()); // 테스트 케이스의 수

        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] al = new ArrayList[nodeCount+1]; // adjacency list
            for(int j=1 ; j<=nodeCount ; j++) {
                al[j] = new ArrayList<>();
            }
            for(int j=0 ; j<edgeCount ; j++) {
                int idx1 = Integer.parseInt(parser(st.nextToken()));
                int idx2 = Integer.parseInt(parser(st.nextToken()));
                al[idx1].add(idx2);
                al[idx2].add(idx1);
            }
            int startNode = Integer.parseInt(parser(st.nextToken()));
            int count = bfs(al, startNode);
            System.out.println("The number of supervillains in 2-hop neighborhood of v" + startNode + " is " + count);
        }

        bf.close();
        System.exit(0);
    }

    static int bfs(ArrayList<Integer>[] al, int start) {
        Queue<Node> queue = new LinkedList<>(); // bfs에 사용하는 queue
        boolean[] visit = new boolean[al.length]; // 방문정보 저장
        int result = 0;

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curNumber = queue.peek().getNumber();
            int curDepth = queue.peek().getDepth();
            for(int nodeNumber : al[curNumber]) {
                if(!visit[nodeNumber]) {
                    if(curDepth + 1 <= 2)
                        result++;
                    else break;
                    visit[nodeNumber] = true;
                    queue.add(new Node(nodeNumber, curDepth+1));
                }
            }
            queue.poll();
        }
        return result;
    }

    static String parser(String str) {
        return str.substring(1);
    }
}