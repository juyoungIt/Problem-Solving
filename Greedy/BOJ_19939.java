// BOJ - 19939
// Problem Sheet - https://www.acmicpc.net/problem/1417

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 공의 갯수
        int k = Integer.parseInt(st.nextToken()); // 바구니의 갯수
        int assigned = 0; // 현재까지 할당한 공의 수
        int answer = -1;
        boolean isFailed = false;
        int min, max;

        // 1. 계단식으로 공을 먼저 분배함
        for(int i=1 ; i<=k ; i++) {
            if(assigned + i > n) {
                isFailed = true;
                break;
            }
            assigned += i;
        }

        if(isFailed)
            System.out.println(answer);
        else {
            min = 1;
            max = k;
            if((n - assigned) % k != 0)
                max++;
            answer = max - min;
            System.out.println(answer);
        }

        bf.close();
        System.exit(0);
    }
}