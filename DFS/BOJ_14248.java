// BOJ - 14248
// Problem Sheet - https://www.acmicpc.net/problem/14248

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 돌다리의 갯수
        int[] stones = new int[n+1]; // 각 돌의 위치에서 점프 가능한 거리
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 점프 가능한 거리
        for(int i=1 ; i<=n ; i++)
            stones[i] = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(bf.readLine()); // 시작하는 위치
        int answer = 0; // 영우가 방문 가능한 돌들의 수

        dfs(stones, start);

        for(int stone : stones)
            if(stone == 0)
                answer++;

        System.out.println(answer-1); // 0인덱스에 들어간 값은 제외시키기 위함

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[] stones, int start) {
        int[] xi = {-1, 1}; // x-increment

        int jDist = stones[start]; // 점프 가능한 거리
        stones[start] = 0;
        for(int i=0 ; i<2 ; i++) {
            int tx = start + xi[i] * jDist;
            if(validation(tx, stones.length-1) && stones[tx] != 0)
                dfs(stones, tx);
        }
    }

    public static boolean validation(int x, int n) {
        return (x>=1 && x<=n);
    }
}