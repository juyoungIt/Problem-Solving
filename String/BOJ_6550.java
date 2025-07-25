// BOJ - 6550
// Problem Sheet - https://www.acmicpc.net/problem/6550

import java.io.*;

public class Main {

    static final String YES = "Yes", NO = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            String[] row = input.split(" ");
            String s = row[0];
            String t = row[1];
            sb.append(isSubString(s, t) ? YES : NO).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isSubString(String s, String t) {
        int indexS = 0, indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            indexT++;
        }
        return indexS == s.length();
    }
}