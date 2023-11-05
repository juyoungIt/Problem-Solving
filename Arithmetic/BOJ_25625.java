// BOJ - 25625
// Problem Sheet - https://www.acmicpc.net/problem/25625

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println((x > y) ? x + y : y - x);

        bf.close();
        System.exit(0);
    }
}