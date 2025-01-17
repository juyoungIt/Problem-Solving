// BOJ - 3079
// Problem Sheet - https://www.acmicpc.net/problem/3079

import java.io.*;

public class Main {

    private static int N, M;
    private static int[] T;
    private static int maxT = 0;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        T = new int[N];
        for (int i=0 ; i<N ; i++) {
            T[i] = Integer.parseInt(br.readLine());
            maxT = Math.max(maxT, T[i]);
        }
        br.close();
    }

    private static long solve() {
        long start = 0, end = (long) maxT * M;
        long minTime = end;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (isAvailable(mid)) {
                minTime = Math.min(minTime, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minTime;
    }

    private static boolean isAvailable(long time) {
        long count = 0;
        for (int t : T) {
            count += time / t;
            if (count >= M) return true;
        }
        return false;
    }
}