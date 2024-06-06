// BOJ - 6209
// Problem Sheet - https://www.acmicpc.net/problem/6209

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] distances = new int[n + 2];
        for (int i=1 ; i<=n ; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }
        distances[n+1] = d;
        Arrays.sort(distances);

        int start = 0;
        int end = d;
        int opt = d;
        while (start <= end) {
            int mid = (start + end) / 2;
            int removedCount = getRemovedCount(distances, mid);
            if (removedCount <= m) {
                start = mid + 1;
                opt = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(opt);

        br.close();
        System.exit(0);
    }

    private static int getRemovedCount(int[] distances, int minDistance) {
        int removedCount = 0;
        int curIndex = 0;
        for (int i=1 ; i<distances.length ; i++) {
            if (distances[i] - distances[curIndex] < minDistance) {
                removedCount++;
            } else {
                curIndex = i;
            }
        }
        return removedCount;
    }
}