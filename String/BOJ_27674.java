// BOJ - 27674
// Problem Sheet - https://www.acmicpc.net/problem/27674

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            br.readLine(); // read empty line
            char[] digits = br.readLine().toCharArray();
            Arrays.sort(digits);
            StringBuilder buffer = new StringBuilder();
            for (int i=digits.length-1 ; i>0 ; i--) {
                buffer.append(digits[i]);
            }
            long operandA = Long.parseLong(buffer.toString());
            long operandB = digits[0] - '0';
            sb.append(operandA + operandB).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}