// BOJ - 2473
// Problem Sheet - https://www.acmicpc.net/problem/2473

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        int[] result = solve();
        System.out.printf("%d %d %d\n", result[0], result[1], result[2]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static int[] solve() {
        int[] result = new int[3];
        long minDiff = 3_000_000_001L;
        for (int i=0 ; i<N-2 ; i++) {
            int left = i + 1, right = N - 1;
            while (left < right) {
                long diff = (long) arr[i] + arr[left] + arr[right];
                if (minDiff > Math.abs(diff)) {
                    minDiff = Math.abs(diff);
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if (diff == 0) {
                    break;
                } else if (diff < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}