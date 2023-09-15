// BOJ - 20254
// Problem Sheet - https://www.acmicpc.net/problem/20254

import java.util .*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int ur = Integer.parseInt(st.nextToken());
        int tr = Integer.parseInt(st.nextToken());
        int uo = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.println(56 * ur + 24 * tr + 14 * uo + 6 * to);

        bf.close();
        System.exit(0);
    }
}