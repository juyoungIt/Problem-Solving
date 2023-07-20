// BOJ - 10986
// Problem Sheet - https://www.acmicpc.net/problem/10986

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[N+1];
        long[] accArr = new long[N+1];
        int[] remainderCounts = new int[M];
        long answer = 0;
        for(int i=1 ; i<=N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            accArr[i] = accArr[i-1] + arr[i];
            int remainder = (int)(accArr[i] % M);
            remainderCounts[remainder]++;
            if(remainder == 0) {
                answer++;
            }
        }

        for(int i=0 ; i<M ; i++) {
            answer += getCombinationValue(remainderCounts[i]);
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    private static long getCombinationValue(int n) {
        return ((long)n * (n-1)) / 2;
    }
}