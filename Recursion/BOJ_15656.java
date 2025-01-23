// BOJ - 15656
// Problem Sheet - https://www.acmicpc.net/problem/15656

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static int[] buffer;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        generateSequence(0);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        arr = new int[N];
        row = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }
        Arrays.sort(arr);
        buffer = new int[M];
        sb = new StringBuilder();
        br.close();
    }

    private static void generateSequence(int depth) {
        if (depth == M) {
            sb.append(getBufferString()).append("\n");
            return;
        }
        for (int i=0 ; i<N ; i++) {
            buffer[depth] = arr[i];
            generateSequence(depth + 1);
        }
    }

    private static String getBufferString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<M ; i++) {
            sb.append(buffer[i]).append(" ");
        }
        return sb.toString();
    }
}