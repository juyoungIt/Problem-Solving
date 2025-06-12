// BOJ - 31824
// Problem Sheet - https://www.acmicpc.net/problem/31824

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int m = Integer.parseInt(row[1]);
        Map<String, String> dict = new HashMap<>();
        int maxLen = 0;
        for (int i=0 ; i<n ; i++) {
            row = br.readLine().split(" ");
            dict.put(row[0], row[1]);
            maxLen = Math.max(maxLen, row[0].length());
        }
        String[] words = new String[m];
        for (int i=0 ; i<m ; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            boolean isValid = false;
            for (int i=0 ; i<word.length() ; i++) {
                List<String> candidates = dict.keySet().stream().sorted().collect(Collectors.toList());
                for (String candidate : candidates) {
                    String token = word.substring(i, Math.min(i + candidate.length(), word.length()));
                    if (candidate.equals(token)) {
                        isValid = true;
                        sb.append(dict.get(candidate));
                    }
                }
            }
            sb.append(isValid ? "\n" : "-1\n");
        }

        System.out.println(sb);
        br.close();
    }
}