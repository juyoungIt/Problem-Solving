// BOJ - 2083
// Problem Sheet - https://www.acmicpc.net/problem/2083

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String input = br.readLine();
            if (input.equals("# 0 0")) break;
            st = new StringTokenizer(input);
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(name).append(" ");
            if (age > 17 || weight >= 80) {
                sb.append("Senior");
            } else {
                sb.append("Junior");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
