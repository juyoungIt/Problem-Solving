// BOJ - 24075
// Problem Sheet - https://www.acmicpc.net/problem/24075

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberA = Integer.parseInt(st.nextToken());
        int numberB = Integer.parseInt(st.nextToken());

        int sum = numberA + numberB;
        int diff = numberA - numberB;

        System.out.printf("%d\n%d\n", Math.max(sum, diff), Math.min(sum, diff));

        br.close();
        System.exit(0);
    }
}