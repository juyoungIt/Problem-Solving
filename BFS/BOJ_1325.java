// BOJ - 1325
// Problem Sheet - https://www.acmicpc.net/problem/1325

import java.util.*;
import java.io.*;

public class Main {
    static int n; // 컴퓨터의 수
    static int m; // 신뢰관계의 수
    static ArrayList<Integer>[] al; // adjacency list
    static Queue<Integer> queue = new LinkedList<>(); // bfs를 수행하는 데 필요한 queue
    static int[] hackedCount;
    static boolean[] visit;  // 방문정보 저장
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hackedCount = new int[n+1];
        al = new ArrayList[n+1];
        for(int i=1 ; i<=n ; i++)
            al[i] = new ArrayList<>();
        int maxHacked = -1; // 해킹가능한 컴퓨터 수의 최댓값

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            al[idx2].add(idx1);
        }

        for(int i=1 ; i<=n ; i++) {
            visit = new boolean[n+1];
            bfs(i);
            maxHacked = Math.max(maxHacked, hackedCount[i]);
        }

        for(int i=1 ; i<=n ; i++)
            if(hackedCount[i] == maxHacked)
                sb.append(i).append(" ");
        bw.write(sb.toString());

        bf.close();
        bw.flush();
        bw.close();
        System.exit(0);
    }

    public static void bfs(int s) {
        visit[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int tmp = queue.peek();
            for(int com : al[tmp]) {
                if(!visit[com]) {
                    visit[com] = true;
                    queue.add(com);
                    hackedCount[s]++;
                }
            }
            queue.poll();
        }
    }
}