// BOJ - 10178
// Problem Sheet - https://www.acmicpc.net/problem/10178

import java.util.*;
import java.io.*;

public class Main {

    private static final String MESSAGE = "You get %d piece(s) and your dad gets %d piece(s).";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(String.format(MESSAGE, c/v, c%v)).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}