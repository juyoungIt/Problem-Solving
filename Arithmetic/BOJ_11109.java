// BOJ - 11109
// Problem Sheet - https://www.acmicpc.net/problem/11109

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int parallelizeTime = d + n * p;
            int sequentialTime = n * s;
            if (parallelizeTime > sequentialTime) sb.append("do not parallelize");
            else if (parallelizeTime < sequentialTime) sb.append("parallelize");
            else sb.append("does not matter");
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}