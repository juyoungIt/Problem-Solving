// BOJ - 14914
// Problem Sheet - https://www.acmicpc.net/problem/14914

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "%d %d %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i=1 ; i<=Math.max(a, b) ; i++) {
            if (a % i == 0 && b % i == 0) {
                sb.append(String.format(OUTPUT_FORMAT, i, a/i, b/i));
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}