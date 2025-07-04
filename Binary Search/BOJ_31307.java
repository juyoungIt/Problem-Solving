// BOJ - 31307
// Problem Sheet - https://www.acmicpc.net/problem/31307

import java.util.*;
import java.io.*;

public class Main {

    private static int n, l;
    private static int[] accLines;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        l = Integer.parseInt(row[1]);
        int[] lines = new int[n];
        for (int i=0 ; i<n ; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines);
        accLines = new int[n + 1];
        for (int i=1 ; i<=n ; i++) {
            accLines[i] = accLines[i - 1] + lines[i - 1];
        }
        br.close();
    }

    private static int solve() {
        int limit = l * 5;
        int start = 0, end = n;
        int targetIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (accLines[mid] <= limit) {
                targetIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return targetIndex;
    }

}
