// BOJ - 23881
// Problem Sheet - https://www.acmicpc.net/problem/23881

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int swapCount = 0;
        int[] swappedElements = new int[2];
        for (int i=N-1 ; i>=0 ; i--) {
            int maxElementIndex = getMaxElementIndex(arr, i);
            if (maxElementIndex != i) {
                swap(arr, i, maxElementIndex);
                if (++swapCount == K) {
                    swappedElements[0] = arr[maxElementIndex];
                    swappedElements[1] = arr[i];
                    break;
                }
            }
        }

        if (swapCount < K) {
            System.out.println(-1);
        } else {
            System.out.printf("%d %d\n", swappedElements[0], swappedElements[1]);
        }

        br.close();
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
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