// BOJ - 2470
// Problem Sheet - https://www.acmicpc.net/problem/2470

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfElements = Integer.parseInt(bf.readLine());
        int[] elements = new int[numberOfElements];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfElements ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);

        int minPairDiff = Integer.MAX_VALUE;
        int[] solution = new int[2];
        for(int i=0 ; i<numberOfElements-1 ; i++) {
            int optimalPairValue = findOptimalPairValue(elements, i+1, numberOfElements-1, elements[i]);
            int pairDiff = Math.abs(elements[i] + optimalPairValue);
            if(minPairDiff > pairDiff) {
                solution[0] = elements[i];
                solution[1] = optimalPairValue;
                minPairDiff = pairDiff;
            }
        }

        System.out.println(solution[0] + " " + solution[1]);

        bf.close();
        System.exit(0);
    }

    private static int findOptimalPairValue(int[] elements, int leftIndex, int rightIndex, int pair) {
        int middleIndex;
        int pairSum;
        int pairDiff;
        int minPairDiff = Integer.MAX_VALUE;
        int optimalPairValue = 0;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            pairSum = pair + elements[middleIndex];
            pairDiff = Math.abs(pairSum);

            if(minPairDiff > pairDiff) {
                minPairDiff = pairDiff;
                optimalPairValue = elements[middleIndex];
            }

            if(pairSum < 0) {
                leftIndex = middleIndex + 1;
            } else if(pairSum > 0) {
                rightIndex = middleIndex - 1;
            } else {
                return elements[middleIndex];
            }
        }
        return optimalPairValue;
    }
}