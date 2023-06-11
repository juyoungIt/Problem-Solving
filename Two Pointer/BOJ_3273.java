// BOJ - 3273
// Problem Sheet - https://www.acmicpc.net/problem/3273

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int numberOfElements = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] elements = new int[numberOfElements];
        for(int i=0 ; i<numberOfElements ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(elements);
        int target = Integer.parseInt(bf.readLine());

        int leftIndex = 0;
        int rightIndex = numberOfElements-1;
        while(leftIndex < rightIndex) {
            if(elements[leftIndex] + elements[rightIndex] == target) {
                leftIndex++;
                rightIndex--;
                result++;
            } else if(elements[leftIndex] + elements[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}