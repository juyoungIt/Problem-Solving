// BOJ - 10816
// Problem Sheet - https://www.acmicpc.net/problem/10816

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int numberOfElements = Integer.parseInt(bf.readLine());
        int[] elements = new int[numberOfElements];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfElements ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);

        int numberOfSearches = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfSearches ; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(getUpperBoundIndex(elements, target) - getLowerBoundIndex(elements, target)).append(" ");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getLowerBoundIndex(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        int middleIndex;
        int lowerBoundIndex = arr.length;
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
        int upperBoundIndex = arr.length;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if(arr[middleIndex] <= target) {
                leftIndex = middleIndex + 1;
            } else {
                upperBoundIndex = middleIndex;
                rightIndex = middleIndex - 1;
            }
        }
        return upperBoundIndex;
    }
}