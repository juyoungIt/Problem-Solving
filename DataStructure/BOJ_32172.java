// BOJ - 32172
// Problem Sheet - https://www.acmicpc.net/problem/32172

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] A;
    private static final Set<Integer> elementSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        br.close();
    }

    private static int solve() {
        elementSet.add(0);
        for (int i=1 ; i<=N ; i++) {
            A[i] = generate(i);
            elementSet.add(A[i]);
        }
        return A[N];
    }

    private static int generate(int seq) {
        int prev = A[seq - 1];
        return prev - seq < 0 || elementSet.contains(prev - seq)
                ? prev + seq
                : prev - seq;
    }
}