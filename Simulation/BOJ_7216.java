// BOJ - 7216
// Problem Sheet - https://www.acmicpc.net/problem/7216

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lastCalled = k;
        while (arr[lastCalled] != k) {
            lastCalled = arr[lastCalled];
        }
        System.out.println(lastCalled);
        br.close();
    }
}