// BOJ - 19698
// Problem Sheet - https://www.acmicpc.net/problem/19698

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        System.out.println(Math.min((W / L) * (H / L), N));

        bf.close();
        System.exit(0);
    }
}