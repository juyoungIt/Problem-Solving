// BOJ - 3079
// Problem Sheet - https://www.acmicpc.net/problem/3079

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        int M = Integer.parseInt(st.nextToken());
        int minTime = Integer.MAX_VALUE;
        for(int i=0 ; i<N ; i++) {
            times[i] = Integer.parseInt(bf.readLine());
            minTime = Math.min(minTime, times[i]);
        }

        long start = 0L;
        long end = (long)minTime * M;
        long middle;
        long answer = end;
        while(start <= end) {
            middle = (start + end) / 2;
            if(getServicedCount(times, middle) >= M) {
                answer = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }

    private static long getServicedCount(int[] times, long totalTime) {
        long servicedCount = 0;
        for(int time : times) {
            servicedCount += totalTime / time;
        }
        return servicedCount;
    }
}