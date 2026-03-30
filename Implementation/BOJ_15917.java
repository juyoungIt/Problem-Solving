// BOJ - 15917
// Problem Sheet - https://www.acmicpc.net/problem/15917

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            int a = Integer.parseInt(br.readLine());
            sb.append(isValid(a) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isValid(int n) {
        return (n & (-n)) == n;
    }
}
