// BOJ - 17199
// Problem Sheet - https://www.acmicpc.net/problem/17199

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine()); // processing station의 수
        ArrayList<Integer>[] al = new ArrayList[n+1]; // adjacency list
        boolean[] visit = new boolean[n+1]; // 각 station에 대한 방문여부
        int[] vCount = new int[n+1]; // 각 station에 대한 방문횟수
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        int answer = -1;

        // 입력정보 바탕으로 adjacency list 구성
        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
        }

        // dfs를 수행하여 정보를 수집함
        for(int i=1 ; i<=n ; i++) {
            dfs(al, visit, vCount, i);
            Arrays.fill(visit, false); // 재사용을 위해 초기화
        }

        // 모든 지점에 방문 가능한 station 중 가장 작은 것을 찾음
        for(int i=1 ; i<=n ; i++) {
            if(vCount[i] == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    public static void dfs(ArrayList<Integer>[] al, boolean[] visit, int[] vCount, int start) {
        visit[start] = true;
        vCount[start]++;
        for(int station : al[start]) {
            if(!visit[station])
                dfs(al, visit, vCount, station);
        }
    }
}