// BOJ - 21937
// Problem Sheet - https://www.acmicpc.net/problem/21937

import java.util.*;
import java.io.*;

public class Main {
    private static int depth = 0; // 목표 작업을 수행하기 위해 필요한 이전 작업의 수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 작업의 수
        int m = Integer.parseInt(st.nextToken()); // 주어지는 작업과의 관계성 정보 수

        // 입력정보를 바탕으로 Adjacency list를 구성함
        ArrayList<Integer>[] al = new ArrayList[n+1];
        for(int i=1 ; i<n+1 ; i++)
            al[i] = new ArrayList<>();
        boolean[] visit = new boolean[n+1]; // 각 작업에 대한 수행여부 저장
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()); // 그 전에 완료해야 하는 작업
            int b = Integer.parseInt(st.nextToken()); // 목표 작업
            al[b].add(a);
        }
        int start = Integer.parseInt(bf.readLine());

        dfs(al, visit, start);

        System.out.println(depth);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, boolean[] visit, int start) {
        visit[start] = true;
        for(int node : al[start]) {
            if(!visit[node]) {
                depth++;
                dfs(al, visit, node);
            }
        }
    }
}