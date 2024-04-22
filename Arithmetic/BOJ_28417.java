// BOJ - 28417
// Problem Sheet - https://www.acmicpc.net/problem/28417

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int maxScore = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int score = 0;
            int[] runScore = new int[2];
            int[] trickScore = new int[5];
            for (int j=0 ; j<7 ; j++) {
                if (j <= 1) runScore[j] = Integer.parseInt(st.nextToken());
                else trickScore[j - 2] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(runScore);
            Arrays.sort(trickScore);
            score = runScore[1] + trickScore[3] + trickScore[4];
            if (score > maxScore) {
                maxScore = score;
            }
        }

        System.out.println(maxScore);

        br.close();
        System.exit(0);
    }
}