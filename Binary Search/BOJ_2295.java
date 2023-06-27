// BOJ - 2295
// Problem Sheet - https://www.acmicpc.net/problem/2295

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfElements = Integer.parseInt(bf.readLine());
        int[] elements = new int[numberOfElements];
        for(int i=0 ; i<numberOfElements ; i++) {
            elements[i] = Integer.parseInt(bf.readLine());
        }

        int[] pairSums = new int[numberOfElements * (numberOfElements-1) / 2 + numberOfElements];
        int pairSumCount = 0;
        for(int i=0 ; i<numberOfElements ; i++) {
            for(int j=i ; j<numberOfElements ; j++) {
                pairSums[pairSumCount++] = elements[i] + elements[j];
            }
        }
        Arrays.sort(pairSums);

        int result = -1;
        for(int i=0 ; i<numberOfElements ; i++) {
            for(int j=0 ; j<numberOfElements ; j++) {
                if(isExist(pairSums, elements[i] - elements[j])) {
                    result = Math.max(result, elements[i]);
                }
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }

    private static boolean isExist(int[] elements, int target) {
        int leftIndex = 0;
        int rightIndex = elements.length-1;
        int middleIndex;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if(elements[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else if(elements[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}