// BOJ - 5567
// Problem Sheet - https://www.acmicpc.net/problem/5567

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int inviteCount = 0;

        int n = Integer.parseInt(bf.readLine());
        boolean[] visit = new boolean[n+1];
        List<Integer>[] al = new LinkedList[n+1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        int m = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            al[node1].add(node2);
            al[node2].add(node1);
        }

        for(int node : al[1]) {
            queue.add(node);
            inviteCount++;
            visit[node] = true;
        }

        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            for(int node : al[curNode]) {
                if(!visit[node]) {
                    inviteCount++;
                    visit[node] = true;
                }
            }
        }

        if(visit[1]) {
            inviteCount--;
        }

        System.out.println(inviteCount);

        bf.close();
        System.exit(0);
    }
}