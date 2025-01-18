// BOJ - 24387
// Problem Sheet - https://www.acmicpc.net/problem/24387

import java.util.*;
import java.io.*;

public class Main {

    private static int[] A;
    private static int[] V;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        V = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static long solve() {
        long sum = 0;
        for (int i=0 ; i<3 ; i++) {
            sum += (long) A[i] * V[i];
        }
        return sum;
    }
}
