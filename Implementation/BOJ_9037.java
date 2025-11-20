// BOJ - 9037
// Problem Sheet - https://www.acmicpc.net/problem/9037

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i=0 ; i<n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            adjust(arr);
            int count = 0;
            while (!isFinished(arr)) {
                circulate(arr);
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void adjust(int[] arr) {
        for (int i=0 ; i<arr.length ; i++) {
            arr[i] += arr[i] % 2;
        }
    }

    private static void circulate(int[] arr) {
        int[] increment = new int[arr.length];
        for (int i=0 ; i<arr.length ; i++) {
            increment[(i + 1) % arr.length] = arr[i] / 2;
            arr[i] /= 2;
        }
        for (int i=0 ; i<arr.length ; i++) {
            arr[i] += increment[i];
            arr[i] += arr[i] % 2;
        }
    }

    private static boolean isFinished(int[] arr) {
        int base = arr[0];
        for (int e : arr) {
            if (e != base) {
                return false;
            }
        }
        return true;
    }
}
