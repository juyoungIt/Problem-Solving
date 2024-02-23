// BOJ - 15734
// Problem Sheet - https://www.acmicpc.net/problem/15734

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        if(Math.abs(l - r) > a) {
            System.out.println((Math.min(l, r) + (Math.abs(l - r) - a)) * 2);
        } else if(Math.abs(l - r) == a) {
            System.out.println(Math.max(l, r) * 2);
        } else {
            System.out.println((Math.max(l, r) + (a - Math.abs(l - r)) / 2) * 2);
        }

        br.close();
        System.exit(0);
    }
}