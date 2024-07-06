// BOJ - 22015
// Problem Sheet - https://www.acmicpc.net/problem/22015

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = Math.max(a, Math.max(b, c));

        int answer = (max - a) + (max - b) + (max - c);
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}