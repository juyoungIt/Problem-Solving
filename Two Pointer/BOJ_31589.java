// BOJ - 31589
// Problem Sheet - https://www.acmicpc.net/problem/31589

import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static int[] T;

    public static void main(String[] args) throws IOException {
        getInput();
        System.out.println(solve());
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        T = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static long solve() {
        long tSum = 0;
        int left = 0, right = N-1;
        int prevT = 0;
        int tCount = 0;
        while (left <= right) {
            if (tCount >= K) break;
            if (tCount % 2 == 0) {
                tSum += T[right] - prevT;
                tCount++;
                prevT = T[right--];
            } else {
                tSum += Math.max(0, T[left] - prevT);
                tCount++;
                prevT = T[left++];
            }
        }
        return tSum;
    }
}