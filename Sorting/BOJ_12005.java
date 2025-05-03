// BOJ - 12005
// Problem Sheet - https://www.acmicpc.net/problem/12005

import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static int[] diamond;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        k = Integer.parseInt(row[1]);
        diamond = new int[n];
        for (int i=0 ; i<n ; i++) {
            diamond[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(diamond);
        br.close();
    }

    private static int solve() {
        int left = 0, right = 0;
        int maxCnt = 0;
        while (right < n) {
            if (diamond[right] - diamond[left] <= k) {
                maxCnt = Math.max(maxCnt, right - left);
                right++;
            } else {
                left++;
                if (left > right) right = left;
            }
        }
        return maxCnt + 1;
    }

}