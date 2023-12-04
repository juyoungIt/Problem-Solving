// BOJ - 4803
// Problem Sheet - https://www.acmicpc.net/problem/4803

import java.util.*;
import java.io.*;

public class Main {

    private static final String NO_TREES = "No trees.";
    private static final String ONE_TREES = "There is one tree.";
    private static final String MANY_TREES = "A forest of %d trees.";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int caseCnt = 0;
        while(true) {
            caseCnt++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer>[] al = new List[n + 1];
            for(int i=1 ; i<=n ; i++) {
                al[i] = new LinkedList<>();
            }

            if(n == 0 && m == 0) break;
            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                al[a].add(b);
                al[b].add(a);
            }

            boolean[] isVisit = new boolean[al.length];
            int treeCnt = countTrees(al, isVisit);
            if(treeCnt == 0) sb.append(String.format("Case %d: %s\n", caseCnt, NO_TREES));
            else if(treeCnt == 1) sb.append(String.format("Case %d: %s\n", caseCnt, ONE_TREES));
            else sb.append(String.format("Case %d: %s\n", caseCnt, String.format(MANY_TREES, treeCnt)));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int countTrees(List<Integer>[] al, boolean[] isVisit) {
        int treeCnt = 0;
        for(int i=1 ; i<al.length ; i++) {
            if(!isVisit[i] && isTree(al, i, isVisit)) {
                treeCnt++;
            }
        }
        return treeCnt;
    }

    private static boolean isTree(List<Integer>[] al, int rootIdx, boolean[] isVisit) {
        Queue<Integer> queue = new LinkedList<>();

        int nodeCnt = 0;
        int edgeCnt = 0;
        queue.add(rootIdx);
        while(!queue.isEmpty()) {
            int curIdx = queue.poll();
            if(isVisit[curIdx]) continue;
            isVisit[curIdx] = true;
            nodeCnt++;
            for(int node : al[curIdx]) {
                edgeCnt++;
                if(!isVisit[node]) {
                    queue.add(node);
                }
            }
        }

        return nodeCnt - (edgeCnt / 2) == 1;
    }
}