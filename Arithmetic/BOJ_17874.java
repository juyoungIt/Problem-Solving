// BOJ - 17874
// Problem Sheet - https://www.acmicpc.net/problem/17874

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(n - h, h) * Math.max(n - v, v) * 4);

        br.close();
        System.exit(0);
    }
}