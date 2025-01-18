// BOJ - 7795
// Problem Sheet - https://www.acmicpc.net/problem/7795

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] B = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int count = 0;
            for (int element : A) {
                count += (findLowerIndex(B, element) + 1);
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int findLowerIndex(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int lowerIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                lowerIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lowerIndex;
    }
}