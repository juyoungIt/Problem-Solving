// BOJ - 9785
// Problem Sheet - https://www.acmicpc.net/problem/9785

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] skills = new int[N][2];
        int availableTime = 0;
        for (int i=0 ; i<N; i++) {
            input = br.readLine().split(" ");
            skills[i][0] = Integer.parseInt(input[0]);
            skills[i][1] = Integer.parseInt(input[1]);
            availableTime = Math.max(availableTime, skills[i][1]);
        }
        Arrays.sort(skills, (s1, s2) -> {
            if (s1[0] == s2[0]) return s2[1] - s1[1];
            return s2[0] - s1[0];
        });

        int totalDamage = 0;
        for (int i=0 ; i<M ; i++) {
            totalDamage += skills[i][0];
            availableTime = Math.min(availableTime, skills[i][1]);
        }

        System.out.printf("%d %d", totalDamage, availableTime);
        br.close();
    }
}