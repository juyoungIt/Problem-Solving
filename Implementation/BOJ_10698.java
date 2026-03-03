// BOJ - 10698
// Problem Sheet - https://www.acmicpc.net/problem/10698

import java.util.*;
import java.io.*;

public class Main {

    private static final String FORMAT = "Case %d: %s\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            String[] operands = br.readLine().split(" ");
            int a = Integer.parseInt(operands[0]);
            int b = Integer.parseInt(operands[2]);
            int c = Integer.parseInt(operands[4]);
            if (operands[1].charAt(0) == '+') {
                String answer = a + b == c ? "YES" : "NO";
                sb.append(String.format(FORMAT, i, answer));
            } else {
                String answer = a - b == c ? "YES" : "NO";
                sb.append(String.format(FORMAT, i, answer));
            }
        }
        System.out.println(sb);
        br.close();
    }
}
