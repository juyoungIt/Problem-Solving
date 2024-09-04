// BOJ - 2204
// Problem Sheet - https://www.acmicpc.net/problem/2204

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            String[] words = new String[n];
            for (int j=0 ; j<n ; j++) {
                words[j] = br.readLine();
            }
            Arrays.sort(words, String::compareToIgnoreCase);
            sb.append(words[0]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}