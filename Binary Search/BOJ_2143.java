// BOJ - 2143
// Problem Sheet - https://www.acmicpc.net/problem/2143

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] accA = getPrefixSumArray(br, n);
        int m = Integer.parseInt(br.readLine());
        int[] accB = getPrefixSumArray(br, m);

        int[] allSumsA = getAllSumsArray(accA, n);
        int[] allSumsB = getAllSumsArray(accB, m);
        Arrays.sort(allSumsB);

        long validCount = 0;
        for (int sum : allSumsA) {
            validCount += (long) getUpperBoundIndex(allSumsB, t - sum)
                    - getLowerBoundIndex(allSumsB, t - sum);
        }

        System.out.println(validCount);

        br.close();
        System.exit(0);
    }

    private static int[] getPrefixSumArray(BufferedReader br, int size) throws IOException {
        int[] prefixSumArray = new int[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=size ; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + Integer.parseInt(st.nextToken());
        }
        return prefixSumArray;
    }

    private static int[] getAllSumsArray(int[] accSum, int size) {
        int[] allSums = new int[size * (size+1) / 2];
        int combCount = 0;
        for (int i=0 ; i<size ; i++) {
            for (int j=i+1 ; j<=size ; j++) {
                allSums[combCount++] = accSum[j] - accSum[i];
            }
        }
        return allSums;
    }

    private static int getLowerBoundIndex(int[] source, int target) {
        int start = 0;
        int end = source.length-1;
        int lowerBoundIndex = source.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (source[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }

    private static int getUpperBoundIndex(int[] source, int target) {
        int start = 0;
        int end = source.length-1;
        int upperBoundIndex = source.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (source[mid] > target) {
                upperBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return upperBoundIndex;
    }
}