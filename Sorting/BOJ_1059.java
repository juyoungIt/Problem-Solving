// BOJ - 1059
// Problem Sheet - https://www.acmicpc.net/problem/1059

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=L ; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S);
        int n = Integer.parseInt(br.readLine());
        int s = getLeftIndex(S, n);
        int e = getRightIndex(S, n);

        int answer = 0;
        if (s < e && S[s] != n && S[e] != n) {
            answer = (S[e] - n) * (n - S[s] - 1) + (S[e] - n - 1);
        }
        System.out.println(answer);

        br.close();
    }

    private static int getLeftIndex(int[] S, int n) {
        int start = 0;
        int end = S.length;
        int leftIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (S[mid] <= n) {
                leftIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return leftIndex;
    }

    private static int getRightIndex(int[] S, int n) {
        int start = 0;
        int end = S.length;
        int rightIndex = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (S[mid] > n) {
                rightIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return rightIndex;
    }
}