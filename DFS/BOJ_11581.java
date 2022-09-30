// BOJ - 11581
// Problem Sheet - https://www.acmicpc.net/problem/11581

import java.util.*;
import java.io.*;

public class Main {
    private static boolean isCycle = false; // cycle 발생여부를 의미
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); // 교차로의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        int[] visit = new int[n+1]; // 각 위치에 대한 방문정보 (0: 미방문, 1: 방문 중, 2: 방문완료)

        // 입력 정보를 바탕으로 adjacency list를 구성함
        for(int i=1 ; i<n ; i++) {
            int connCount = Integer.parseInt(bf.readLine()); // 연결된 node의 수
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<connCount ; j++)
                al[i].add(Integer.parseInt(st.nextToken()));
        }

        // dfs를 수행하여 cycle 발생 여부를 확인
        dfs(al, visit, 1, n);
        System.out.println((isCycle) ? "CYCLE" : "NO CYCLE");

        bf.close();
        System.exit(0);
    }

    // 아무래도 이곳의 작성내용을 변경하는 것이 좋을 듯
    static void dfs(ArrayList<Integer>[] al, int[] visit, int start, int target) {
        if(visit[start] == 1) {
            isCycle = true;
            return;
        }
        visit[start] = 1;
        for(int node : al[start]) {
            if(visit[node] != 2)
                dfs(al, visit, node, target);
        }
        visit[start] = 2;
    }
}