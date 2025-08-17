// BOJ - 28432
// Problem Sheet - https://www.acmicpc.net/problem/28432

import java.util.*;
import java.io.*;

public class Main {

    static final Set<String> used = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] log = new String[n];
        int targetIndex = 0;
        for (int i=0 ; i<n ; i++) {
            log[i] = br.readLine();
            if (log[i].equals("?")) {
                targetIndex = i;
            }
            used.add(log[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] candidates = new String[m];
        for (int i=0 ; i<m ; i++) {
            candidates[i] = br.readLine();
        }

        if (n == 1) {
            System.out.println(candidates[0]);
            return;
        }

        Character start = null;
        Character end = null;
        if (targetIndex == 0) {
            end = log[targetIndex + 1].charAt(0);
            System.out.println(search(candidates, start, end));
        } else if (targetIndex == n-1) {
            start = log[targetIndex - 1].charAt(log[targetIndex - 1].length() - 1);
            System.out.println(search(candidates, start, end));
        } else {
            start = log[targetIndex - 1].charAt(log[targetIndex - 1].length() - 1);
            end = log[targetIndex + 1].charAt(0);
            System.out.println(search(candidates, start, end));
        }

        br.close();
    }

    private static String search(String[] candidates, Character start, Character end) {
        for (String candidate : candidates) {
            if (used.contains(candidate)) continue;
            int endIndex = candidate.length() - 1;
            if (start != null && end != null) {
                if (candidate.charAt(0) == start && candidate.charAt(endIndex) == end) {
                    return candidate;
                }
            } else if (start != null) {
                if (candidate.charAt(0) == start) {
                    return candidate;
                }
            } else {
                if (candidate.charAt(endIndex) == end) {
                    return candidate;
                }
            }
        }
        return null;
    }

}