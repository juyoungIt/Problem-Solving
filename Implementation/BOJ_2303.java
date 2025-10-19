// BOJ - 2303
// Problem Sheet - https://www.acmicpc.net/problem/2303

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n + 1][5];
        for (int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<5 ; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = -1;
        int winner = 0;
        for (int i=1 ; i<=n ; i++) {
            int score = getMaxScore(cards[i]);
            if (score >= maxScore) {
                maxScore = score;
                winner = i;
            }
        }

        System.out.println(winner);
        br.close();
    }

    private static int getMaxScore(int[] card) {
        int maxScore = 0;
        for (int i=0 ; i<3 ; i++) {
            for (int j=i+1 ; j<4 ; j++) {
                for (int k=j+1 ; k<5 ; k++) {
                    int score = (card[i] + card[j] + card[k]) % 10;
                    maxScore = Math.max(maxScore, score);
                }
            }
        }
        return maxScore;
    }
}
