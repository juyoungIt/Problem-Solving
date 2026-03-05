// BOJ - 34068
// Problem Sheet - https://www.acmicpc.net/problem/34068

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            score[a - 1]++;
        }
        Arrays.sort(score);
        int minScore = 0;
        long answer = 0;
        for (int i=0 ; i<n ; i++) {
            answer += Math.max(0, minScore - score[i]);
            minScore = Math.max(minScore + 1, score[i] + 1);
        }
        System.out.println(answer);
        br.close();
    }
}
