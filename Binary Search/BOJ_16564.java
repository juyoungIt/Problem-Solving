// BOJ - 16564
// Problem Sheet - https://www.acmicpc.net/problem/16564

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] levels = new int[n];
        for (int i=0 ; i<n ; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = 1_000_000_001;
        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isAvailable(levels, k, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }

    private static boolean isAvailable(int[] levels, int k, int candidate) {
        boolean result = true;
        for (int level : levels) {
            if (candidate - level > 0) {
                k -= (candidate - level);
            }
            if (k < 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}