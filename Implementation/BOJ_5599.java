// BOJ - 5599
// Problem Sheet - https://www.acmicpc.net/problem/5599

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] cards = new int[2 * n];
        for (int i=0 ; i<2*n ; i++) {
            cards[i] = i + 1;
        }
        for (int i=0 ; i<m ; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) cards = riffleShuffle(cards);
            else cards = cut(cards, k);
        }
        StringBuilder sb = new StringBuilder();
        for (int card : cards) {
            sb.append(card).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int[] cut(int[] arr, int k) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, k, newArr, 0, arr.length-k);
        System.arraycopy(arr, 0, newArr, arr.length-k, k);
        return newArr;
    }

    private static int[] riffleShuffle(int[] arr) {
        int[] newArr = new int[arr.length];
        int index = 0;
        for (int i=0 ; i<arr.length/2 ; i++) {
            newArr[index++] = arr[i];
            newArr[index++] = arr[arr.length/2 + i];
        }
        return newArr;
    }
}