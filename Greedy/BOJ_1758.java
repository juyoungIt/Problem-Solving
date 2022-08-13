// BOJ - 1785
// Problem Sheet - https://www.acmicpc.net/problem/1785

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();   // 사람의 수
        Integer[] tips = new Integer[n]; // 팁
        for(int i=0 ; i<n ; i++)
            tips[i] = key.nextInt();
        long answer = 0; // 강호가 받게될 팁

        // 팁의 값을 내림차순 정렬
        Arrays.sort(tips, Collections.reverseOrder());

        // 강호가 받게될 팁의 액수를 계산
        for(int i=1 ; i<=n ; i++)
            answer += Math.max(tips[i-1] - i + 1, 0);

        System.out.println(answer);

        key.close();
        System.exit(0);
    }
}