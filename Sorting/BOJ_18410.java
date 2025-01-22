// BOJ - 18410
// Problem Sheet - https://www.acmicpc.net/problem/18410

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] A, B;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int indexA = 0, indexB = 0;
        while (indexA < N && indexB < M) {
            if (A[indexA] < B[indexB]) {
                sb.append(A[indexA++]).append("\n");
            } else {
                sb.append(B[indexB++]).append("\n");
            }
        }

        while (indexA < N) {
            sb.append(A[indexA++]).append("\n");
        }
        while (indexB < M) {
            sb.append(B[indexB++]).append("\n");
        }

        return sb.toString();
    }
}