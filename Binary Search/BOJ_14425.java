// BOJ - 14425
// Problem Sheet - https://www.acmicpc.net/problem/14425

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int validCount = 0;

        int numberOfElements = Integer.parseInt(st.nextToken());
        int numberOfSearches = Integer.parseInt(st.nextToken());
        String[] elements = new String[numberOfElements];
        for(int i=0 ; i<numberOfElements ; i++) {
            elements[i] = bf.readLine();
        }
        Arrays.sort(elements);

        for(int i=0 ; i<numberOfSearches ; i++) {
            if(isExist(elements, bf.readLine())) {
                validCount++;
            }
        }

        System.out.println(validCount);

        bf.close();
        System.exit(0);
    }

    private static boolean isExist(String[] elements, String target) {
        int leftIndex = 0;
        int rightIndex = elements.length - 1;
        int middleIndex;
        int compareIndex;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            compareIndex = elements[middleIndex].compareTo(target);
            if(compareIndex < 0) {
                leftIndex = middleIndex + 1;
            } else if(compareIndex > 0) {
                rightIndex = middleIndex - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}