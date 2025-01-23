// BOJ - 15654
// Problem Sheet - https://www.acmicpc.net/problem/15654

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
        getSequence(0);
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

    private static void getSequence(int depth) {
        if (depth == M) {
            sb.append(getBufferString()).append("\n");
            return;
        }
        for (int i=0 ; i<N ; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                buffer[depth] = arr[i];
                getSequence(depth + 1);
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