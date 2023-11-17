// BOJ - 11134
// Problem Sheet - https://www.acmicpc.net/problem/11134

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(n / c + ((n % c == 0) ? 0 : 1)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}