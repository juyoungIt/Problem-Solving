// BOJ - 2012
// Problem Sheet - https://www.acmicpc.net/problem/2012

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // 학생 수
        int[] rank = new int[n]; // 각 학생들의 예상 등수
        for(int i=0 ; i<n ; i++)
            rank[i] = key.nextInt();
        long answer = 0;

        // 예상 등수를 크기 순으로 정렬
        Arrays.sort(rank);

        // 불만도의 값을 계산
        for(int i=0 ; i<n ; i++)
            answer += Math.abs(rank[i] - (i+1));

        System.out.println(answer);

        key.close();
        System.exit(0);
    }
}