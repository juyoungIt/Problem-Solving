// BOJ - 10103
// Problem Sheet - https://www.acmicpc.net/problem/10103

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] score = new int[2];
        Arrays.fill(score, 100);
        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int scoreA = Integer.parseInt(st.nextToken());
            int scoreB = Integer.parseInt(st.nextToken());
            if(scoreA > scoreB) {
                score[1] -= scoreA;
            } else if(scoreA < scoreB) {
                score[0] -= scoreB;
            }
        }

        System.out.println(score[0]);
        System.out.println(score[1]);

        bf.close();
        System.exit(0);
    }
}