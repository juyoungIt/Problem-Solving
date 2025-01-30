// BOJ - 24855
// Problem Sheet - https://www.acmicpc.net/problem/24855

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] arr;
    private static int totalSum;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        totalSum = 0;
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(row[i]);
            totalSum += arr[i];
        }
        Arrays.sort(arr);
        br.close();
    }

    private static int solve() {
        int size = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i=0 ; i<size ; i++) {
            totalSum -= arr[i];
        }
        return totalSum;
    }
}