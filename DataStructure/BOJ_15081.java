// BOJ - 15081
// Problem Sheet - https://www.acmicpc.net/problem/15081

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<String> installed = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            String[] row = br.readLine().split(" ");
            int m = Integer.parseInt(row[0]);
            for (int j=0 ; j<m ; j++) {
                if (!installed.contains(row[j + 1])) {
                    installed.add(row[j + 1]);
                    sb.append(row[j + 1]).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}