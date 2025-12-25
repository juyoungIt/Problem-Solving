// BOJ - 13752
// Problem Sheet - https://www.acmicpc.net/problem/13752

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            for (int i=0 ; i<k ; i++) {
                sb.append("=");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
