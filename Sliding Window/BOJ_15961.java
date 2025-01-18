// BOJ - 15961
// Problem Sheet - https://www.acmicpc.net/problem/15961

import java.util.*;
import java.io.*;

public class Main {

    private static int N, d, k, c;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        d = Integer.parseInt(row[1]);
        k = Integer.parseInt(row[2]);
        c = Integer.parseInt(row[3]);
        arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int solve() {
        int maxKinds = 0;
        int[] counts = new int[d + 1];
        Set<Integer> kindSet = new HashSet<>();
        for (int i=0 ; i<k ; i++) {
            counts[arr[i]]++;
            kindSet.add(arr[i]);
        }
        maxKinds = Math.max(maxKinds, kindSet.size() + (kindSet.contains(c) ? 0 : 1));
        for (int i=1 ; i<N ; i++) {
            counts[arr[i - 1]]--;
            if (counts[arr[i - 1]] == 0) {
                kindSet.remove(arr[i - 1]);
            }
            counts[arr[(i + k - 1) % N]]++;
            kindSet.add(arr[(i + k - 1) % N]);
            maxKinds = Math.max(maxKinds, kindSet.size() + (kindSet.contains(c) ? 0 : 1));
        }
        return maxKinds;
    }
}