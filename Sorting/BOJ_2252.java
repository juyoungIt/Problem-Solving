// BOJ - 2252
// Problem Sheet - https://www.acmicpc.net/problem/2252

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> al = new ArrayList<>(n);
        Queue<Integer> waiting = new LinkedList<>();
        int[] inDegree = new int[n + 1];
        for(int i=0 ; i<n ; i++) {
            al.add(new LinkedList<>());
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al.get(a-1).add(b);
            inDegree[b]++;
        }

        for(int i=1 ; i<=n ; i++) {
            if(inDegree[i] == 0) {
                waiting.add(i);
            }
        }

        while(!waiting.isEmpty()) {
            int cur = waiting.poll();
            sb.append(cur).append(" ");
            for(int v : al.get(cur-1)) {
                inDegree[v]--;
                if(inDegree[v] == 0) waiting.add(v);
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}