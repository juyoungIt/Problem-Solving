// BOJ - 2748
// Problem Sheet - https://www.acmicpc.net/problem/2748

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 원하는 차수
        long[] fSequence = new long[n+1]; // 피보나치 수의 수열을 저장함
        fSequence[0] = 0; // 기본 정의값 주입
        fSequence[1] = 1; // 기본 정의값 주입

        for(int i=2 ; i<=n ; i++)
            fSequence[i] = fSequence[i-2] + fSequence[i-1];

        System.out.println(fSequence[n]);

        bf.close();
        System.exit(0);
    }
}