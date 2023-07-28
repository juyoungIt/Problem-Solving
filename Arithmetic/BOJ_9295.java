// BOJ - 9295
// Problem Sheet - https://www.acmicpc.net/problem/9295

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=1 ; i<=T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int numberA = Integer.parseInt(st.nextToken());
            int numberB = Integer.parseInt(st.nextToken());
            sb.append(String.format("Case %d: %d\n", i, numberA + numberB));
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}