// BOJ - 1920
// Problem Sheet - https://www.acmicpc.net/problem/1920

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfElements = Integer.parseInt(bf.readLine());
        int[] arr = new int[numberOfElements];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfElements ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int numberOfSearches = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<numberOfSearches ; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(isExist(arr, target) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean isExist(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        int middleIndex;
        while(leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if(arr[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else if(arr[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}