// BOJ - 31654
// Problem Sheet - https://www.acmicpc.net/problem/31654

import java.util.*;
import java.io.*;

public class Main {

    private static final String correct = "correct!";
    private static final String wrong = "wrong!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a + b == c) System.out.println(correct);
        else System.out.println(wrong);

        br.close();
        System.exit(0);
    }
}