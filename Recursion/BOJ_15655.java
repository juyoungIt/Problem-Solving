// BOJ - 15655
// Problem Sheet - https://www.acmicpc.net/problem/15655

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static boolean[] isUsed;
    private static int[] buffer;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        generateSequence(0, 0);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        isUsed = new boolean[N];
        buffer = new int[M];
        sb = new StringBuilder();
        br.close();
    }

    private static void generateSequence(int depth, int startIndex) {
        if (depth == M) {
            sb.append(getBufferString()).append("\n");
            return;
        }
        for (int i=startIndex ; i<N ; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                buffer[depth] = arr[i];
                generateSequence(depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }

    private static String getBufferString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(buffer).forEach(l -> sb.append(l).append(" "));
        return sb.toString();
    }
}