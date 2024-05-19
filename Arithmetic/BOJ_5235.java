// BOJ - 5235
// Problem Sheet - https://www.acmicpc.net/problem/5235

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int evenSum = 0, oddSum = 0;
            for (int j=0 ; j<n ; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number % 2 == 0) evenSum += number;
                else oddSum += number;
            }
            if (evenSum > oddSum) sb.append("EVEN").append("\n");
            else if (evenSum < oddSum) sb.append("ODD").append("\n");
            else sb.append("TIE").append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}