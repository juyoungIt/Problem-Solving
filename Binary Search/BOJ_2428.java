// BOJ - 2428
// Problem Sheet - https://www.acmicpc.net/problem/2428

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] solutionFileSizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(solutionFileSizes);

        long pairCount = 0;
        for (int i=0 ; i<n-1 ; i++) {
            pairCount += getTargetCount(solutionFileSizes, i + 1, solutionFileSizes[i]);
        }
        System.out.println(pairCount);

        br.close();
        System.exit(0);
    }

    private static long getTargetCount(int[] solutions, int start, int targetSize) {
        int targetIndex = -1;
        int startBackup = start;
        int end = solutions.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (requiredCheck(targetSize, solutions[mid])) {
                targetIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return targetIndex >= 0 ? targetIndex - startBackup + 1 : 0;
    }

    private static boolean requiredCheck(int sizeA, int sizeB) {
        return sizeA >= 0.9 * sizeB;
    }
}