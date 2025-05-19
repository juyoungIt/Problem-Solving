// BOJ - 27024
// Problem Sheet - https://www.acmicpc.net/problem/27024

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int searchSize = n / 2 + 1;
        int min = arr[n - 1] - arr[0];
        for (int i=0 ; i<=n-searchSize ; i++) {
            min = Math.min(min, arr[i + searchSize - 1] - arr[i]);
        }
        System.out.println(min);
        br.close();
    }
}