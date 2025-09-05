// BOJ - 31799
// Problem Sheet - https://www.acmicpc.net/problem/31799

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String gs = br.readLine();
        String[] grades = parseGrades(gs, n);
        for (int i=0 ; i<n ; i++) {
            if (grades[i].equals("C+") || grades[i].equals("C0") || grades[i].equals("C-")) {
                sb.append('B');
            } else if (grades[i].equals("B0") || grades[i].equals("B-")) {
                if (i == 0 || (grades[i - 1].equals("C+")
                        || grades[i - 1].equals("C0")
                        || grades[i - 1].equals("C-"))) {
                    sb.append('D');
                } else {
                    sb.append('B');
                }
            } else if (grades[i].equals("A-") || grades[i].equals("B+")) {
                if (i == 0 || (grades[i - 1].equals("B0")
                        || grades[i - 1].equals("B-")
                        || grades[i - 1].equals("C+")
                        || grades[i - 1].equals("C0")
                        || grades[i - 1].equals("C-"))) {
                    sb.append('P');
                } else {
                    sb.append('D');
                }
            } else if (grades[i].equals("A0")) {
                if (i == 0 || (grades[i - 1].equals("A-")
                        || grades[i - 1].equals("B+")
                        || grades[i - 1].equals("B0")
                        || grades[i - 1].equals("B-")
                        || grades[i - 1].equals("C+")
                        || grades[i - 1].equals("C0")
                        || grades[i - 1].equals("C-"))) {
                    sb.append('E');
                } else {
                    sb.append('P');
                }
            } else if (grades[i].equals("A+")) {
                sb.append('E');
            } else {
                throw new IllegalArgumentException("Invalid grade!...");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isAlpha(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static String[] parseGrades(String gs, int n) {
        String[] grades = new String[n];
        int ci = 0;
        char prev = gs.charAt(0), cur = prev;
        for (int i=1 ; i<gs.length() ; i++) {
            cur = gs.charAt(i);
            if (isAlpha(prev) && isAlpha(cur)) {
                grades[ci++] = prev + "0";
            } else if (isAlpha(prev) && !isAlpha(cur)) {
                grades[ci++] = prev + "" + cur;
            }
            prev = cur;
        }
        if (isAlpha(cur)) grades[ci] = cur + "0";
        return grades;
    }
}