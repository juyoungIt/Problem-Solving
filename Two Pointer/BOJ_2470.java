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

        int leftIndex = 0;
        int rightIndex = elements.length-1;
        int currentDiff;
        int minDiff = Integer.MAX_VALUE;
        int[] solution = new int[2];
        while(leftIndex < rightIndex) {
            currentDiff = elements[leftIndex] + elements[rightIndex];
            if(minDiff > Math.abs(currentDiff)) {
                minDiff = Math.abs(currentDiff);
                solution[0] = elements[leftIndex];
                solution[1] = elements[rightIndex];
            }
            if(currentDiff > 0) {
                rightIndex--;
            } else if(currentDiff < 0) {
                leftIndex++;
            } else {
                break;
            }
        }

        System.out.println(solution[0] + " " + solution[1]);

        bf.close();
        System.exit(0);
    }
}