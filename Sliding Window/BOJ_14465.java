// BOJ - 14465
// Problem Sheet - https://www.acmicpc.net/problem/14465

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] lights = new boolean[N];
        int curBrokenCount = 0;
        for (int i=0 ; i<B ; i++) {
            int location = Integer.parseInt(br.readLine());
            lights[location - 1] = true;
            if (location <= K) {
                curBrokenCount++;
            }
        }

        int minBrokenCount = N;
        for (int i=0 ; i<=N-K ; i++) {
            minBrokenCount = Math.min(curBrokenCount, minBrokenCount);
            if (i + K >= N) break;
            curBrokenCount -= (lights[i]) ? 1 : 0;
            curBrokenCount += (lights[i + K]) ? 1 : 0;
        }
        System.out.println(minBrokenCount);

        br.close();
    }
}