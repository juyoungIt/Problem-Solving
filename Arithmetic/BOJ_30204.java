// BOJ - 30204
// Problem Sheet - https://www.acmicpc.net/problem/30204

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int acc = 0;
        for (int i=0 ; i<n ; i++) {
            int pi = Integer.parseInt(st.nextToken());
            acc += pi % x;
        }

        if (acc % x == 0) System.out.println(1);
        else System.out.println(0);

        br.close();
        System.exit(0);
    }
}