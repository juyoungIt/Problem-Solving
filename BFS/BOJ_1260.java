// BOJ - 1260
// Problem Sheet - https://www.acmicpc.net/problem/1260

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int vn = key.nextInt();       // vertex 수 (vertex number)
        int en = key.nextInt();       // edge 수 (edge number)
        int sv = key.nextInt();       // start vertex
        int[][] am = new int[vn][vn]; // adjacency matrix
        int[][] vr = new int[en][2];  // store the vertex relation

        for(int i=0 ; i<en ; i++) {
            vr[i][0] = key.nextInt();
            vr[i][1] = key.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean[] visitLog = new boolean[vn]; // 각 vertex에 대한 방문정보

        buildAM(am, vr);              // adjacency matrix 생성
        dfs(am, sv, visitLog, s);     // dfs 수행
        Arrays.fill(visitLog, false);
        System.out.println();
        bfs(am, sv, visitLog, q);     // bfs 수행

        key.close();
        System.exit(0);
    }

    // adjacency matrix 생성
    public static void buildAM(int[][] am, int[][] vr) {
        for(int i=0 ; i<vr.length ; i++) {
            am[vr[i][0]-1][vr[i][1]-1] = 1;
            am[vr[i][1]-1][vr[i][0]-1] = 1;
        }
    }

    // BFS Algorithm
    public static void bfs(int[][] am, int sv, boolean[] visit, Queue<Integer> q) {
        visit(sv, visit);
        q.offer(sv);

        while(!q.isEmpty()) {
            for(int i=0 ; i<am.length ; i++) {
                if(am[q.peek()-1][i] == 1 && !visit[i]) {
                    visit(i+1, visit);
                    q.offer(i+1);
                }
            }
            q.poll();
        }
    }

    // DFS Algorithm
    public static void dfs(int[][] am, int sv, boolean[] visit, Stack<Integer> s) {
        visit(sv, visit);
        s.push(sv);

        while(!s.isEmpty()) {
            for(int i=0 ; i<am.length ; i++) {
                if(!s.isEmpty() && am[s.peek() - 1][i] == 1 && !visit[i])
                    dfs(am, i + 1, visit, s);
            }
            if(!s.isEmpty())
                s.pop();
        }
    }

    // vertex를 방문하는 이벤트를 처리
    public static void visit(int vertex, boolean[] visit) {
        visit[vertex-1] = true;         // 방문정보를 업데이트
        System.out.print(vertex + " "); // 방문정보를 출력
    }
}