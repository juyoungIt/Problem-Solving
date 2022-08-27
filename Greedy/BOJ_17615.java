// BOJ - 17615
// Problem Sheet - https://www.acmicpc.net/problem/17615

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 공의 개수
        String ballSeq = bf.readLine(); // 공의 배치 순서를 나타내는 문자열
        boolean[] countStart = new boolean[4]; // 카운트를 시작하면 되는 가를 의미
        int[] caseCount = new int[4];          // 각 경우의 수에 대한 카운트 결과

        for(int i=0 ; i<n ; i++) {
            // 빨간색을 왼쪽에 모으는 경우
            if(!countStart[0] && ballSeq.charAt(i) == 'B')
                countStart[0] = true;
            if(countStart[0] && ballSeq.charAt(i) == 'R')
                caseCount[0]++;
            // 파란색을 왼쪽에 모으는 경우
            if(!countStart[1] && ballSeq.charAt(i) == 'R')
                countStart[1] = true;
            if(countStart[1] && ballSeq.charAt(i) == 'B')
                caseCount[1]++;
            // 빨간색을 오른쪽에 모으는 경우
            if(!countStart[2] && ballSeq.charAt(n-1-i) == 'B')
                countStart[2] = true;
            if(countStart[2] && ballSeq.charAt(n-1-i) == 'R')
                caseCount[2]++;
            // 파란색을 오른쪽에 모으는 경우
            if(!countStart[3] && ballSeq.charAt(n-1-i) == 'R')
                countStart[3] = true;
            if(countStart[3] && ballSeq.charAt(n-1-i) == 'B')
                caseCount[3]++;
        }

        Arrays.sort(caseCount);
        System.out.println(caseCount[0]);

        bf.close();
        System.exit(0);
    }
}