// BOJ - 17245
// Problem Sheet - https://www.acmicpc.net/problem/17245

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] servers = new int[n][n];
        long totalServerCount = 0;
        for (int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++) {
                servers[i][j] = Integer.parseInt(st.nextToken());
                totalServerCount += servers[i][j];
            }
        }

        int start = 0;
        int end = 10_000_000;
        long threshold = totalServerCount / 2 + ((totalServerCount % 2 == 0) ? 0 : 1);
        int validTime = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            long availableServerCount = getAvailableServerCount(servers, mid);
            if (availableServerCount >= threshold) {
                validTime = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(validTime);

        br.close();
        System.exit(0);
    }

    private static long getAvailableServerCount(int[][] servers, int time) {
        long availableServerCount = 0;
        for (int i=0 ; i<servers.length ; i++) {
            for (int j=0 ; j<servers.length ; j++) {
                availableServerCount += Math.min(time, servers[i][j]);
            }
        }
        return availableServerCount;
    }
}