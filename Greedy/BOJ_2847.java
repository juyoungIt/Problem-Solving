// BOJ - 2847
// Problem Sheet - https://www.acmicpc.net/problem/2847

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();    // 레벨의 수
        int[] scores = new int[n]; // 각 레벨 점수
        for(int i=0 ; i<n ; i++)
            scores[i] = key.nextInt();
        int answer = 0;

        for(int i=n-1 ; i>0 ; i--) {
            if(scores[i-1] >= scores[i]) {
                answer += scores[i-1] - scores[i] + 1;
                scores[i-1] = scores[i] - 1;
            }
        }

        System.out.println(answer);

        key.close();
        System.exit(0);
    }
}