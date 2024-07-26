// BOJ - 29934
// Problem Sheet - https://www.acmicpc.net/problem/29934

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> contacts = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            contacts.add(br.readLine());
        }

        int highlightCount = 0;
        int m = Integer.parseInt(br.readLine());
        for (int i=0 ; i<m ; i++) {
            if (contacts.contains(br.readLine())) {
                highlightCount++;
            }
        }
        System.out.println(highlightCount);

        br.close();
        System.exit(0);
    }
}