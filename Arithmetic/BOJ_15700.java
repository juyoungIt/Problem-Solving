// BOJ - 15700
// Problem Sheet - https://www.acmicpc.net/problem/15700

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        System.out.println(n * m / 2);

        bf.close();
        System.exit(0);
    }
}