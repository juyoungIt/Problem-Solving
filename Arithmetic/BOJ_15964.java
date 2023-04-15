// BOJ - 15964
// Problem Sheet - https://www.acmicpc.net/problem/15964

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long numberA = Integer.parseInt(st.nextToken());
        long numberB = Integer.parseInt(st.nextToken());

        System.out.println((numberA+numberB)*(numberA-numberB));

        bf.close();
        System.exit(0);
    }
}