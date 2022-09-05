// BOJ - 1041
// Problem Sheet - https://www.acmicpc.net/problem/1041

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 주사위의 수
        int[] dice = new int[6]; // 주사위의 각 면에 적힌 숫자 (A, B, C, D, E, F) 순서
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int min = 51; // 주사위 눈이 가질 수 있는 최댓값 + 1
        int max = 0;  // 주사위 눈이 가질 수 있는 최솟값 - 1
        int maxIdx = 0; // 최댓값의 인덱스

        // 주사위의 숫자값을 입력받음과 동시에 최대, 최소를 구함
        for(int i=0 ; i<6 ; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            if(dice[i] > max) {
                max = dice[i];
                maxIdx = i;
            }
            if(dice[i] < min)
                min = dice[i];
        }
        long answer = 0; // 각 면에 적힌 숫자의 최솟값

        long twoMinValue = twoMin(dice);     // 2개면 합의 최솟값
        long threeMinValue = threeMin(dice); // 1개면 합의 최솟값

        // n의 값에 따라서 다음과 같이 처리함
        if(n == 1) {
            for(int i=0 ; i<6 ; i++) {
                if(i == maxIdx) continue;
                answer += dice[i];
            }
        }
        else {
            answer += threeMinValue * 4 + twoMinValue * ((n-2)* 4L) + min * (long)Math.pow(n-2, 2); // 가장 위층
            answer += (twoMinValue * 4 + min * ((n-2)* 4L)) * (n-1); // 나머지 층
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    // 주사위 2개 면이 가질 수 있는 최솟값을 계산하여 반환
    public static long twoMin(int[] dice) {
        int min = 101;
        for(int i=0 ; i<6 ; i++) {
            for(int j=i+1 ; j<6 ; j++) {
                if((i==0 && j==5) || (i==1 && j==4) || (i==2 && j==3))
                    continue;
                if(min > (dice[i] + dice[j]))
                    min = dice[i] + dice[j];
            }
        }
        return min;
    }

    // 주사위 3개 면이 가질 수 있는 최솟값을 계산하여 반환
    public static long threeMin(int[] dice) {
        int min = 151;
        int[][] indexes = {{0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4}, {1, 2, 5}, {1, 3, 5}, {2, 4, 5}, {3, 4, 5}};
        for(int i=0 ; i<8 ; i++) {
            int tmp = dice[indexes[i][0]] + dice[indexes[i][1]] + dice[indexes[i][2]];
            if(min > tmp)
                min = tmp;
        }
        return min;
    }
}