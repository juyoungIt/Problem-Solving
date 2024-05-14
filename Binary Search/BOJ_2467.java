// BOJ - 2467
// Problem Sheet - https://www.acmicpc.net/problem/2467

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] solutions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minDiff = 2_000_000_001;
        int optLeft = 0;
        int optRight = n - 1;
        for (int i=0 ; i<n ; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int diff = solutions[mid] + solutions[i];
                if (minDiff > Math.abs(diff)) {
                    optLeft = i;
                    optRight = mid;
                    minDiff = Math.abs(diff);
                }
                if (diff < 0) left = mid + 1;
                else right = mid - 1;
            }
        }

        System.out.printf("%d %d\n", solutions[optLeft], solutions[optRight]);

        br.close();
        System.exit(0);
    }
}