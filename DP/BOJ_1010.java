// BOJ - 1010
// Problem Sheet - https://www.acmicpc.net/problem/1010

import java.util.*;
import java.io.*;

public class Main {
    private static long[][] comb; // 각 수마다의 factorial 값을 저장
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        comb = new long[30][30]; // for dp

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        for(int i=0 ; i<tcSize ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(combination(m, n));
        }

        bf.close();
        System.exit(0);
    }

    static long combination(int n, int r) {
        if(n == r || r == 0) return comb[n][r] = 1;
        if(comb[n][r] > 0) return comb[n][r];
        else return comb[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}