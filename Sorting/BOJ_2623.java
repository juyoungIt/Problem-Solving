// BOJ - 2623
// Problem Sheet - https://www.acmicpc.net/problem/2623

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        int[] prevCnt = new int[n + 1];
        for(int i=0 ; i<m ; i++) {
            int[] seqInfo = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 1; j < seqInfo.length - 1; j++) {
                al[seqInfo[j]].add(seqInfo[j + 1]);
                prevCnt[seqInfo[j + 1]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(prevCnt[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int cv = queue.poll();
            sb.append(cv).append("\n");
            for(int v : al[cv]) {
                prevCnt[v]--;
                if(prevCnt[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if(sb.toString().split("\n").length != n) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }

        br.close();
        System.exit(0);
    }
}