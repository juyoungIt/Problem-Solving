// BOJ - 1260
// Problem Sheet - https://www.acmicpc.net/problem/1260

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<Integer>[] al = new LinkedList[n+1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            al[b].add(a);
        }
        for(int i=1 ; i<=n ; i++) {
            Collections.sort(al[i]);
        }

        dfs(al, v, sb);
        sb.append("\n");
        bfs(al, v, sb);

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static void dfs(List<Integer>[] al, int start, StringBuilder sb) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisit = new boolean[al.length];

        stack.push(start);
        isVisit[start] = true;
        sb.append(start).append(" ");
        while(!stack.isEmpty()) {
            int top = stack.peek();
            int curIdx;
            for(curIdx=0 ; curIdx<al[top].size() ; curIdx++) {
                if(!isVisit[al[top].get(curIdx)]) {
                    stack.push(al[top].get(curIdx));
                    isVisit[al[top].get(curIdx)] = true;
                    sb.append(al[top].get(curIdx)).append(" ");
                    break;
                }
            }
            if(curIdx >= al[top].size()) {
                stack.pop();
            }
        }
    }

    private static void bfs(List<Integer>[] al, int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[al.length];

        queue.add(start);
        isVisit[start] = true;
        sb.append(start).append(" ");
        while(!queue.isEmpty()) {
            int front = queue.peek();
            for(int adj : al[front]) {
                if(!isVisit[adj]) {
                    queue.add(adj);
                    isVisit[adj] = true;
                    sb.append(adj).append(" ");
                }
            }
            queue.poll();
        }
    }
}