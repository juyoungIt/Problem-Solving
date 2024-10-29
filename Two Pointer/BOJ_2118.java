// BOJ - 2118
// Problem Sheet - https://www.acmicpc.net/problem/2118

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] acc = new int[N + 1];
        for (int i=1 ; i<=N ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(br.readLine());
        }

        int left = 0, right = 1;
        int maxDist = 0;
        while (left <= right && right <= N) {
            int clockwiseDist = acc[right] - acc[left];
            int counterClockwiseDist = acc[N] - clockwiseDist;
            int dist = Math.min(clockwiseDist, counterClockwiseDist);
            maxDist = Math.max(dist, maxDist);
            if (clockwiseDist <= counterClockwiseDist) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(maxDist);
        br.close();
    }
}