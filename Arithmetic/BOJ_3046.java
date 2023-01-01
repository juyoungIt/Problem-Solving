// BOJ - 3046
// Problem Sheet - https://www.acmicpc.net/problem/3046

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        System.out.println(s * 2 - r1);

        bf.close();
        System.exit(0);
    }
}