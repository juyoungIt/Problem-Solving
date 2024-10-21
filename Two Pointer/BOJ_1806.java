// BOJ - 1806
// Problem Sheet - https://www.acmicpc.net/problem/1806

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] acc = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=N ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int minLength = 0;
        while (left < right && right <= N) {
            int sum = acc[right] - acc[left];
            if (sum >= S) {
                int length = right - left;
                if (minLength == 0 || length < minLength) {
                    minLength = length;
                }
                left++;
            } else {
                right++;
            }
        }

        System.out.println(minLength);

        br.close();
    }
}