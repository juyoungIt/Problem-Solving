// BOJ - 6502
// Problem Sheet - https://www.acmicpc.net/problem/6502

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) break;
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            boolean isFit = isFit(r, w, l);
            sb.append("Pizza ")
                    .append(idx++)
                    .append(isFit ? " fits on the table." : " does not fit on the table.")
                    .append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isFit(int r, int w, int l) {
        return Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2)) <= 2 * r;
    }
}
