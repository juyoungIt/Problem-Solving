// BOJ - 22351
// Problem Sheet - https://www.acmicpc.net/problem/22351

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i=1; i<=input.length(); i++) {
            String startStr = input.substring(0, i);
            int start = Integer.parseInt(startStr);
            StringBuilder sb = new StringBuilder(startStr);
            int cur = start;
            while (sb.length() < input.length()) {
                cur++;
                sb.append(cur);
            }
            if (sb.toString().equals(input)) {
                System.out.printf("%d %d", start, cur);
                break;
            }
        }
        br.close();
    }
}
