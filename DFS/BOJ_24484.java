// BOJ - 24484
// Problem Sheet - https://www.acmicpc.net/problem/24484

import java.util.*;
import java.io.*;

public class Main {
    private static int sequence = 1; // 탐색 순서에 대한 정보
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long answer = 0;

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        boolean[] visit = new boolean[n+1]; // 각 정점에 대한 방문정보
        long[] sequence = new long[n+1]; // 각 노드별 방문 순서에 대한 정보
        long[] depths = new long[n+1];   // 각 노드별 dfs depth에 대한 정보
        Arrays.fill(depths, -1);   // depth 배열의 각 요소를 -1로 초기화 함
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<n+1 ; i++)
            al[i] = new ArrayList<>();

        // 입력된 정보를 바탕으로 adjacency list를 구성함
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            al[u].add(v);
            al[v].add(u);
        }
        // 인접한 정점의 리스트들을 오름차순으로 정렬함
        for(int i=1 ; i<n+1 ; i++)
            al[i].sort(Collections.reverseOrder());

        dfs(al, visit, depths, sequence, r, 0);

        for(int i=1 ; i<=n ; i++)
            answer += sequence[i] * depths[i];

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, boolean[] visit, long[] depths, long[] sequences, int start, int depth) {
        visit[start] = true;
        depths[start] = depth;
        sequences[start] = sequence++;
        for(int node : al[start])
            if(!visit[node])
                dfs(al, visit, depths, sequences, node, depth+1);
    }
}