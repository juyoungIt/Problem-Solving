// BOJ - 34236
// Problem Sheet - https://www.acmicpc.net/problem/34236

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(arr[n - 1] + arr[1] - arr[0]);
        br.close();
    }
}
