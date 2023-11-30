// BOJ - 2056
// Problem Sheet - https://www.acmicpc.net/problem/2056

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] wt = new int[n + 1];
        int[] accWt = new int[n + 1];
        int[] prevWorkCnts = new int[n + 1];
        List<Integer>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            wt[i] = Integer.parseInt(st.nextToken());
            int prevWorkCnt = Integer.parseInt(st.nextToken());
            prevWorkCnts[i] = prevWorkCnt;
            for(int j=0 ; j<prevWorkCnt ; j++) {
                int prevWork = Integer.parseInt(st.nextToken());
                al[prevWork].add(i);
            }
        }

        Queue<Integer> waiting = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(prevWorkCnts[i] == 0) {
                waiting.add(i);
                accWt[i] = wt[i];
            }
        }

        while(!waiting.isEmpty()) {
            int workNumber = waiting.poll();
            for(int nextWork : al[workNumber]) {
                if(accWt[nextWork] < accWt[workNumber] + wt[nextWork]) {
                    accWt[nextWork] = accWt[workNumber] + wt[nextWork];
                }
                prevWorkCnts[nextWork]--;
                if(prevWorkCnts[nextWork] == 0) {
                    waiting.add(nextWork);
                }
            }
        }

        System.out.println(Arrays.stream(accWt).max().getAsInt());

        br.close();
        System.exit(0);
    }
}