// BOJ - 19637
// Problem Sheet - https://www.acmicpc.net/problem/19637

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] rangeNames = new String[n];
        int[] thresholds = new int[n];
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            rangeNames[i] = st.nextToken();
            thresholds[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0 ; i<m ; i++) {
            int combatPower = Integer.parseInt(br.readLine());
            int targetRangeIndex = getLowerBoundIndex(thresholds, combatPower);
            sb.append(rangeNames[targetRangeIndex]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(int[] thresholds, int target) {
        int start = 0;
        int end = thresholds.length - 1;
        int lowerBoundIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (thresholds[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }
}