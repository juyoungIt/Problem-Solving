// BOJ - 1263
// Problem Sheet - https://www.acmicpc.net/problem/1263

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] tasks = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[1]));
        for (int i=1 ; i<n ; i++) {
            tasks[i][0] += tasks[i - 1][0];
        }
        int minDiff = 1_000_000;
        for (int i=0 ; i<n ; i++) {
            minDiff = Math.min(minDiff, tasks[i][1] - tasks[i][0]);
        }
        System.out.println(minDiff < 0 ? -1 : minDiff);
        br.close();
    }
}