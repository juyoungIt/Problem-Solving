// BOJ - 1684
// Problem Sheet - https://www.acmicpc.net/problem/1684

import java.util.*;
import java.io.*;

public class Main {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for (int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        for (int i=max ; i>=1 ; i--) {
            if (isValid(arr, i)) {
                System.out.println(i);
                return;
            }
        }
        br.close();
    }

    private static boolean isValid(int[] arr, int divider) {
        int criteria = Math.floorMod(arr[0], divider);
        for (int i=1 ; i<n ; i++) {
            if (criteria != Math.floorMod(arr[i], divider)) {
                return false;
            }
        }
        return true;
    }
}
