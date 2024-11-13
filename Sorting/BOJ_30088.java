// BOJ - 30088
// Problem Sheet - https://www.acmicpc.net/problem/30088

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] meetingTimes = new long[N];
        for (int i=0 ; i<N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j=1 ; j<=input[0] ; j++) {
                meetingTimes[i] += input[j];
            }
        }
        Arrays.sort(meetingTimes);

        long totalTime = 0;
        for (int i=0 ; i<N-1 ; i++) {
            meetingTimes[i + 1] += meetingTimes[i];
        }
        for (long meetingTime : meetingTimes) {
            totalTime += meetingTime;
        }

        System.out.println(totalTime);
        br.close();
    }
}