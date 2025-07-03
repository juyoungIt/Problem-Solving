// BOJ - 8633
// Problem Sheet - https://www.acmicpc.net/problem/8633

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static String[] jewels;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        jewels = new String[n];
        for (int i=0 ; i<n ; i++) {
            jewels[i] = br.readLine();
        }
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(jewels, (j1, j2) -> {
            if (j1.length() == j2.length()) return j1.compareTo(j2);
            return j1.length() - j2.length();
        });
        for (String jewel : jewels) {
            sb.append(jewel).append("\n");
        }
        return sb.toString();
    }

}
