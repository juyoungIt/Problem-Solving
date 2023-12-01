// BOJ - 9470
// Problem Sheet - https://www.acmicpc.net/problem/9470

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            List<Integer>[] al = new List[m + 1];
            int[] seq = new int[m + 1];
            int[] inDegree = new int[m + 1];
            PriorityQueue<Integer>[] prevSequence = new PriorityQueue[m + 1];
            for(int j=1 ; j<=m ; j++) {
                al[j] = new LinkedList<>();
                prevSequence[j] = new PriorityQueue<>(Collections.reverseOrder());
            }

            for(int j=0 ; j<p ; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                al[a].add(b);
                inDegree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int j=1 ; j<=m ; j++) {
                if(inDegree[j] == 0) {
                    queue.add(j);
                    seq[j] = 1;
                }
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int nr : al[cur]) {
                    prevSequence[nr].add(seq[cur]);
                    inDegree[nr]--;
                    if(inDegree[nr] == 0) {
                        queue.add(nr);
                        if(prevSequence[nr].size() > 1) {
                            seq[nr] = prevSequence[nr].poll();
                            if(seq[nr] == prevSequence[nr].poll()) {
                                seq[nr]++;
                            }
                        } else if(prevSequence[nr].size() > 0) {
                            seq[nr] = prevSequence[nr].poll();
                        }
                    }
                }
            }
            sb.append(k).append(" ").append(seq[m]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}