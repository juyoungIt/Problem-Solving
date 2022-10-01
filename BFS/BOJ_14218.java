// BOJ - 14218
// Problem Sheet - https://www.acmicpc.net/problem/14218

import java.util.*;
import java.io.*;

class Node {
    private final int index;
    private final int depth;

    public Node(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }

    public int getIndex() { return this.index; }
    public int getDepth() { return this.depth; }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());
            al[index1].add(index2);
            al[index2].add(index1);
        }

        int q = Integer.parseInt(bf.readLine()); // 정비 계획에 있는 도로의 수
        int[][] answers = new int[q][n+1]; // 정답을 저장하는 배열
        for(int i=0 ; i<q ; i++)
            Arrays.fill(answers[i], -1);
        for(int i=0 ; i<q ; i++) {
            st = new StringTokenizer(bf.readLine());
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());
            al[index1].add(index2);
            al[index2].add(index1);
            bfs(al, answers, 1, i);
        }

        // 종합된 정답을 출력
        for(int i=0 ; i<q ; i++) {
            for(int j=1 ; j<=n ; j++)
                System.out.print(answers[i][j] + " ");
            System.out.println();
        }

        bf.close();
        System.exit(0);
    }

    static void bfs(ArrayList<Integer>[] al, int[][] answers, int start, int seq) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[al.length];

        visit[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            int curIndex = queue.peek().getIndex();
            int curDepth = queue.peek().getDepth();
            answers[seq][curIndex] = curDepth;
            for(int node : al[curIndex]) {
                if(!visit[node]) {
                    visit[node] = true;
                    queue.add(new Node(node, curDepth+1));
                }
            }
            queue.poll();
        }
    }
}