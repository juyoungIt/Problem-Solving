// BOJ - 10190
// Problem Sheet - https://www.acmicpc.net/problem/10190

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] row = br.readLine().split(" ");
            String acronym = row[0];
            sb.append(acronym).append("\n");
            int candidates = Integer.parseInt(row[1]);
            for (int i=0 ; i<candidates ; i++) {
                String candidate = br.readLine();
                String[] tokens = candidate.split(" ");
                if (!isAcronym(acronym, tokens)) continue;
                sb.append(candidate).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isAcronym(String acronym, String[] tokens) {
        if (acronym.length() != tokens.length) {
            return false;
        }
        for (int i=0 ; i<acronym.length() ; i++) {
            if (acronym.charAt(i) != tokens[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}