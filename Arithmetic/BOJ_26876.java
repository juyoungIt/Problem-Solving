// BOJ - 26876
// Problem Sheet - https://www.acmicpc.net/problem/26876

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] currentTime = Arrays.stream(br.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] targetTime = Arrays.stream(br.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (targetTime[0] < currentTime[0]) {
            targetTime[0] += 24;
        }
        int diff = targetTime[1] - currentTime[1];
        if (diff < 0) {
            diff += 60;
            targetTime[0]--;
        }
        int tmp = targetTime[0] - currentTime[0];
        diff += ((tmp >= 0) ? tmp : tmp + 24) * 60;
        System.out.println(diff / 60 + diff % 60);

        br.close();
        System.exit(0);
    }
}