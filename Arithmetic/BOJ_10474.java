// BOJ - 10474
// Problem Sheet - https://www.acmicpc.net/problem/10474

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int numerator = Integer.parseInt(st.nextToken());
            int denominator = Integer.parseInt(st.nextToken());
            if(numerator == 0 && denominator == 0) {
                break;
            }
            sb.append(numerator / denominator)
                    .append(" ")
                    .append(numerator % denominator)
                    .append(" / ")
                    .append(denominator)
                    .append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}