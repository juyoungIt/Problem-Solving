// BOJ - 25516
// Problem Sheet - https://www.acmicpc.net/problem/25516

import java.util.*;
import java.io.*;

public class Main {
    private static int answer = 0; // 수확 가능한 사과의 수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int k = Integer.parseInt(st.nextToken()); // 최대로 탐색 가능한 depth의 수
        ArrayList<Integer>[] al = new ArrayList[n]; // adjacency list
        for(int i=0 ; i<n ; i++)
            al[i] = new ArrayList<>();
        int[] apples = new int[n]; // 사과의 유무 및 방문정보 저장

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx1].add(idx2);
            al[idx2].add(idx1);
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            apples[i] = Integer.parseInt(st.nextToken());

        // dfs를 수행하며 수확가능한 사과의 수를 종합함
        dfs(al, apples, 0, 0, k);

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    static void dfs(ArrayList<Integer>[] al, int[] apples, int curNum, int curDepth, int maxDepth) {
        if(curDepth > maxDepth) return;
        if(apples[curNum] == 1) answer++;
        apples[curNum] = -1;
        for(int node : al[curNum]) {
            if(apples[node] != -1)
                dfs(al, apples, node, curDepth+1, maxDepth);
        }
    }
}