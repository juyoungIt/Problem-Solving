// BOJ - 14233
// Problem Sheet - https://www.acmicpc.net/problem/14233

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] deadlines = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            deadlines[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(deadlines);

        int start = 1;
        int end = deadlines[0];
        int optimizedWorkTime = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValidSchedule(deadlines, mid)) {
                start = mid + 1;
                optimizedWorkTime = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(optimizedWorkTime);

        br.close();
        System.exit(0);
    }

    private static boolean isValidSchedule(int[] deadlines, int workTime) {
        int totalWorkTime = 0;
        for (int deadline : deadlines) {
            totalWorkTime += workTime;
            if (totalWorkTime > deadline) {
                return false;
            }
        }
        return true;
    }
}