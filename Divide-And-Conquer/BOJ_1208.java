// BOJ - 1208
// Problem Sheet - https://www.acmicpc.net/problem/1208

import java.util.*;
import java.io.*;

public class Main {

    private static int N, S;
    private static int[] arr;
    private static final Map<Integer, Integer> counts = new HashMap<>();
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, N/2 , 0);
        solve(N/2, N, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        S = Integer.parseInt(row[1]);
        arr = new int[N];
        row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        br.close();
    }

    private static void solve(int startIndex, int endIndex, int acc) {
        if (startIndex >= endIndex) {
            if (endIndex < N) {
                counts.put(acc, counts.getOrDefault(acc, 0) + 1);
            } else {
                answer += counts.getOrDefault(S - acc, 0);
            }
            return;
        }
        solve(startIndex + 1, endIndex, acc);
        solve(startIndex + 1, endIndex, acc + arr[startIndex]);
    }
}