// BOJ - 21967
// Problem Sheet - https://www.acmicpc.net/problem/21967

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = 1, max = n;
        int answer = 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (isExist(mid)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean isExist(int len) {
        int[] count = new int[11];
        for (int i=0 ; i<len ; i++) {
            count[arr[i]]++;
        }
        if (getMax(count) - getMin(count) <= 2) return true;
        for (int i=1 ; i<n ; i++) {
            if (i + len - 1 >= n) break;
            count[arr[i - 1]]--;
            count[arr[i + len - 1]]++;
            if (getMax(count) - getMin(count) <= 2) return true;
        }
        return false;
    }

    private static int getMin(int[] count) {
        for (int i=1 ; i<=10 ; i++) {
            if (count[i] > 0) return i;
        }
        return -1;
    }

    private static int getMax(int[] count) {
        for (int i=10 ; i>=1 ; i--) {
            if (count[i] > 0) return i;
        }
        return -1;
    }
}
