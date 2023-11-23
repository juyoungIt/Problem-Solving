// BOJ - 30017
// Problem Sheet - https://www.acmicpc.net/problem/30017

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println((a - 1) <= b ? 2 * a - 1 : 2 * b + 1);

        br.close();
        System.exit(0);
    }
}