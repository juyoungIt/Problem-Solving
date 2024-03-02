// BOJ - 25600
// Problem Sheet - https://www.acmicpc.net/problem/25600

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int maxScore = 0;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int totalScore = getTotalScore(a, d, g);
            if(maxScore < totalScore) {
                maxScore = totalScore;
            }
        }

        System.out.println(maxScore);

        br.close();
        System.exit(0);
    }

    private static int getTotalScore(int a, int d, int g) {
        int baseScore = a * (d + g);
        if(a == d + g) {
            baseScore *= 2;
        }
        return baseScore;
    }
}