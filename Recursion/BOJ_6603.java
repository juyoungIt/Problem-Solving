// BOJ - 6603
// Problem Sheet - https://www.acmicpc.net/problem/6603

import java.util.*;
import java.io.*;

public class Main {

    private static int k;
    private static int[] arr;
    private static int[] buffer;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
            if (k == 0) break;
            arr = new int[k];
            buffer = new int[6];
            for (int i=1 ; i<=k ; i++) {
                arr[i - 1] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            solve(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void solve(int depth, int startIndex) {
        if (depth == 6) {
            sb.append(getBufferString()).append("\n");
            return;
        }
        for (int i=startIndex ; i<k ; i++) {
            buffer[depth] = arr[i];
            solve(depth + 1, i + 1);
        }
    }

    private static String getBufferString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<6 ; i++) {
            sb.append(buffer[i]).append(" ");
        }
        return sb.toString();
    }
}