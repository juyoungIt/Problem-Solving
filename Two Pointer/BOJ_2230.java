// BOJ - 2230
// Problem Sheet - https://www.acmicpc.net/problem/2230

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int minDiff = 2_000_000_001;
        while (left <= right && right < N) {
            int diff = arr[right] - arr[left];
            if (diff >= M) {
                minDiff = Math.min(minDiff, diff);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(minDiff);

        br.close();
    }
}