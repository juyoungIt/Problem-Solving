// BOJ - 13144
// Problem Sheet - https://www.acmicpc.net/problem/13144

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        getInput();
        System.out.println(solve());
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
    }

    private static long solve() {
        long count = 0;
        int right = 0;
        boolean[] used = new boolean[100_001];
        for (int i=0 ; i<N ; i++) {
            while (right < N) {
                if (used[arr[right]]) {
                    break;
                }
                used[arr[right++]] = true;
            }
            count += (right - i);
            used[arr[i]] = false;
        }
        return count;
    }
}
