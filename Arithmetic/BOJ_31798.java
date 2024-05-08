// BOJ - 31798
// Problem Sheet - https://www.acmicpc.net/problem/31798

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer;
        if (a == 0) answer = (int) Math.pow(c, 2) - b;
        else if (b == 0) answer = (int) Math.pow(c, 2) - a;
        else answer = (int) Math.sqrt(a + b);

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}