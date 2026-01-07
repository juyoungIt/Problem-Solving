// BOJ - 13163
// Problem Sheet - https://www.acmicpc.net/problem/13163

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] token = br.readLine().split(" ");
            for (int i=0 ; i<token.length ; i++) {
                if (i == 0) sb.append("god");
                else sb.append(token[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
