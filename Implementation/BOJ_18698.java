// BOJ - 18698
// Problem Sheet - https://www.acmicpc.net/problem/18698

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            int count = 0;
            for (int i=0 ; i<input.length() ; i++) {
                char c = input.charAt(i);
                if (c == 'D') break;
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}