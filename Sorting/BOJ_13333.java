// BOJ - 13333
// Problem Sheet - https://www.acmicpc.net/problem/13333

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] quotaions = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxQuotaions = 0;
        for (int i=0 ; i<n ; i++) {
            quotaions[i] = Integer.parseInt(st.nextToken());
            if (quotaions[i] > maxQuotaions) {
                maxQuotaions = quotaions[i];
            }
        }
        Arrays.sort(quotaions);

        for (int i=maxQuotaions ; i>=0 ; i--) {
            int upperCount = getUpperCount(quotaions, i);
            if (upperCount >= i) {
                System.out.println(i);
                break;
            }
        }

        br.close();
        System.exit(0);
    }

    private static int getUpperCount(int[] arr, int target) {
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
        return arr.length - Math.max(0, lowerBoundIndex);
    }
}