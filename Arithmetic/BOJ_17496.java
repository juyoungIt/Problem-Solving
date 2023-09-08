// BOJ - 17496
// Problem Sheet - https://www.acmicpc.net/problem/17496

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = P * ((N - 1) / T) * C;
        System.out.println(result);

        bf.close();
        System.exit(0);
    }
}