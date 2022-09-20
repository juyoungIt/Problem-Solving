// BOJ - 24481
// Problem Sheet - https://www.acmicpc.net/problem/24481

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        ArrayList<Integer>[] al = new ArrayList[n+1];
        for(int i=1 ; i<n+1 ; i++)
            al[i] = new ArrayList<>();
        int[] depths = new int[n+1];
        Arrays.fill(depths, -1); // 모든 node의 depth를 -1로 초기화 함
        boolean[] visit = new boolean[n+1]; // 각 간선에 대한 방문정보

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            al[u].add(v);
            al[v].add(u);
        }
        // adjacency의 각 인접 정점들을 오름차순 정렬
        for(int i=1 ; i<n+1 ; i++)
            Collections.sort(al[i]);

        dfs(al, depths, visit, r, 0);

        for(int i=1 ; i<n+1 ; i++)
            System.out.println(depths[i]);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, int[] depths, boolean[] visit, int start, int depth) {
        visit[start] = true;
        depths[start] = depth;
        for(int node : al[start])
            if(!visit[node])
                dfs(al, depths, visit, node, depth+1);
    }
}