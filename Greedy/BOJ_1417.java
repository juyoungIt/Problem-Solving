// BOJ - 1417
// Problem Sheet - https://www.acmicpc.net/problem/1417

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt(); // 후보의 수
        int[] vote = new int[n-1]; // 1후보를 제외한 나머지 후보의 득표 수
        int cur = key.nextInt(); // 1번 후보의 득표 수
        for(int i=0 ; i<n-1 ; i++)
            vote[i] = key.nextInt();
        int answer = 0;

        while(true) {
            if(vote.length == 0)
                break;
            Arrays.sort(vote); // 나머지 후보의 득표 수를 크기 순으로 정렬
            if(vote[n-2] < cur)
                break;
            vote[n-2]--;
            cur++;
            answer++;
        }

        System.out.println(answer);

        key.close();
        System.exit(0);
    }
}