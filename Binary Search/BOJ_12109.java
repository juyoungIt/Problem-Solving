// BOJ - 12109
// Problem Sheet - https://www.acmicpc.net/problem/12109

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(scores);

        int start = 0;
        int end = scores[N - 1];
        int hIndex = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int lowerBoundIndex = getLowerBoundIndex(scores, mid);
            if (lowerBoundIndex < 0) {
                start = mid + 1;
                continue;
            }
            int count = N - lowerBoundIndex;
            if (count >= mid) {
                hIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(hIndex);
        br.close();
    }

    private static int getLowerBoundIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int lowerBoundIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                lowerBoundIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBoundIndex;
    }
}