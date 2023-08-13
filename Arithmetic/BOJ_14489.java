// BOJ - 14489
// Problem Sheet - https://www.acmicpc.net/problem/14489

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(bf.readLine());
        int diff = A + B - C * 2;

        System.out.println((diff >= 0) ? diff : A + B);

        bf.close();
        System.exit(0);
    }
}