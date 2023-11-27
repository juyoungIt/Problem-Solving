// BOJ - 1068
// Problem Sheet - https://www.acmicpc.net/problem/1068

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isRemoved = new boolean[n];
        List<List<Integer>> al = new ArrayList<>(n);
        for(int i=0 ; i<n ; i++) {
            al.add(new LinkedList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) {
                continue;
            }
            al.get(p).add(i);
        }

        int r = Integer.parseInt(br.readLine());
        remove(al, isRemoved, r);

        int leafNodeCnt = 0;
        for(int i=0 ; i<n ; i++) {
            if(!isRemoved[i] && al.get(i).isEmpty()) {
                leafNodeCnt++;
            }
        }

        System.out.println(leafNodeCnt);

        br.close();
        System.exit(0);
    }

    private static void remove(List<List<Integer>> al, boolean[] isRemoved, int r) {
        isRemoved[r] = true;
        for(List<Integer> nodes : al) {
            nodes.remove(Integer.valueOf(r));
            for(int node : al.get(r)) {
                remove(al, isRemoved, node);
            }
        }
        al.get(r).clear();
    }
}