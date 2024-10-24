// BOJ - 14471
// Problem Sheet - https://www.acmicpc.net/problem/14471

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] fixMoney = new int[M];
        for (int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            fixMoney[i] = Math.max(0, N - a);
        }
        Arrays.sort(fixMoney);

        int answer = 0;
        for (int i=0 ; i<M-1 ; i++) {
            answer += fixMoney[i];
        }
        System.out.println(answer);

        br.close();
    }
}