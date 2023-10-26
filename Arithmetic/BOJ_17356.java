// BOJ - 17356
// Problem Sheet - https://www.acmicpc.net/problem/17356

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double m = (double)(b - a) / 400;

        System.out.printf("%f\n", 1 / (1 + Math.pow(10, m)));

        bf.close();
        System.exit(0);
    }
}