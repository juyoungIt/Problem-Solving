// BOJ - 1083
// Problem Sheet - https://www.acmicpc.net/problem/1083

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 동작에 필요한 값들을 입력받는 부분
        int n = Integer.parseInt(bf.readLine()); // 배열 요소의 수
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(bf.readLine()); // swap 할 수 있는 횟수
        int lastIdx = 0; // 마지막으로 값의 배치가 이뤄진 배열의 index

        while(s > 0 && lastIdx < n-1) {
            int maxVal = 0, maxIdx = 0; // 현재 범위에서 최댓값의 인덱스
            for(int i=lastIdx ; i<=getMaxRange(s, n, lastIdx) ; i++) {
                if(maxVal < arr[i]) {
                    maxVal = arr[i];
                    maxIdx = i;
                }
            }

            for(int i=maxIdx ; i>lastIdx ; i--) {
                int tmp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = tmp;
                s--;
            }
            lastIdx++;
        }

        for(int i=0 ; i<n ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        bf.close();
        System.exit(0);
    }

    static int getMaxRange(int s, int n, int lastIdx) {
        return Math.min(lastIdx + s, n-1);
    }
}