// BOJ - 24264
// Problem Sheet - https://www.acmicpc.net/problem/24264

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());

        System.out.println(N * N + "\n" + 2);

        bf.close();
        System.exit(0);
    }
}