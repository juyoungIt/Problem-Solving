// BOJ - 16401
// Problem Sheet - https://www.acmicpc.net/problem/16401

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int maxLen = 0;
        int[] snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if (maxLen < snacks[i]) {
                maxLen = snacks[i];
            }
        }

        int start = 1;
        int end = maxLen;
        int answer = 0;
        boolean isPossible = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            int kidsCount = 0;
            for (int snack : snacks) {
                kidsCount += snack / mid;
            }
            if (kidsCount >= m) {
                start = mid + 1;
                isPossible = true;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(isPossible ? answer : 0);

        br.close();
        System.exit(0);
    }
}