// BOJ - 6980
// Problem Sheet - https://www.acmicpc.net/problem/6980

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] L;
    private static int[][] arr;
    private static final String OUTPUT_FORMAT = "Optimal train swapping takes %d swaps.";

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        arr = new int[N][1];
        for (int i=0 ; i<N ; i++) {
            L[i] = Integer.parseInt(br.readLine());
            if (L[i] == 0) continue;
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            sb.append(String.format(OUTPUT_FORMAT, getSwapCount(arr[i], L[i]))).append("\n");
        }
        return sb.toString();
    }

    private static int getSwapCount(int[] arr, int size) {
        int swapCount = 0;
        for (int i=size ; i>0 ; i--) {
            for (int j=1 ; j<i ; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}