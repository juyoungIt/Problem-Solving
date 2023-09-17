// BOJ - 15726
// Problem Sheet - https://www.acmicpc.net/problem/15726

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println((long)Math.max((double)a * b / c, (double)a / b * c));

        bf.close();
        System.exit(0);
    }
}