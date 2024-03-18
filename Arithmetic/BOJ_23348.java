// BOJ - 23348
// Problem Sheet - https://www.acmicpc.net/problem/23348

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] baseScore = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(br.readLine());
        int maxScore = 0;
        for (int i=0 ; i<n ; i++) {
            int totalScore = 0;
            for (int j=0 ; j<3 ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0 ; k<3 ; k++) {
                    totalScore += baseScore[k] * Integer.parseInt(st.nextToken());
                }
            }
            if (maxScore < totalScore) {
                maxScore = totalScore;
            }
        }

        System.out.println(maxScore);

        br.close();
        System.exit(0);
    }
}