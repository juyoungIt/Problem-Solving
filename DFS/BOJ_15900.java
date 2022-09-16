// BOJ - 15900
// Problem Sheet - https://www.acmicpc.net/problem/15900

import java.util.*;
import java.io.*;

public class Main {
    private static int count = 0; // dfs 탐색에 들어간 depth
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer>[] al = new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[n+1]; // 방문여부
        // 입력된 정보를 기반으로 adjacency list를 구성함
        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }

        dfs(al, 1, visit, 0);

        System.out.println((count%2 == 0) ? "No" : "Yes");

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, int start, boolean[] visit, int depth) {
        visit[start] = true;
        boolean childExist = false;
        for(int node : al[start]) {
            if(!visit[node]) {
                childExist = true;
                dfs(al, node, visit, depth+1);
            }
        }
        if(!childExist)
            count += depth;
    }
}