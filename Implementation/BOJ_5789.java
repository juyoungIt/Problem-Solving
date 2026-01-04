// BOJ - 5789
// Problem Sheet - https://www.acmicpc.net/problem/5789

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            sb.append(
                    input.charAt(input.length() / 2 - 1) == input.charAt(input.length() / 2)
                            ? "Do-it"
                            : "Do-it-Not")
                    .append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
