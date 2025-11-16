// BOJ - 33515
// Problem Sheet - https://www.acmicpc.net/problem/33515

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(t1, t2));
        br.close();
    }
}