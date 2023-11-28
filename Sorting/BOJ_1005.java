// BOJ - 1005
// Problem Sheet - https://www.acmicpc.net/problem/1005

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] buildTime = new int[n + 1];
            int[] totalBuildTime = new int[n + 1];
            int[] prevBuildCnt = new int[n + 1];
            List<List<Integer>> al = new ArrayList<>(n);
            for(int j=0 ; j<n ; j++) {
                al.add(new LinkedList<>());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                buildTime[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0 ; j<k ; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                al.get(x-1).add(y);
                prevBuildCnt[y]++;
            }

            Queue<Integer> waiting = new LinkedList<>();
            for(int j=1 ; j<=n ; j++) {
                if(prevBuildCnt[j] == 0) {
                    waiting.add(j);
                    totalBuildTime[j] = buildTime[j];
                }
            }

            while(!waiting.isEmpty()) {
                int cur = waiting.poll();
                for(int b : al.get(cur-1)) {
                    totalBuildTime[b] = Math.max(totalBuildTime[b], buildTime[b] + totalBuildTime[cur]);
                    prevBuildCnt[b]--;
                    if(prevBuildCnt[b] == 0) {
                        waiting.add(b);
                    }
                }
            }

            int target = Integer.parseInt(br.readLine());
            sb.append(totalBuildTime[target]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}