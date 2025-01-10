// BOJ - 23882
// Problem Sheet - https://www.acmicpc.net/problem/23882

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int swapCount = 0;
        for (int i=N-1 ; i>0 ; i--) {
            if (swapCount == K) break;
            int maxElementIndex = getMaxElementIndex(arr, i);
            if (maxElementIndex != i) {
                swap(arr, maxElementIndex, i);
                swapCount++;
            }
        }

        if (swapCount < K) {
            sb.append(-1);
        } else {
            Arrays.stream(arr).forEach(e -> sb.append(e).append(" "));
        }

        System.out.println(sb);
        br.close();
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int getMaxElementIndex(int[] arr, int end) {
        int maxElement = arr[0];
        int maxElementIndex = 0;
        for (int i=0 ; i<=end ; i++) {
            if (arr[i] > maxElement) {
                maxElementIndex = i;
                maxElement = arr[i];
            }
        }
        return maxElementIndex;
    }
}
