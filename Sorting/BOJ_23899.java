// BOJ - 23899
// Problem Sheet - https://www.acmicpc.net/problem/23899

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isValid = false;
        if (Arrays.equals(A, B)) {
            isValid = true;
        } else {
            for (int i=N-1 ; i>0 ; i--) {
                int maxElementIndex = getMaxElementIndex(A, i);
                if (maxElementIndex != i) {
                    swap(A, maxElementIndex, i);
                    if (Arrays.equals(A, B)) {
                        isValid = true;
                        break;
                    }
                }
            }
        }

        System.out.println(isValid ? 1 : 0);
        br.close();
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp  = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int getMaxElementIndex(int[] arr, int end) {
        int maxElementIndex = 0;
        int maxElement = arr[0];
        for (int i=0 ; i<=end ; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxElementIndex = i;
            }
        }
        return maxElementIndex;
    }
}