// BOJ - 25943
// Problem Sheet - https://www.acmicpc.net/problem/25943

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] weights = { 1, 2, 5, 10, 20, 50, 100 };
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        int left = arr[0], right = arr[1];
        for (int i=2 ; i<n ; i++) {
            if (left == right) {
                left += arr[i];
            } else {
                if (left > right) right += arr[i];
                else left += arr[i];
            }
        }
        int diff = Math.abs(left - right);
        int count = 0;
        for (int i=6 ; i>=0 ; i--) {
            count += diff / weights[i];
            diff %= weights[i];
        }
        System.out.println(count);
    }
}
