// BOJ - 11501
// Problem Sheet - https://www.acmicpc.net/problem/11501

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        long[] answers = new long[tcSize]; // 산출된 정답들을 저장

        // 각각의 테스트 케이스에 대하여 다음을 반복
        for(int i=0 ; i<tcSize ; i++) {
            int day = Integer.parseInt(bf.readLine());
            int[] stockPrice = new int[day];
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<day ; j++)
                stockPrice[j] = Integer.parseInt(st.nextToken());

            int curIdx = 0;
            while(curIdx < stockPrice.length) {
                int maxIdx = findMaxDays(stockPrice, curIdx, stockPrice.length-1);
                for(int j=curIdx ; j<=maxIdx ; j++)
                    answers[i] += stockPrice[maxIdx] - stockPrice[j];
                curIdx = maxIdx+1;
            }
        }

        // 구한 정답들을 순차적으로 출력
        for(long answer : answers)
            System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    // 주어진 범위에서 주가가 최고가가 되는 지점을 찾음
    public static int findMaxDays(int[] prices, int start, int end) {
        int max = 0, maxIdx = start;
        for(int i=start ; i<=end ; i++) {
            if(max <= prices[i]) {
                max = prices[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}