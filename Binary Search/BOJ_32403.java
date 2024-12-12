// BOJ - 32403
// Problem Sheet - https://www.acmicpc.net/problem/32403

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        List<Integer> divisors = getAllDivisors(T);
        int answer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(ai -> Math.abs(ai - findClosest(divisors, ai)))
                .sum();

        System.out.println(answer);
        br.close();
    }

    private static int findClosest(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        int closestIndex = -1;
        int minDiff = 1_001;
        while (start <= end) {
            int mid = (start + end) / 2;
            int diff = target - list.get(mid);
            if (minDiff > Math.abs(diff)) {
                minDiff = Math.abs(diff);
                closestIndex = mid;
            }
            if (diff == 0) {
                return list.get(closestIndex);
            } else if (diff < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return list.get(closestIndex);
    }

    private static List<Integer> getAllDivisors(int N) {
        List<Integer> divisors = new ArrayList<>();
        for (int i=1 ; i<=N ; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}