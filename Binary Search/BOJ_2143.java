// BOJ - 2143
// Problem Sheet - https://www.acmicpc.net/problem/2143

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<m ; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int[] accA = new int[(n + 1) * n / 2];
        int[] accB = new int[(m + 1) * m / 2];
        buildAllPrefixSum(arrA, accA, n);
        buildAllPrefixSum(arrB, accB, m);
        Arrays.sort(accA);

        long combinationCount = 0;
        for (int acc : accB) {
            int upperBoundIndex = getUpperBoundIndex(accA, T - acc);
            int lowerBoundIndex = getLowerBoundIndex(accA, T - acc);
            if (lowerBoundIndex >= 0 && upperBoundIndex >= 0) {
                combinationCount += upperBoundIndex - lowerBoundIndex + 1;
            }
        }

        System.out.println(combinationCount);

        bf.close();
        System.exit(0);
    }

    private static void buildAllPrefixSum(int[] arr, int[] acc, int arrSize) {
        int curIndex = 0;
        for(int i=0 ; i<arrSize ; i++) {
            int sum = arr[i];
            acc[curIndex++] = sum;
            for(int j=i+1 ; j<arrSize ; j++) {
                sum += arr[j];
                acc[curIndex++] = sum;
            }
        }
    }

    private static int getLowerBoundIndex(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        int middleIndex;
        int lowerBoundIndex = -1;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if(arr[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                lowerBoundIndex = middleIndex;
                rightIndex = middleIndex - 1;
            }
        }
        return lowerBoundIndex;
    }

    private static int getUpperBoundIndex(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        int middleIndex;
        int upperBoundIndex = -1;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if(arr[middleIndex] <= target) {
                upperBoundIndex = middleIndex;
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return upperBoundIndex;
    }
}