// BOJ - 6177
// Problem Sheet - https://www.acmicpc.net/problem/6177

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        double median;
        if (n % 2 == 0) median = (double) (arr[n / 2 - 1] + arr[n / 2]) / 2;
        else median = arr[n / 2];
        System.out.printf("%.6f\n%.6f", (double) sum / n, median);
        br.close();
    }

}