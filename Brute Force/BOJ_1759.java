// BOJ - 1759
// Problem Sheet - https://www.acmicpc.net/problem/1759

import java.util.*;
import java.io.*;

public class Main {

    private static int L, C;
    private static char[] arr;
    private static char[] buffer;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        L = Integer.parseInt(row[0]);
        C = Integer.parseInt(row[1]);
        arr = new char[C];
        buffer = new char[L];
        row  = br.readLine().split(" ");
        for (int i=0 ; i<C ; i++) {
            arr[i] = row[i].charAt(0);
        }
        Arrays.sort(arr);
        br.close();
    }

    private static void solve(int depth, int startIndex) {
        if (depth == L) {
            if (isValid(buffer)) {
                sb.append(getBufferString()).append("\n");
            }
            return;
        }
        for (int i=startIndex ; i<C ; i++) {
            buffer[depth] = arr[i];
            solve(depth + 1, i + 1);
        }
    }

    private static String getBufferString() {
        StringBuilder sb = new StringBuilder();
        for (char letter : buffer) {
            sb.append(letter);
        }
        return sb.toString();
    }

    private static boolean isValid(char[] buffer) {
        int countA = 0, countB = 0;
        for (char letter : buffer) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                countA++;
            } else {
                countB++;
            }
        }
        return countA >= 1 && countB >= 2;
    }
}