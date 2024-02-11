// BOJ - 5533
// Problem Sheet - https://www.acmicpc.net/problem/5533

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] scores = new int[n][3];
        int[] totalScore = new int[n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<3 ; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<3 ; i++) {
            Map<Integer, Integer> scoreCounter = new HashMap<>();
            for(int j=0 ; j<n ; j++) {
                scoreCounter.put(scores[j][i],
                        scoreCounter.getOrDefault(scores[j][i], 0) + 1);
            }
            for(int j=0 ; j<n ; j++) {
                if(scoreCounter.get(scores[j][i]) == 1) {
                    totalScore[j] += scores[j][i];
                }
            }
        }

        for(int score : totalScore) {
            sb.append(score).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}