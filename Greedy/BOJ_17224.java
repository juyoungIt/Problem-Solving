// BOJ - 17224
// Problem Sheet - https://www.acmicpc.net/problem/17224

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int l = Integer.parseInt(st.nextToken()); // 역량
        int k = Integer.parseInt(st.nextToken()); // 최대로 풀 수 있는 문제 수
        int solved = 0; // 풀이한 문제 수
        int[][] problems = new int[n][2]; // 풀이할 문제의 서브테스트 난이도 정보
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = 0; // 정답을 저장

        // 입력받은 2차원 배열을 정렬 - 고난도 서브테스크 기준
        Arrays.sort(problems, (o1, o2) -> {
            return o1[1]-o2[1];
        });

        for(int i=0 ; i<n ; i++) {
            if(solved >= k)
                break;
            if(problems[i][0] > l)
                continue;
            answer += (problems[i][1] <= l) ? 140 : 100;
            solved++;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}