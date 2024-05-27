// BOJ - 18114
// Problem Sheet - https://www.acmicpc.net/problem/18114

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isPurchasable = false;
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());

        /* 1개로 C를 충족하는 경우 */
        for (int i=0 ; i<n ; i++) {
            int weight = Integer.parseInt(st.nextToken());
            if (weight == c) {
                isPurchasable = true;
                break;
            }
            weights[i] = weight;
        }
        Arrays.sort(weights);

        /* 2개로 C를 충족하는 경우 */
        for (int i=0 ; i<n ; i++) {
            if (isPurchasable) break;
            int start = i+1;
            int end = n-1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int pairSum = weights[i] + weights[mid];
                if (pairSum < c) {
                    start = mid + 1;
                } else if (pairSum > c) {
                    end = mid - 1;
                } else {
                    isPurchasable = true;
                    break;
                }
            }
        }

        /* 3개로 C를 충족하는 경우 */
        for (int i=0 ; i<n ; i++) {
            if (isPurchasable) break;
            for (int j=i+1 ; j<n ; j++) {
                if (isPurchasable) break;
                int start = j+1;
                int end = n-1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int remainSum = c - (weights[i] + weights[j]);
                    if (remainSum < weights[mid]) {
                        end = mid - 1;
                    } else if (remainSum > weights[mid]) {
                        start = mid + 1;
                    } else {
                        isPurchasable = true;
                        break;
                    }
                }
            }
        }

        System.out.println((isPurchasable) ? 1 : 0);

        br.close();
        System.exit(0);
    }
}