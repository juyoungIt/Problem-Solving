// BOJ - 24570
// Problem Sheet - https://www.acmicpc.net/problem/24570

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        String input = br.readLine();
        boolean isNumber = false;
        for (int i=0 ; i<input.length() ; i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (isNumber) {
                    isNumber = false;
                    sb.append(buffer).append("\n");
                    buffer.setLength(0);
                }
                buffer.append(c);
            } else {
                if (c == '+' || c == '-') {
                    buffer.append(" ");
                    buffer.append(c == '+' ? "tighten" : "loosen").append(" ");
                } else {
                    isNumber = true;
                    buffer.append(c);
                }
            }
        }
        if (buffer.length() > 0) sb.append(buffer);

        System.out.println(sb);
        br.close();
    }
}