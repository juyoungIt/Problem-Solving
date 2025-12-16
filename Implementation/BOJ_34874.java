// BOJ - 34874
// Problem Sheet - https://www.acmicpc.net/problem/34874

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] reviews = new int[n][m];
        int[] maxScores = new int[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<m ; j++) {
                reviews[i][j] = Integer.parseInt(st.nextToken());
                maxScores[i] = Math.max(maxScores[i], reviews[i][j]);
            }
        }
        br.close();
        int[] answer = new int[m];
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (reviews[j][i] < maxScores[j]) {
                    answer[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<m ; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
