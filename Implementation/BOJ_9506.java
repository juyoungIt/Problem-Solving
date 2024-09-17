// BOJ - 9506
// Problem Sheet - https://www.acmicpc.net/problem/9506

import java.util.*;
import java.io.*;

public class Main {

    private static final String VALID_OUTPUT_FORMAT = "%d = %s";
    private static final String INVALID_OUTPUT_FORMAT = "%d is NOT perfect.";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            String result = isPerfectNumber(n);
            if (result != null) {
                sb.append(String.format(VALID_OUTPUT_FORMAT, n, result)).append("\n");
            } else {
                sb.append(String.format(INVALID_OUTPUT_FORMAT, n)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String isPerfectNumber(int n) {
        StringJoiner sj = new StringJoiner(" + ");
        int sum = 0;
        for (int i=1 ; i<n ; i++) {
            if (n % i == 0) {
                sum += i;
                sj.add(Integer.toString(i));
            }
        }
        return sum == n ? sj.toString() : null;
    }
}