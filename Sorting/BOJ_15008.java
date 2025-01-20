// BOJ - 15008
// Problem Sheet - https://www.acmicpc.net/problem/15008

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static String solve() {
        int alice = 0, bob = 0;
        for (int i=0 ; i<n ; i++) {
            if (i % 2== 0) alice += arr[n - 1 - i];
            else bob += arr[n - 1 - i];
        }
        return String.format("%d %d", alice, bob);
    }
}