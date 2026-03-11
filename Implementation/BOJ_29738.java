// BOJ - 29738
// Problem Sheet - https://www.acmicpc.net/problem/29738

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Case #%d: %s\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 4_500) sb.append(String.format(FORMAT, i, "Round 1"));
            else if (n > 1_000) sb.append(String.format(FORMAT, i, "Round 2"));
            else if (n > 25) sb.append(String.format(FORMAT, i, "Round 3"));
            else sb.append(String.format(FORMAT, i, "World Finals"));
        }
        System.out.println(sb);
        br.close();
    }
}
