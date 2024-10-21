// BOJ - 2003
// Problem Sheet - https://www.acmicpc.net/problem/2003

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] acc = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=N ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        int validCount = 0;
        int left = 0;
        int right = 1;
        while (left < right && right <= N) {
            int sum = acc[right] - acc[left];
            if (sum == M) {
                validCount++;
                left++;
                right++;
            } else if (sum < M) {
                right++;
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        System.out.println(validCount);
        br.close();
    }
}