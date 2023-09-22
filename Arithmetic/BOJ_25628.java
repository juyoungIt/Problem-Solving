// BOJ - 25628
// Problem Sheet - https://www.acmicpc.net/problem/25628

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(A / 2, B));

        bf.close();
        System.exit(0);
    }
}