// BOJ - 18301
// Problem Sheet - https://www.acmicpc.net/problem/18301

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println((int)Math.floor((a + 1) * (b + 1) / (c + 1) - 1));

        bf.close();
        System.exit(0);
    }
}