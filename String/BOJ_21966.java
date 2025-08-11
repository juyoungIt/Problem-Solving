// BOJ - 21966
// Problem Sheet - https://www.acmicpc.net/problem/21966

import java.util.*;
import java.io.*;

public class Main {

    static final String OMISSION = "...";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if (n <= 25) {
            System.out.println(s);
        } else {
            String front = s.substring(0, 11);
            String mid = s.substring(11, s.length() - 12);
            String back = s.substring(s.length() - 11);
            if (isOneSentence(mid)) {
                System.out.printf("%s%s%s", front, OMISSION, back);
            } else {
                front = s.substring(0, 9);
                back = s.substring(s.length() - 10);
                System.out.printf("%s%s%s", front, OMISSION + OMISSION, back);
            }
        }
        br.close();
    }

    private static boolean isOneSentence(String s) {
        int endPointCount = 0;
        char lastLetter = s.charAt(s.length() - 1);
        for (int i=0 ; i<s.length() ; i++) {
            if (s.charAt(i) == '.') endPointCount++;
        }
        return endPointCount == 0 || endPointCount == 1 && lastLetter == '.';
    }

}