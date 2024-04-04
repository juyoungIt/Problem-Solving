// BOJ - 5666
// Problem Sheet - https://www.acmicpc.net/problem/5666

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input);
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            sb.append(String.format("%.2f\n", (double) h / p));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}