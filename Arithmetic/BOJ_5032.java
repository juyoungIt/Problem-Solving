// BOJ - 5032
// Problem Sheet - https://www.acmicpc.net/problem/5032

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(e + f < c) {
            System.out.println(0);
        } else {
            System.out.println((e + f - c) / (c - 1) + 1);
        }

        bf.close();
        System.exit(0);
    }
}