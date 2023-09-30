// BOJ - 25191
// Problem Sheet - https://www.acmicpc.net/problem/25191

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(n, a / 2 + b));

        bf.close();
        System.exit(0);
    }
}