// BOJ - 1475
// Problem Sheet - https://www.acmicpc.net/problem/1475

import java.util.*;
import java.io.*;

public class Main {

    private static String N;
    private static final int[] counts = new int[10];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        br.close();
    }

    private static int solve() {
        int count = 0;
        int[] digits = Arrays.stream(N.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int digit : digits) {
            counts[digit]++;
        }
        for (int i=0 ; i<10 ; i++) {
            if (i == 6 || i == 9) continue;
            count = Math.max(count, counts[i]);
        }
        count = Math.max(
                count,
                (counts[6] + counts[9]) % 2 == 0
                        ? (counts[6] + counts[9]) / 2
                        : (counts[6] + counts[9]) / 2 + 1
        );
        return count;
    }
}