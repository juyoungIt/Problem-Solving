// BOJ - 1300
// Problem Sheet - https://www.acmicpc.net/problem/1300

import java.io.*;

public class Main {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        br.close();
    }

    private static long solve() {
        long start = 1, end = K;
        long optValue = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = getLowerBoundCount(mid);
            if (count >= K) {
                optValue = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return optValue;
    }

    private static long getLowerBoundCount(long candidate) {
        long lowerBoundCount = 0;
        for (int i=1 ; i<=N ; i++) {
            lowerBoundCount += Math.min(candidate / i, N);
        }
        return lowerBoundCount;
    }
}