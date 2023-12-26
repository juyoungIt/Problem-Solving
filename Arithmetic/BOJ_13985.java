// BOJ - 13985
// Problem Sheet - https://www.acmicpc.net/problem/13985

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        String[] exprPartition = expr.split(" = ");
        int leftValue = Arrays.stream(exprPartition[0].split(" \\+ "))
                .mapToInt(Integer::parseInt)
                .sum();
        int rightValue = Integer.parseInt(exprPartition[1]);

        System.out.println(leftValue == rightValue ? "YES" : "NO");

        br.close();
        System.exit(0);
    }
}