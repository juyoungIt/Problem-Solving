// BOJ - 29751
// Problem Sheet - https://www.acmicpc.net/problem/29751

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        System.out.printf("%.1f\n", (double)w * h / 2);

        bf.close();
        System.exit(0);
    }
}